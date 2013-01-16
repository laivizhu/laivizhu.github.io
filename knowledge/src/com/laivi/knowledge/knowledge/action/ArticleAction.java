package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.knowledge.model.po.Article;
import com.laivi.knowledge.knowledge.service.IArticleService;
import com.laivi.knowledge.knowledge.service.ITagService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
@SuppressWarnings("serial")
public class ArticleAction extends ABasicAction<Article> {

	private IArticleService articleService;
	private ITagService tagService;
	private Article article;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(article.getTitle(), "error.article.title.notNULL");
		ParamAssert.isNotEmptyString(article.getTagIds(), "error.article.tag.notNULL");
		ParamAssert.isNotEmptyString(article.getContent(), "error.article.content.notNULL");
		article.setUserId(this.getCurrentUserId());
		this.articleService.add(article);
		return response(true);
	}
	
	public String update()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		ParamAssert.isNotEmptyString(article.getTitle(), "error.article.title.notNULL");
		ParamAssert.isNotEmptyString(article.getTagIds(), "error.article.tag.notNULL");
		ParamAssert.isNotEmptyString(article.getContent(), "error.article.content.notNULL");
		Article dArticle=this.articleService.getObject(id);
		dArticle.setTitle(article.getTitle());
		dArticle.setContent(article.getContent());
		dArticle.setTagIds(article.getTagIds());
		this.articleService.modify(dArticle);
		return response(true);
	}
	
	public String get()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		Article dArticle=this.articleService.getObject(id);
		JsonItem item=new JsonItem();
		item.add("id", dArticle.getId())
		.add("article.title", dArticle.getTitle())
		.add("article.content", dArticle.getContent())
		.add("article.tags", dArticle.getTagIds());
		return response(item.toFormDataString(true));
	}
	
	public JsonItem getJsonItem(Article object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("content", object.getContent())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()))
		.add("tagIds", this.tagService.getTagsName(object.getTagIds()));
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
	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}
	@Resource(name="ArticleService")
	public void setBasicService(IBasicService<Article> basicService){
    	this.basicService=basicService;
    }
	@Resource(name="TagService")
	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	}

}
