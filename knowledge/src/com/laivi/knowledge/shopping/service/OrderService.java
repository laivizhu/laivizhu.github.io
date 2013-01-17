package com.laivi.knowledge.shopping.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.shopping.model.po.Order;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@Service("OrderService")
public class OrderService extends BasicService<Order> implements IOrderService {

	@Resource(name="OrderDao")
	public void setBasicDao(IBasicDao<Order> basicDao){
		this.basicDao=basicDao;
	}

}
