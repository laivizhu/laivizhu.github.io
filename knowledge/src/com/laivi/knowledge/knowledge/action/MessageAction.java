package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.knowledge.model.po.Message;
import com.laivi.knowledge.knowledge.service.IMessageService;

import java.util.Date;

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

    public String add()throws Exception{
        ParamAssert.isNotEmptyString(message.getTitle(),"");
        ParamAssert.isNotEmptyString(message.getContent(),"");
        ParamAssert.isTrue(message.getToUserId() != 0, "");
        message.setCreateDate(new Date());
        message.setUserId(this.getCurrentUserId());
        message.setReadIs(false);
        this.messageService.add(message);
        return response(true);
    }
	
	@Override
	public JsonItem getJsonItem(Message object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("content", object.getContent())
        .add("readIs",object.isReadIs())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()));
		return item;
	}
	
	public JsonList getSearchComboList()throws ErrorException{
		JsonList jsonList=new JsonList();
        jsonList.createItem().add("value","").add("text","");
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
