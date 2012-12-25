package com.envisioncn.srm.material.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.material.bean.MarkDepartment;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
@Service("MarkDepartmentDao")
public class MarkDepartmentDao extends ABasicDao<MarkDepartment> implements IMarkDepartmentDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(MarkDepartment.class);
	}

}
