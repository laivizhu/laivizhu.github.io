package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.po.common.Message;
import com.laivi.sic.model.type.MessageType;
import com.laivi.sic.model.type.Status;

@IocBean
@At("/common/message")
public class MessageAction extends ABasicDBAction<Message> {

	@At
	public Object listFriendMessage(@Param("::page")Pager page) throws Exception{
		return list(page,Cnd.where("type", "=", MessageType.REQUEST).and("toUserId", "=", this.getUserId()).and("status", "=", Status.UNREAD),true);
	}
	
	@Override
	public Class<Message> getEntityClass() {
		return Message.class;
	}

}
