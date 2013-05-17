package com.laivi.sic.service.common;

import org.nutz.ioc.loader.annotation.IocBean;

import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.po.common.Message;
import com.laivi.sic.model.po.user.User;
import com.laivi.sic.model.type.MessageType;
import com.laivi.sic.service.basic.BasicDBService;

@IocBean
public class MessageService extends BasicDBService{
	
	public void sendSystemMessage(String msg,String title,long toUserId){
		dao.insert(new Message(AppConstants.SYSTEM_USER_ID,toUserId,msg,title));
	}
	
	public void sendMessage(String msg,String title,long toUserId,long fromUserId){
		dao.insert(new Message(fromUserId,toUserId,msg,title));
	}
	
	public void sendAddFriendMessage(long userId,long friendId){
		Message message=new Message();
		User user=dao.fetch(User.class, userId);
		User friend=dao.fetch(User.class, friendId);
		message.setUserId(userId);
		message.setToUserId(friendId);
		message.setTitle("申请加好友");
		message.setContent(user.getName()+"向"+friend.getName()+"申请加为好友，是否同意？");
		message.setType(MessageType.REQUEST);
		dao.insert(message);
	}
	
}
