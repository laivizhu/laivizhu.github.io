package com.laivi.knowledge.user.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.user.model.po.AutoGraph;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 10, 2013
 */
@Service("AutoGraphDao")
public class AutoGraphDao extends ABasicDao<AutoGraph> implements IAutoGraphDao {
	
	@Override
	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(AutoGraph.class);
	}

	

}
