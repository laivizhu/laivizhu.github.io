package com.laivi.knowledge.knowledge.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.knowledge.model.po.Reply;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午2:08
 */
@Service("ReplyService")
public class ReplyService extends BasicService<Reply> implements IReplyService {
	@Resource(name="ReplyDao")
    public void setBasicDao(IBasicDao<Reply> basicDao){
        this.basicDao=basicDao;
    }
	
}
