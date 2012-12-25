package com.envisioncn.srm.supplier_basic.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.supplier_basic.bean.SupplierConsumer;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-30
 */
@Service("SupplierConsumerDao")
public class SupplierConsumerDao extends ABasicDao<SupplierConsumer> implements ISupplierConsumerDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(SupplierConsumer.class);
	}

}
