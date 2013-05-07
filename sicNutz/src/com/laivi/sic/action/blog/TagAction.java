package com.laivi.sic.action.blog;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.po.blog.Tag;

@IocBean
@At("/tag")
public class TagAction extends ABasicDBAction<Tag>{
	
	@At
	public Object comboList(@Param("::tag.")Tag tag){
		
		return null;
	}

	@Override
	public Class<Tag> getEntityClass() {
		return Tag.class;
	}

}
