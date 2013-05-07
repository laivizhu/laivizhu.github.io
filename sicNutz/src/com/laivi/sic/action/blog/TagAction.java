package com.laivi.sic.action.blog;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.json.JsonItemList;
import com.laivi.sic.model.po.blog.Tag;

@IocBean
@At("/tag")
public class TagAction extends ABasicDBAction<Tag>{
	
	@At
	public Object comboList(@Param("::tag.")Tag tag){
		JsonItemList jsonList=new JsonItemList();
		for(Tag dtag:dao.query(this.getEntityClass(), Cnd.where("type", "=", tag.getType()))){
			jsonList.createItem().add("id", dtag.getId()).add("name", dtag.getName());
		}
		return jsonList.toList();
	}

	@Override
	public Class<Tag> getEntityClass() {
		return Tag.class;
	}

}
