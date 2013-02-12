package com.laivi.knowledge.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.user.model.po.Message;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午2:08
 */
@Service("MessageService")
public class MessageService extends BasicService<Message> implements IMessageService {
	@Resource(name="KnowledgeDao")
    public void setBasicDao(IBasicDao<Message> basicDao){
        this.basicDao=basicDao;
    }
	
}
