package com.laivi.knowledge.user.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.user.model.po.Group;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 10, 2013
 */
@Service("GroupDao")
public class GroupDao extends ABasicDao<Group> implements IGroupDao {
	
	@Override
	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(Group.class);
	}

}
