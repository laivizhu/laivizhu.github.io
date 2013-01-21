package com.laivi.knowledge.shopping.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.shopping.model.po.ShoppingItem;
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
	private ShoppingItem shoppingItem;
	
	public String get()throws Exception{
		ParamAssert.isTrue(id>0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		ShoppingItem shoppingItem=this.shoppingItemService.getObject(id);
		JsonItem item=new JsonItem();
		item.add("id", shoppingItem.getId()).add("shoppingItem.count", shoppingItem.getCount());
		return response(item.toFormDataString(true));
	}
	
	public String update()throws Exception{
		ParamAssert.isTrue(id>0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		ShoppingItem dShoppingItem=this.shoppingItemService.getObject(id);
		dShoppingItem.setCount(shoppingItem.getCount());
		this.shoppingItemService.modify(dShoppingItem);
		return response(true);
	}

	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		JsonItemList jsonList=new JsonItemList();
		jsonList.createItem().add("text", "").add("value", "");
		return jsonList;
	}

	@Override
	public JsonItem getJsonItem(ShoppingItem object,boolean isSub) throws Exception {
		return null;
	}

	public ShoppingItem getShoppingItem() {
		return shoppingItem;
	}

	public void setShoppingItem(ShoppingItem shoppingItem) {
		this.shoppingItem = shoppingItem;
	}

	@Resource(name="ShoppingItemService")
	public void setShoppingItemService(IShoppingItemService shoppingItemService) {
		this.shoppingItemService = shoppingItemService;
	}
	@Resource(name="ShoppingItemService")
	public void setBasicService(IBasicService<ShoppingItem> basicService){
		this.basicService=basicService;
	}
	

}
