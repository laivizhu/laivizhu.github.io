package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.knowledge.model.po.Article;
import com.laivi.knowledge.knowledge.service.IArticleService;

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
	private Article article;
	
	@Override
	public JsonItem getJsonItem(Article object) throws Exception {
		return null;
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

}
