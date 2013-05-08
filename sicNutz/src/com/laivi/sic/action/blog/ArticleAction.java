package com.laivi.sic.action.blog;

import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.blog.Article;
import com.laivi.sic.model.to.Response;

@At("/blog/article")
@IocBean
public class ArticleAction extends ABasicDBAction<Article> {
	
	@At
	public Response add(@Param("::article.")Article article){
		dao.insert(article);
		return success();
	}
	
	@At
	public Response update(@Param("::article.")Article article){
		Article dArticle=dao.fetch(this.getEntityClass(), article.getId());
		dArticle.setContent(article.getContent());
		dArticle.setTitle(article.getTitle());
		dArticle.setTagId(article.getTagId());
		dao.update(dArticle);
		return success();
	}
	
	@At
	public Response addViewCount(long id){
		Article article=dao.fetch(this.getEntityClass(), id);
		article.setViewCount(article.getViewCount()+1);
		dao.update(article);
		return success();
	}
	
	
	@At
	public Object listAllTitle(HttpSession session){
		JsonList jsonList=new JsonList();
		this.cnd=this.getUserCnd(session);
		for(Article article:dao.query(this.getEntityClass(), cnd)){
			jsonList.add("\""+article.getTitle()+"\"");
		}
		return jsonList;
	}
	
	@At
	public Object getFold(long id,boolean fold)throws Exception{
		Article obj=dao.fetch(this.getEntityClass(),id);
		if(obj.toFormJson()==null){
			return obj.toFormJson();
		}else{
			return obj.toJsonItem(fold).toJsonForm();
		}
	}

	@Override
	public Class<Article> getEntityClass() {
		return Article.class;
	}

}
