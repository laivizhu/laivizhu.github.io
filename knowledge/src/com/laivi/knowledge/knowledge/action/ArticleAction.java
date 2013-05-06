package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.annotation.HistoryRecordTag;
import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.common.model.type.FavoriteType;
import com.laivi.knowledge.common.service.ITagService;
import com.laivi.knowledge.knowledge.model.po.Article;
import com.laivi.knowledge.user.service.IUserService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
@SuppressWarnings("serial")
public class ArticleAction extends ABasicAction<Article> {

	private ITagService tagService;
	private IUserService userService;
	private Article article;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(article.getTitle(), "error.article.title.notNULL");
		ParamAssert.isNotEmptyString(article.getTagIds(), "error.article.tag.notNULL");
		ParamAssert.isNotEmptyString(article.getContent(), "error.article.content.notNULL");
		article.setUserId(this.getCurrentUserId());
		this.basicService.add(article);
		return response(true);
	}
	
	public String update()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		ParamAssert.isNotEmptyString(article.getTitle(), "error.article.title.notNULL");
		ParamAssert.isNotEmptyString(article.getTagIds(), "error.article.tag.notNULL");
		ParamAssert.isNotEmptyString(article.getContent(), "error.article.content.notNULL");
		Article dArticle=this.basicService.getObject(id);
		dArticle.setTitle(article.getTitle());
		dArticle.setContent(article.getContent());
		dArticle.setTagIds(article.getTagIds());
		this.basicService.modify(dArticle);
		return response(true);
	}
	
	@HistoryRecordTag(type=FavoriteType.ARTICLE)
	public String get()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		Article dArticle=this.basicService.getObject(id);
		JsonItem item=null;
		if(font){
			item=this.getJsonItem(dArticle,fold);
		}else{
			item=new JsonItem();
			item.add("id", dArticle.getId())
			.add("article.title", dArticle.getTitle())
			.add("article.content", dArticle.getContent())
			.add("article.tags", dArticle.getTagIds());
		}
		
		return response(item.toFormDataString(true));
	}

    public String addViewCount()throws Exception{
        ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
        Article dArticle=this.basicService.getObject(id);
        dArticle.setViewCount(dArticle.getViewCount()+1);
        this.basicService.modify(dArticle);
        return response(true);
    }
	
	public String getIndexList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		CriterionList conditions=CriterionList.CreateCriterion().put(Order.desc("createDate"));
		for(Article article:this.basicService.getList(conditions, 0, AppConstants.INDEXSIZE)){
			jsonList.createItem().add("url", "knowledge/article_view.jsp?id="+article.getId())
			.add("title", DataUtil.getDefaultChar(article.getTitle(),10)).add("createDate", DateUtil.formatDate(article.getCreateDate()));
		}
		return response(jsonList);
	}
	
	public String listAllTitle()throws Exception{
		JsonList jsonList=new JsonList();
		this.conditions=this.getUserCriterionList();
		for(Article article:this.basicService.getList(conditions)){
			jsonList.add("\""+article.getTitle()+"\"");
		}
		return response(jsonList);
	}
	
	public JsonItem getJsonItem(Article object,boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("content", isSub?DataUtil.getDefaultChar(object.getContent()):object.getContent())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()))
		.add("user", this.userService.getObject(object.getUserId()).getUserName())
		.add("tagIds", object.getTagIds());
		return item;
	}
	
	public JsonItemList getSearchComboList()throws ErrorException{
		JsonItemList jsonList=new JsonItemList();
		jsonList.createItem().add("value", "title").add("text", "标题");
		jsonList.createItem().add("value", "content").add("text", "内容");
		return jsonList;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Resource(name="ArticleService")
	public void setBasicService(IBasicService<Article> basicService){
    	this.basicService=basicService;
    }
	@Resource(name="TagService")
	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	}
	@Resource(name="UserService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	

}
