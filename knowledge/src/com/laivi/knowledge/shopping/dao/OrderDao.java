package com.laivi.knowledge.shopping.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.shopping.model.po.Order;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@Service("OrderDao")
public class OrderDao extends ABasicDao<Order> implements IOrderDao {
	
	@Override
	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(Order.class);
	}
	
}
