package com.laivi.knowledge.shopping.action;

import java.util.Date;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.shopping.model.po.Commodity;
import com.laivi.knowledge.shopping.model.po.Order;
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
public class OrderAction extends ABasicAction<Order> {
	private IShoppingItemService shoppingItemService;
	private ICommodityService commodityService;
	private IOrderService orderService;
	private long commodityId;
	
	public String addShoppingItem()throws Exception{
		ParamAssert.isTrue(commodityId>0, "");
		Commodity commodity=this.commodityService.getObject(commodityId);
		ShoppingItem item=new ShoppingItem();
		item.setCount(1);
		item.setCommodity(commodity);
		item.setPrice(commodity.getPrice());
		CriterionList conditions=this.getUserCriterionList();
		conditions.put(Restrictions.eq("status", 1));
		Order order=this.orderService.getObject(conditions);
		if(order!=null){
			order.getItem().add(item);
			this.orderService.modify(order);
		}else{
			order=new Order();
			order.setCode("");
			order.setUserId(this.getCurrentUserId());
			order.setStatus(1);
			order.getItem().add(item);
			this.orderService.add(order);
		}
		return response(true);
	}
	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	@Override
	public JsonItem getJsonItem(Order object) throws Exception {
		return null;
	}

}
