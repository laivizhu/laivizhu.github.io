package com.envisioncn.srm.material.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.Order;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-26
 */
@Service("OrderService")
public class OrderService extends BasicService<Order> implements IOrderService {
	@Resource(name = "OrderDao")
	public void setBasicDao(IBasicDao<Order> basicDao) {
		this.basicDao = basicDao;
	}

}
