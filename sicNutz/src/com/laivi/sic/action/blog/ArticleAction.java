package com.laivi.sic.action.blog;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.blog.Article;
import com.laivi.sic.model.po.common.FromOther;
import com.laivi.sic.model.po.common.Recommond;
import com.laivi.sic.model.po.common.SimpleDegree;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.CategoryType;
import com.laivi.sic.service.blog.ArticleService;
import com.laivi.sic.util.basic.DataUtil;

@At("/blog/article")
@IocBean
public class ArticleAction extends ABasicDBAction<Article> {
	
	@Inject
	private ArticleService articleService;
	
	@At
	@CheckValue
	@CheckLogin
	public Response add(@Param("::article.")final Article article){
		article.setUserId(this.getLoginUser().getUserId());
		articleService.add(article);
		return success();
	}
	
	@At
	@CheckLogin
	public Response delete(long id) throws Exception{
		dao.delete(basicService.get(FromOther.class, Cnd.where("objId", "=", id).and("type", "=", CategoryType.ARTICLE).and("userId","=",this.getUserId())));
		return success();
	}
	
	@At
	@CheckValue
	public Response update(@Param("::article.")Article article) throws Exception{
		Article dArticle=basicService.get(this.getEntityClass(), article.getId());
		dArticle.setContent(article.getContent());
		dArticle.setTitle(article.getTitle());
		dArticle.setTagId(article.getTagId());
		//this.updateValue(article, dArticle);
		basicService.update(dArticle);
		return success();
	}
	
	@At
	public Response addViewCount(long id) throws Exception{
		Article article=basicService.get(this.getEntityClass(), id);
		article.setViewCount(article.getViewCount()+1);
		basicService.update(article);
		return success();
	}
	
	
	@At
	public Object listAllTitle() throws Exception{
		JsonList jsonList=new JsonList();
		this.cnd=this.getUserCnd();
		String sql="select f.* from sic_fromother f,sic_article a where f.objId=a.id and f.type='ARTICLE' and a.userId="+this.getUserId()+" order by createDate desc";
		for(FromOther obj:basicService.list(FromOther.class, sql,null)){
			jsonList.add("\""+articleService.get(Article.class, obj.getObjId()).getTitle()+"\"");
			
		}
		return jsonList;
	}
	
	@At
	public Object getHotArticles() throws Exception{
		/*JsonList jsonList=new JsonList();
		for(Article article:basicService.list(Article.class, Cnd.orderBy().desc("viewCount").desc("createDate"),dao.createPager(1, AppConstants.Blog.pageSize))){
			jsonList.add(this.getJsonItem(article, true));
		}
		return jsonList;*/
		String sql="SELECT a.*,count(*) replyCount from sic_article a LEFT OUTER JOIN sic_reply r on a.id=r.objId and r.type='ARTICLE' GROUP BY a.id ORDER BY replyCount desc,viewCount desc,createDate desc";
		return list(basicService.createPager(1, AppConstants.Blog.pageSize),sql,null);
	}
	
	@At
	public Object getRandomArticle() throws Exception{
		String sql="select a.* from sic_article a order by rand()";
		return list(basicService.createPager(1, AppConstants.Blog.pageSize),sql,null);
	}
	
	@At
	public Object getNewArticle(@Param("::page.")Pager page) throws Exception{
		return list(page,Cnd.where("deleteIs", "=", false).desc("createDate"));
	}
	
	@At
	public Object getArticleByTag(long tagId)throws Exception{
		String sql="select a.* from sic_article a where tagId="+tagId+" order by createDate desc";
		return list(basicService.createPager(1, AppConstants.Blog.pageSize),sql,null);
	}
	
	@At
	public Object getHightScoreArticle()throws Exception{
		String sql="SELECT a.*,AVG(r.score) replyScore from sic_article a LEFT OUTER JOIN sic_ratescore r on a.id=r.objectId and r.type='ARTICLE' GROUP BY a.id ORDER BY replyScore desc,viewCount desc,createDate desc";
		return list(basicService.createPager(1, AppConstants.Blog.pageSize),sql,null);
	}
	
	@At
	public Object getRecommArticle()throws Exception{
		JsonList jsonList=new JsonList();
		for(Recommond recomm:basicService.list(Recommond.class, Cnd.where("type", "=",CategoryType.ARTICLE).desc("createDate"))){
			jsonList.add(this.getJsonItem(basicService.get(Article.class, recomm.getObjId()), false));
		}
		return jsonList;
	}
	
	@At
	public Object getProposal(long id) throws Exception{
		JsonList jsonList=new JsonList();
		SimpleDegree simple=basicService.get(SimpleDegree.class, Cnd.where("objId", "=", id).and("type", "=", CategoryType.ARTICLE));
		if(simple!=null){
			for(long aId:DataUtil.changeIdString(simple.getSimpleIds())){
				if(aId!=0){
					jsonList.add(this.getJsonItem(basicService.get(Article.class, aId), true));
				}
			}
		}
		
		jsonList.setSize();
		return jsonList;
	}
	
	@At
	public Object search(@Param("::page.")Pager page,String key,String value) throws Exception{
		value=this.encodeString(value);
		String where="where f.objId=a.id and f.type='ARTICLE' and a."+key+" like '%"+value+"%' order by f.id desc";
		String sql="select f.* from sic_fromother f,sic_article a "+where;
		JsonList jsonList=new JsonList();
		for(FromOther obj:basicService.list(FromOther.class, sql, page)){
			JsonItem item=this.getJsonItem(FromOther.class,obj,true);
			item.add("article", this.getJsonItem(basicService.get(Article.class, obj.getObjId()), true));
			jsonList.add(item);
		}
		sql="select count(*) from sic_fromother f,sic_article a "+where;
		jsonList.setTotalProperty(basicService.getCount(FromOther.class, sql));
		return jsonList;
	}
	
	@At
	@CheckLogin
	public Object listByTag(@Param("::page.")Pager page,long tagId) throws Exception{
		String sql="select f.* from sic_fromother f,sic_article a where f.objId=a.id and f.type='ARTICLE' and a.tagId="+tagId+" and f.userId="+this.getUserId()+" order by createDate desc";
		JsonList jsonList=new JsonList();
		for(FromOther obj:basicService.list(FromOther.class, sql, page)){
			JsonItem item=this.getJsonItem(FromOther.class,obj,true);
			item.add("article", this.getJsonItem(basicService.get(Article.class, obj.getObjId()), true));
			jsonList.add(item);
		}
		sql="select count(*) from sic_fromother f,sic_article a where f.objId=a.id and f.type='ARTICLE' and a.tagId="+tagId+" and f.userId="+this.getUserId();
		jsonList.setTotalProperty(basicService.getCount(FromOther.class, sql));
		return jsonList;
	}

	@Override
	public Class<Article> getEntityClass() {
		return Article.class;
	}

}
