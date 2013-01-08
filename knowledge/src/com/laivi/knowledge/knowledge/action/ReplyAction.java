package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.knowledge.model.po.Reply;
import com.laivi.knowledge.knowledge.service.IReplyService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
@SuppressWarnings("serial")
public class ReplyAction extends ABasicAction<Reply> {

	private IReplyService replyService;
	private Reply reply;
	
	public JsonItem getJsonItem(Reply object) throws Exception {
		return null;
	}
	
	public JsonItemList getSearchComboList()throws ErrorException{
		JsonItemList jsonList=new JsonItemList();
		return jsonList;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	@Resource(name="ReplyService")
	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}
	@Resource(name="ReplyService")
	public void setBasicService(IBasicService<Reply> basicService){
    	this.basicService=basicService;
    }

}
