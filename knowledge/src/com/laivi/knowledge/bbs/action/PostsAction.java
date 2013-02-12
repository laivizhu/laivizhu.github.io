package com.laivi.knowledge.bbs.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.bbs.model.po.Posts;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
@SuppressWarnings("serial")
public class PostsAction extends ABasicAction<Posts> {

	private Posts posts;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(posts.getContent(), "");
		posts.setUserId(this.getCurrentUserId());
		posts.setParent(false);
		if(DataUtil.notEmptyString(posts.getTitle())){
			posts.setParentId(0);
		}else{
			Posts parent=this.basicService.getObject(posts.getParentId());
			parent.setParent(true);
			this.basicService.modify(parent);
		}
		this.basicService.add(posts);
		return response(true);
	}
	
	public String delete()throws Exception{
		
		return response();
	}
	
	public String view()throws Exception{
		
		return response();
	}
	
	
	
	public JsonItem getJsonItem(Posts object,boolean isSub) throws Exception {
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
	public void setBasicService(IBasicService<Posts> basicService){
    	this.basicService=basicService;
    }

}
