package com.laivi.knowledge.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.user.model.po.Friends;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 10, 2013
 */
@Service("FriendsService")
public class FriendsService extends BasicService<Friends> implements IFriendsService {

	@Resource(name="FriendsDao")
    public void setBasicDao(IBasicDao<Friends> basicDao){
        this.basicDao=basicDao;
    }
	
}
