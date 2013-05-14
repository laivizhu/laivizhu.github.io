package com.laivi.sic.action.blog;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.blog.Article;
import com.laivi.sic.model.po.common.FromOther;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.CategoryType;

@At("/blog/article")
@IocBean
public class ArticleAction extends ABasicDBAction<Article> {
	
	@At
	@CheckValue
	@CheckLogin
	public Response add(@Param("::article.")final Article article){
		article.setUserId(this.getLoginUser().getUserId());
		Trans.exec(new Atom(){
			@Override
			public void run() {
				FromOther fromOther=new FromOther();
				dao.insert(article);
				fromOther.setObjId(article.getId());
				fromOther.setUserId(article.getUserId());
				fromOther.setType(CategoryType.ARTICLE);
				fromOther.setSelfIs(true);
				dao.insert(fromOther);
			}
			
		});
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
	@At
	public Object getAll(@Param("::page.")Pager page){
		return list(page,Cnd.where("deleteIs","=", false).and("type", "=",CategoryType.ARTICLE).and("selfIs", "=", true).desc("createDate"));
	}

	@Override
	@At
	public Object list(@Param("::page.")Pager page) throws Exception {
		Cnd condition=this.getBasicCnd().and("type", "=",CategoryType.ARTICLE);
		if(this.isSys()){
			this.cnd= condition.and("selfIs", "=", true).desc("createDate");
		}else{
			this.cnd= condition.desc("createDate");
		}
		return list(page,cnd);
	}

	@Override
	protected JsonList list(Pager page, Condition cnd) {
		JsonList jsonList=new JsonList();
		for(FromOther obj:dao.query(FromOther.class,cnd,page)){
			JsonItem item=this.getJsonItem(FromOther.class,obj,true);
			item.add("article", this.getJsonItem(dao.fetch(Article.class, obj.getObjId()), true));
			jsonList.add(item);
		}
		jsonList.setTotalProperty(dao.count(FromOther.class, cnd));
		return jsonList;
	}

	@Override
	public Class<Article> getEntityClass() {
		return Article.class;
	}

}
