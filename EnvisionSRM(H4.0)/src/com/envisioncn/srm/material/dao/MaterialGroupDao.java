/**
 * 
 */
package com.envisioncn.srm.material.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.material.bean.MaterialGroup;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-18
 */
@Service("MaterialGroupDao")
public class MaterialGroupDao extends ABasicDao<MaterialGroup> implements IMaterialGroupDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(MaterialGroup.class);
	}

}
