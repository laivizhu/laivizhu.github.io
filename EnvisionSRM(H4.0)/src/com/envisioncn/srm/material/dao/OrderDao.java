package com.envisioncn.srm.material.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.material.bean.Order;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
@Service("OrderDao")
public class OrderDao extends ABasicDao<Order> implements IOrderDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(Order.class);
	}

}
