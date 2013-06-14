package com.laivi.sic.action.shopping;

import java.util.Date;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.shopping.Commodity;
import com.laivi.sic.model.po.shopping.Order;
import com.laivi.sic.model.po.shopping.ShoppingItem;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.StatusType;
import com.laivi.sic.util.basic.DateUtil;

@IocBean
@At("/shopping/order")
public class OrderAction extends ABasicDBAction<Order> {
	
	@At
	public Response addShoppingItem(long commodityId){
		Commodity commodity=dao.fetch(Commodity.class, commodityId);
		ShoppingItem item=new ShoppingItem();
		item.setCount(1);
		item.setCommodityId(commodityId);
		item.setPrice(commodity.getPrice());
		dao.insert(item);
		Order order=dao.fetch(Order.class, Cnd.where("status", "=", StatusType.INIT).and("userId", "=", this.getUserId()));
		if(order!=null){
			order.setItemIds(order.getItemIds()+","+item.getId());
			dao.update(order);
		}else{
			order=new Order();
			order.setCode("L"+DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT));
			order.setUserId(this.getUserId());
			order.setStatus(StatusType.INIT);
			order.setItemIds(item.getId()+"");
			dao.insert(order);
		}
		commodity.setSaveCount(commodity.getSaveCount()-1);
		dao.update(commodity);
		return success();
	}
	
	@At
	public Response updateShoppingItem(long shoppingItemId,int count){
		ShoppingItem item=dao.fetch(ShoppingItem.class, shoppingItemId);
		int beforeCount=item.getCount();
		item.setCount(count);
		Commodity commodity=dao.fetch(Commodity.class, item.getCommodityId());
		commodity.setSaveCount(commodity.getSaveCount()+beforeCount-count);
		dao.update(item);
		return success();
	}
	
	@At
	public Response deleteShoppingItem(long id,long itemId){
		Order order=dao.fetch(Order.class, id);
		ShoppingItem item=dao.fetch(ShoppingItem.class, itemId);
		Commodity commodity=dao.fetch(Commodity.class, item.getCommodityId());
		commodity.setSaveCount(commodity.getSaveCount()+item.getCount());
		dao.update(commodity);
		if(order.getItemIds().indexOf(","+item.getId()+",")!=0){
			order.setItemIds(order.getItemIds().replaceAll(","+item.getId()+",", ""));
		}else if(order.getItemIds().indexOf(","+item.getId())!=0){
			order.setItemIds(order.getItemIds().replaceAll(","+item.getId(), ""));
		}else if(order.getItemIds().indexOf(item.getId()+",")!=0){
			order.setItemIds(order.getItemIds().replaceAll(item.getId()+",", ""));
		}else{
			order.setItemIds(null);
		}
		dao.update(order);
		return success();
	}
	
	@At
	public Object listByStatus(@Param("::page.")Pager page,StatusType status)throws Exception{
		return list(page,Cnd.where(this.getBasicCnd()).and("status", "=", status));
	}
	
	@At
	public Object itemList(long id){
		JsonList jsonList=new JsonList();
		Order order=null;
		if(id==0){
			order=dao.fetch(Order.class, Cnd.where("status", "=", StatusType.INIT).and("userId", "=", getUserId()));
		}else{
			order=dao.fetch(Order.class, id);
		}
		if(order!=null){
			for(ShoppingItem item:dao.query(ShoppingItem.class, Cnd.wrap("id in ("+order.getItemIds()+")"))){
				jsonList.add(this.getJsonItem(ShoppingItem.class, item, false));
			}
		}
		return jsonList;
	}
	
	@At
	public Response commit(@Param("::order")Order order){
		Order dOrder=dao.fetch(Order.class, order.getId());
		dOrder.setStatus(order.getStatus());
		dao.update(dOrder);
		return success();
	}
	
	@At
	public Response delete(long id){
		Order order=dao.fetch(Order.class, id);
		if(order.getStatus()==StatusType.INIT){
			dao.clear(ShoppingItem.class, Cnd.wrap("id in ("+order.getItemIds()+")"));
			dao.delete(order);
		}else{
			return failure("订单状态已提交");
		}
		return success();
	}

	@Override
	public Class<Order> getEntityClass() {
		return Order.class;
	}

}
