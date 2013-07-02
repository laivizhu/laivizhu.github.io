package com.laivi.sic.action.blog;

import java.util.List;

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
import com.laivi.sic.model.po.common.FromOther;
import com.laivi.sic.model.po.common.Recommond;
import com.laivi.sic.model.po.common.SimpleDegree;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.CategoryType;
import com.laivi.sic.model.type.ViewArticleType;
import com.laivi.sic.model.type.ViewAuth;
import com.laivi.sic.service.blog.ArticleService;
import com.laivi.sic.util.basic.DataUtil;
import com.laivi.sic.util.basic.HTMLUtil;

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
		dArticle.setAuth(article.getAuth());
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
	public Object listAllTitle(boolean isAll) throws Exception{
		JsonList jsonList=new JsonList();
		if(isAll){
			for(Article article:articleService.list(Article.class, Cnd.where("deleteIs", "=", false).and("auth", "=", ViewAuth.PUBLIC))){
				jsonList.add("\""+article.getTitle()+"\"");
			}
		}else{
			this.cnd=this.getUserCnd();
			String sql="select f.* from sic_fromother f,sic_article a where f.objId=a.id and f.type='ARTICLE' and a.userId="+this.getUserId()+" order by createDate desc";
			for(FromOther obj:basicService.list(FromOther.class, sql,null)){
				jsonList.add("\""+articleService.get(Article.class, obj.getObjId()).getTitle()+"\"");
			}
		}
		return jsonList;
	}
	
	@At
	public Object getRoundArticle(long id)throws Exception{
		JsonItem item=new JsonItem();
		if(!this.isLogined()){
			item.add("pre", dao.fetch(Article.class, Cnd.where("id","<",id).desc("id")));
			item.add("next", dao.fetch(Article.class,  Cnd.where("id",">",id).asc("id")));
		}else{
			String sql="select a.* from sic_article a,sic_fromother f where a.id=f.objId and f.type='ARTICLE'and a.id>"+id+" and f.userId="+this.getUserId()+" order by a.id  limit 1 ";
			List<Article> articleList=basicService.list(Article.class, sql,null);
			if(articleList.size()>0){
				item.add("next", articleList.get(0));
			}
			sql="select a.* from sic_article a,sic_fromother f where a.id=f.objId and f.type='ARTICLE'and a.id<"+id+" and f.userId="+this.getUserId()+" order by a.id desc  limit 1 ";
			articleList=basicService.list(Article.class, sql,null);
			if(articleList.size()>0){
				item.add("pre", articleList.get(0));
			}
		}
		return item.toJsonForm();
	}
	
	@At
	public Object getArticleByType(ViewArticleType type,@Param("::page.")Pager page,long tagId) throws Exception{
		String sql;
		String where=" where auth='PUBLIC' ";
		if(tagId!=0){
			sql="select a.* from sic_article a"+where+"and tagId="+tagId+"  order by createDate desc";
			where+="and tagId="+tagId;
		}else{
			if(type!=null){
				sql=type.toSql();
			}else{
				sql="select a.* from sic_article a order by createDate desc";
			}
		}
		JsonList jsonList=new JsonList();
		for(Article article:basicService.list(Article.class, sql, page)){
			JsonItem item=this.getJsonItem(article, true);
			String imgUrl=HTMLUtil.getImageUrl(article.getContent());
			if(imgUrl==null){
				imgUrl="/sicNutz/upload/picture/default.jpg";
			}
			item.add("path",imgUrl);
			jsonList.add(item);
		}
		jsonList.setTotalProperty(basicService.getCount(Article.class," select count(*) from sic_article"+where));
		return jsonList;
	}
	
	
	@At
	public Object getRecommArticle(@Param("::page.")Pager page)throws Exception{
		JsonList jsonList=new JsonList();
		for(Recommond recomm:basicService.list(Recommond.class, Cnd.where("type", "=",CategoryType.ARTICLE).desc("createDate"),page)){
			JsonItem item=new JsonItem();
			Article article=basicService.get(Article.class, recomm.getObjId());
			//item.add("path","/sicNutz/upload/picture/"+ recomm.getPath());
			String imgUrl=HTMLUtil.getImageUrl(article.getContent());
			if(imgUrl==null){
				imgUrl="/sicNutz/upload/picture/default.jpg";
			}
			item.add("path",imgUrl);
			item.add("title", article.getTitle());
			item.add("description", DataUtil.getDefaultChar(article.getContent(),50));
			item.add("url", "article_view.jsp?id="+recomm.getObjId());
			jsonList.add(item);
		}
		jsonList.setSize();
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
			Article article=basicService.get(Article.class, obj.getObjId());
			item.add("article", this.getJsonItem(article, true));
			String imgUrl=HTMLUtil.getImageUrl(article.getContent());
			if(imgUrl==null){
				imgUrl="/sicNutz/upload/picture/default.jpg";
			}
			item.add("path",imgUrl);
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
