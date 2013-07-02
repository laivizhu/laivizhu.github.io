package com.laivi.sic.action.system;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.blog.Article;
import com.laivi.sic.model.po.common.Recommond;
import com.laivi.sic.model.po.common.SimpleDegree;
import com.laivi.sic.model.po.system.News;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.CategoryType;
import com.laivi.sic.model.type.ViewNewsType;
import com.laivi.sic.service.system.NewsService;
import com.laivi.sic.util.basic.DataUtil;
import com.laivi.sic.util.basic.HTMLUtil;


@IocBean
@At("/system/news")
public class NewsAction extends ABasicDBAction<News> {
	
	@Inject
	private NewsService newsService;
	
	@CheckLogin
	@CheckValue
	@At
	public Response add(@Param("::news.")News news) throws Exception{
		news.setUserId(this.getUserId());
		this.newsService.add(news);
		return success();
	}
	
	@At
	@CheckLogin
	@CheckValue
	public Response update(@Param("::news.")News news)throws Exception{
		News dNews=this.basicService.get(News.class, news.getId());
		dNews.setContent(news.getContent());
		dNews.setTitle(news.getTitle());
		dNews.setTagId(news.getTagId());
		this.basicService.update(dNews);
		return success();
	}
	
	@At
	@CheckLogin
	public Response delete(long id)throws Exception{
		this.basicService.delete(News.class, id);
		this.basicService.delete(Recommond.class, Cnd.where("type", "=", CategoryType.NEWS).and("objId", "=", id));
		for(SimpleDegree degree:this.basicService.list(SimpleDegree.class, Cnd.where("simpleIds", "like", "%,"+id+",%").or("simpleIds","like",id+",%").or("simpleIds", "like", "%,"+id))){
			for(long aId:DataUtil.changeIdString(degree.getSimpleIds())){
				if(aId==id){
					
				}
			}
		}
		return success();
	}
	
	@At
	public Response addViewCount(long id) throws Exception{
		News news=this.basicService.get(News.class, id);
		news.setViewCount(news.getViewCount()+1);
		this.basicService.update(news);
		return success();
	}
	
	@At
	public Object listAllTitle() throws Exception{
		JsonList jsonList=new JsonList();
		for(News news:basicService.list(News.class,null)){
			jsonList.add("\""+news.getTitle()+"\"");
		}
		return jsonList;
	}
	
	@At
	public Object getRoundNews(long id)throws Exception{
		JsonItem item=new JsonItem();
		item.add("pre", dao.fetch(News.class, Cnd.where("id","<",id).desc("id")));
		item.add("next", dao.fetch(News.class,  Cnd.where("id",">",id).asc("id")));
		return item.toJsonForm();
	}
	
	@At
	public Object listByTag(ViewNewsType type,@Param("::page.")Pager page,long tagId)throws Exception{
		String sql;
		String where="";
		if(tagId!=0){
			sql="select a.* from sic_news a where tagId="+tagId+"  order by createDate desc";
			where=" where tagId="+tagId;
		}else{
			if(type!=null){
				sql=type.toSql();
			}else{
				sql="select a.* from sic_news a order by createDate desc";
			}
		}
		JsonList jsonList=new JsonList();
		for(News news:basicService.list(News.class, sql, page)){
			JsonItem item=this.getJsonItem(news, true);
			String imgUrl=HTMLUtil.getImageUrl(news.getContent());
			if(imgUrl==null){
				imgUrl="/sicNutz/upload/picture/default.jpg";
			}
			item.add("path",imgUrl);
			jsonList.add(item);
		}
		jsonList.setTotalProperty(basicService.getCount(Article.class,"select count(*) from sic_news"+where));
		return jsonList;
	}
	
	@At
	public Object getRecommNews(@Param("::page.")Pager page) throws Exception{
		JsonList jsonList=new JsonList();
		for(Recommond recomm:this.basicService.list(Recommond.class, Cnd.where("type", "=", CategoryType.NEWS), page)){
			JsonItem item=new JsonItem();
			News news=this.basicService.get(News.class, recomm.getObjId());
			String imgUrl=HTMLUtil.getImageUrl(news.getContent());
			if(imgUrl==null){
				imgUrl="/sicNutz/upload/picture/default.jpg";
			}
			item.add("path",imgUrl);
			item.add("title", news.getTitle());
			item.add("description", DataUtil.getDefaultChar(news.getContent(),50));
			item.add("url", "news_view.jsp?id="+recomm.getObjId());
			jsonList.add(item);
		}
		jsonList.setSize();
		return jsonList;
	}
	
	@At
	public Object search(@Param("::page.")Pager page,String key,String value) throws Exception{
		value=this.encodeString(value);
		String where=" where "+key+" like '%"+value+"%' order by id desc";
		String sql="select * from sic_news "+where;
		JsonList jsonList=new JsonList();
		for(News news:basicService.list(News.class, sql, page)){
			JsonItem item=this.getJsonItem(news, true);
			String imgUrl=HTMLUtil.getImageUrl(news.getContent());
			if(imgUrl==null){
				imgUrl="/sicNutz/upload/picture/default.jpg";
			}
			item.add("path",imgUrl);
			jsonList.add(item);
		}
		sql="select count(*) from sic_news "+where;
		jsonList.setTotalProperty(basicService.getCount(Article.class, sql));
		return jsonList;
	}
	
	@Override
	public Class<News> getEntityClass() {
		return News.class;
	}

}
