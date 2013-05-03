package com.laivi.sic.action.blog;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
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
	
	public Object listAllTitle(){
		
		return null;
	}

	@Override
	public Class<Article> getEntityClass() {
		return Article.class;
	}

}
