package com.laivi.sic.action.blog;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.blog.Article;
import com.laivi.sic.model.to.Response;

@At("/blog/article")
@IocBean
public class ArticleAction extends ABasicDBAction<Article> {
	
	@At
	@CheckValue
	@CheckLogin
	public Response add(@Param("::article.")Article article){
		article.setUserId(this.getLoginUser().getUserId());
		dao.insert(article);
		return success();
	}
	
	@At
	@CheckValue
	public Response update(@Param("::article.")Article article){
		Article dArticle=dao.fetch(this.getEntityClass(), article.getId());
		dArticle.setContent(article.getContent());
		dArticle.setTitle(article.getTitle());
		dArticle.setTagId(article.getTagId());
		//this.updateValue(article, dArticle);
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
	public Object listAllTitle(){
		JsonList jsonList=new JsonList();
		this.cnd=this.getUserCnd();
		for(Article article:dao.query(this.getEntityClass(), cnd)){
			jsonList.add("\""+article.getTitle()+"\"");
		}
		return jsonList;
	}

	@Override
	public Class<Article> getEntityClass() {
		return Article.class;
	}

}
