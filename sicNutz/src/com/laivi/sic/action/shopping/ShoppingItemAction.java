package com.laivi.sic.action.shopping;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.po.shopping.ShoppingItem;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/shopping/item")
public class ShoppingItemAction extends ABasicDBAction<ShoppingItem> {
	
	@At
	@CheckLogin
	public Response update(@Param("::item.")ShoppingItem item){
		ShoppingItem dItem=dao.fetch(ShoppingItem.class, item.getId());
		dItem.setCount(item.getCount());
		dao.update(dItem);
		return success();
	}

	@Override
	public Class<ShoppingItem> getEntityClass() {
		return ShoppingItem.class;
	}

}
