package com.envisioncn.srm.supplier_basic.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.supplier_basic.bean.SupplierBasic;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
@Service("SupplierBasicDao")
public class SupplierBasicDao extends ABasicDao<SupplierBasic> implements ISupplierBasicDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(SupplierBasic.class);
	}

}
