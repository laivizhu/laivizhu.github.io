package com.envisioncn.srm.supplier_basic.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.supplier_basic.bean.SupplierRFI;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-30
 */
@Service("SupplierRFIDao")
public class SupplierRFIDao extends ABasicDao<SupplierRFI> implements ISupplierRFIDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(SupplierRFI.class);
	}

}
