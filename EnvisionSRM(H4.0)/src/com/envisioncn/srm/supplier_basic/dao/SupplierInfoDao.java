package com.envisioncn.srm.supplier_basic.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.supplier_basic.bean.SupplierInfo;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
@Service("SupplierInfoDao")
public class SupplierInfoDao extends ABasicDao<SupplierInfo> implements ISupplierInfoDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(SupplierInfo.class);
	}

}
