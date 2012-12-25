package com.envisioncn.srm.material.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.material.bean.MarkWeight;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
@Service("MarkWeightDao")
public class MarkWeightDao extends ABasicDao<MarkWeight> implements IMarkWeightDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(MarkWeight.class);
	}

}
