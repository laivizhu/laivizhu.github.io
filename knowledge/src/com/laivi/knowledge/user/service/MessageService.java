package com.laivi.knowledge.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.user.dao.IUserDao;
import com.laivi.knowledge.user.model.po.Message;
import com.laivi.knowledge.user.model.po.User;
import com.laivi.knowledge.user.model.type.MessageType;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午2:08
 */
@Service("MessageService")
public class MessageService extends BasicService<Message> implements IMessageService {

	public void sendAddFriendMessage(long userId,long friendId)throws ErrorException{
		Message message=new Message();
		User user=userDao.getObject(userId);
		User friend=userDao.getObject(friendId);
		message.setUserId(userId);
		message.setToUserId(friendId);
		message.setTitle("申请加好友");
		message.setContent(user.getUserName()+"向"+friend.getUserName()+"申请加为好友，是否同意？");
		message.setType(MessageType.REQUEST.toValue());
		basicDao.add(message);
	}
	
	private IUserDao userDao;
	
	@Resource(name="MessageDao")
    public void setBasicDao(IBasicDao<Message> basicDao){
        this.basicDao=basicDao;
    }
	
	@Resource(name="UserDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
}
