package com.laivi.knowledge.user.action;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.Message;
import com.laivi.knowledge.user.model.type.MessageType;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
@SuppressWarnings("serial")
public class MessageAction extends ABasicAction<Message> {

	private Message message;

    public String add()throws Exception{
        ParamAssert.isNotEmptyString(message.getTitle(),"");
        ParamAssert.isNotEmptyString(message.getContent(),"");
        ParamAssert.isTrue(message.getToUserId() != 0, "");
        message.setUserId(this.getCurrentUserId());
        message.setReadIs(false);
        this.basicService.add(message);
        return response(true);
    }
	
	public JsonItem getJsonItem(Message object,boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("content", object.getContent())
        .add("readIs",object.isReadIs())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()));
		return item;
	}
	
	public JsonItemList getSearchComboList()throws ErrorException{
		JsonItemList jsonList=new JsonItemList();
        jsonList.createItem().add("value","").add("text","");
		return jsonList;
	}
	
	public String list()throws Exception{
		return response();
	}
	
	public String listFriendMessage()throws Exception{
		this.conditions=CriterionList.CreateCriterion()
				.put(Restrictions.eq("type", MessageType.REQUEST))
				.put(Restrictions.eq("toUserId",this.getCurrentUserId()))
				.put(Restrictions.eq("readIs",false));
		return response(list(true,false));
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Resource(name="MessageService")
	public void setBasicService(IBasicService<Message> basicService){
    	this.basicService=basicService;
    }
}
