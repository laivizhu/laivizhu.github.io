package com.laivi.knowledge.shopping.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.shopping.model.po.ShoppingItem;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@Service("ShoppingItemService")
public class ShoppingItemService extends BasicService<ShoppingItem> implements IShoppingItemService {

	@Resource(name="ShoppingItemDao")
	public void setBasicDao(IBasicDao<ShoppingItem> basicDao){
		this.basicDao=basicDao;
	}

}
