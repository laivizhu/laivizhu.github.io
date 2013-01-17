package com.laivi.knowledge.shopping.action;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.shopping.model.po.ShoppingItem;
import com.laivi.knowledge.shopping.service.ICommodityService;
import com.laivi.knowledge.shopping.service.IOrderService;
import com.laivi.knowledge.shopping.service.IShoppingItemService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@SuppressWarnings("serial")
public class ShoppingItemAction extends ABasicAction<ShoppingItem> {
	private IShoppingItemService shoppingItemService;
	private ICommodityService commodityService;
	private IOrderService orderService;
	private ShoppingItem shoppingItem;
	private long commodityId;
	
	public String add()throws Exception{
		ParamAssert.isTrue(shoppingItem.getPrice()>0, "");
		ParamAssert.isTrue(commodityId>0, "");
		shoppingItem.setCount(1);
		shoppingItem.setCommodity(this.commodityService.getObject(commodityId));
		//shoppingItemService.add(shoppingItem);
		return response(true);
	}

	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	@Override
	public JsonItem getJsonItem(ShoppingItem object) throws Exception {
		return null;
	}

}
