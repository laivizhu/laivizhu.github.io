package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.knowledge.model.po.Message;
import com.laivi.knowledge.knowledge.service.IMessageService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
@SuppressWarnings("serial")
public class MessageAction extends ABasicAction<Message> {

	private IMessageService messageService;
	private Message message;
	
	@Override
	public JsonItem getJsonItem(Message object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("content", object.getContent())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()));
		return item;
	}
	
	public JsonList getSearchComboList()throws ErrorException{
		JsonList jsonList=new JsonList();
		return jsonList;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Resource(name="MessageService")
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	@Resource(name="MessageService")
	public void setBasicService(IBasicService<Message> basicService){
    	this.basicService=basicService;
    }

}
