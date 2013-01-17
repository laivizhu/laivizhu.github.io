package com.laivi.knowledge.shopping.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.shopping.model.po.ShoppingItem;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@Service("ShoppingItemDao")
public class ShoppingItemDao extends ABasicDao<ShoppingItem> implements IShoppingItemDao {
	
	@Override
	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(ShoppingItem.class);
	}
	
}
