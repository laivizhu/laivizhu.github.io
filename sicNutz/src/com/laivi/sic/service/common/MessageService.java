package com.laivi.sic.service.common;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.po.common.Message;

@IocBean
public class MessageService{
	@Inject
	private Dao dao;
	
	public void sendSystemMessage(String msg,String title,long toUserId){
		dao.insert(new Message(AppConstants.SYSTEM_USER_ID,toUserId,msg,title));
	}
	
	public void sendMessage(String msg,String title,long toUserId,long fromUserId){
		dao.insert(new Message(fromUserId,toUserId,msg,title));
	}
	
	
}
