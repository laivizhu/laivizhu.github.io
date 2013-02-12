package com.laivi.knowledge.user.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.user.model.po.Friends;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 10, 2013
 */
@Service("FriendsDao")
public class FriendsDao extends ABasicDao<Friends> implements IFriendsDao{
	
	@Override
	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(Friends.class);
	}

}
