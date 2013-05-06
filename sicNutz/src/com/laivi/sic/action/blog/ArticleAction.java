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
	public Object listAllTitle(HttpSession session){
		JsonList jsonList=new JsonList();
		this.cnd=this.getUserCnd(session);
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
