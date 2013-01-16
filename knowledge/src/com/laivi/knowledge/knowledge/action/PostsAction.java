package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.knowledge.model.po.Posts;
import com.laivi.knowledge.knowledge.service.IPostsService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
@SuppressWarnings("serial")
public class PostsAction extends ABasicAction<Posts> {

	private IPostsService postsService;
	private Posts posts;
	
	public JsonItem getJsonItem(Posts object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId());
		return item;
	}
	
	public JsonItemList getSearchComboList()throws ErrorException{
		JsonItemList jsonList=new JsonItemList();
		return jsonList;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	@Resource(name="PostsService")
	public void setPostsService(IPostsService postsService) {
		this.postsService = postsService;
	}
	@Resource(name="PostsService")
	public void setBasicService(IBasicService<Posts> basicService){
    	this.basicService=basicService;
    }

}
