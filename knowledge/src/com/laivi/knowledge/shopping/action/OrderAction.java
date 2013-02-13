package com.laivi.knowledge.shopping.action;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.annotation.CheckLogin;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.shopping.model.po.Commodity;
import com.laivi.knowledge.shopping.model.po.Order;
import com.laivi.knowledge.shopping.model.po.ShoppingItem;
import com.laivi.knowledge.shopping.model.type.StatusType;
import com.laivi.knowledge.shopping.service.ICommodityService;
import com.laivi.knowledge.shopping.service.IOrderService;
import com.laivi.knowledge.shopping.service.IShoppingItemService;
import com.laivi.knowledge.user.service.IUserService;

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
	private IUserService userService;
	private long commodityId;
	private long shoppingItemId;
	private int status;
	private int count;
	
	@CheckLogin
	public String addShoppingItem()throws Exception{
		ParamAssert.isTrue(commodityId>0,ErrorMessageConstants.OBJECT_NOT_EXIST);
		Commodity commodity=this.commodityService.getObject(commodityId);
		ShoppingItem item=new ShoppingItem();
		item.setCount(1);
		item.setCommodity(commodity);
		item.setPrice(commodity.getPrice());
		CriterionList conditions=this.getUserCriterionList();
		conditions.put(Restrictions.eq("status", StatusType.INIT));
		Order order=this.orderService.getObject(conditions);
		if(order!=null){
			order.getItem().add(item);
			this.orderService.modify(order);
		}else{
			order=new Order();
			order.setCode("L"+DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT));
			order.setUserId(this.getCurrentUserId());
			order.setStatus(StatusType.INIT);
			order.getItem().add(item);
			this.orderService.add(order);
		}
		commodity.setSaveCount(commodity.getSaveCount()-1);
		this.commodityService.modify(commodity);
		return response(true);
	}
	
	public String updateShoppingItem()throws Exception{
		ParamAssert.isTrue(shoppingItemId>0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		ShoppingItem item=this.shoppingItemService.getObject(shoppingItemId);
		int beforeCount=item.getCount();
		item.setCount(count);
		item.getCommodity().setSaveCount(item.getCommodity().getSaveCount()+beforeCount-count);
		this.shoppingItemService.modify(item);
		return response(true);
	}
	
	public String deleteShoppingItem()throws Exception{
		ParamAssert.isTrue(id>0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		ParamAssert.isTrue(shoppingItemId>0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		Order order=this.orderService.getObject(id);
		ShoppingItem item=this.shoppingItemService.getObject(shoppingItemId);
		item.getCommodity().setSaveCount(item.getCommodity().getSaveCount()+item.getCount());
		order.getItem().remove(item);
		this.orderService.modify(order);
		return response(true);
	}
	 
	public String list()throws Exception{
		JsonList jsonList=new JsonList();
		CriterionList conditions=this.getUserCriterionList();
		if(status!=0){
			conditions.put(Restrictions.eq("status", status));
		}
		for(Order order:this.orderService.getList(conditions, start, limit)){
			jsonList.add(this.getJsonItem(order,true).toString());
		}
		return response(jsonList.toPageString(this.orderService.getCount(conditions)));
	}
	
	public String itemList()throws Exception{
		Order order=null;
		if(id==0){
			CriterionList conditions=CriterionList.CreateCriterion()
					.put(Restrictions.eq("status", StatusType.INIT))
					.put(Restrictions.eq("userId", this.getCurrentUserId()));
			order=this.orderService.getObject(conditions);
		}else{
			order=this.orderService.getObject(id);
		}
		JsonList jsonList=new JsonList();
		if(order==null){
			return response(jsonList);
		}else{
			for(ShoppingItem item:order.getItem()){
				jsonList.add(item.toJson());
			}
			return response(jsonList);
		}
	}
	
	public String delete()throws Exception{
		ParamAssert.isTrue(id>0,ErrorMessageConstants.OBJECT_NOT_EXIST);
		Order order=this.orderService.getObject(id);
		if(order.getStatus()==StatusType.INIT){
			order.setItem(null);
			this.orderService.remove(order);
			this.shoppingItemService.executeSql("delete from t_shoppingitem where orderId is null", null);
		}else{
			return response(false,"订单状态已提交");
		}
		return response(true);
	}
	
	public String commit()throws Exception{
		ParamAssert.isTrue(id>0,ErrorMessageConstants.OBJECT_NOT_EXIST);
		Order order=this.orderService.getObject(id);
		order.setStatus(order.getStatus());
		this.orderService.modify(order);
		return response(true);
	}
	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		JsonItemList jsonList=new JsonItemList();
		jsonList.createItem().add("value", "code").add("text", "订单号");
		return jsonList;
	}

	@Override
	public JsonItem getJsonItem(Order object,boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("code", object.getCode())
		.add("status", object.getStatus().toText())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()))
		.add("user", userService.getObject(object.getUserId()).getUserName());
		int totalPrice=0;
		for(ShoppingItem shoppingItem:object.getItem()){
			totalPrice+=shoppingItem.getCount()*shoppingItem.getPrice();
		}
		item.add("totalPrice", totalPrice);
		return item;
	}

	public long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}

	public long getShoppingItemId() {
		return shoppingItemId;
	}

	public void setShoppingItemId(long shoppingItemId) {
		this.shoppingItemId = shoppingItemId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Resource(name="ShoppingItemService")
	public void setShoppingItemService(IShoppingItemService shoppingItemService) {
		this.shoppingItemService = shoppingItemService;
	}

	@Resource(name="CommodityService")
	public void setCommodityService(ICommodityService commodityService) {
		this.commodityService = commodityService;
	}

	@Resource(name="OrderService")
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	@Resource(name="OrderService")
	public void setBasicService(IBasicService<Order> basicService){
		this.basicService=basicService;
	}

	@Resource(name="UserService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
