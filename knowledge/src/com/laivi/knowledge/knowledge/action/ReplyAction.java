package com.laivi.knowledge.knowledge.action;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.knowledge.model.po.Reply;
import com.laivi.knowledge.knowledge.service.IReplyService;
import com.laivi.knowledge.user.service.IUserService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
.
 */
@SuppressWarnings("serial")
public class ReplyAction extends ABasicAction<Reply> {

	private IReplyService replyService;
	private Reply reply;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(reply.getContext(), "");
		reply.setCreateDate(new Date());
		reply.setUserId(this.getCurrentUserId());
		replyService.add(reply);
		return response(true);
	}
	public String list()throws Exception{
		JsonList jsonList=new JsonList();
		CriterionList conditions=CriterionList.CreateCriterion().put(Restrictions.eq("articleId", id));
		for(Reply reply:this.replyService.getList(conditions, start, limit)){
			jsonList.add(this.getJsonItem(reply).toString());
		}
		return response(jsonList.toPageString(this.replyService.getCount(conditions)));
	}
	
	
	public JsonItem getJsonItem(Reply object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId()).add("content", object.getContext()).add("createDate", DateUtil.formatDate(object.getCreateDate()))
		.add("user", this.userService.getObject(object.getUserId()).getUserName());
		return item;
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
	@Resource(name="UserService")
	public void setUserService(IUserService userService){
		this.userService=userService;
	}

}
