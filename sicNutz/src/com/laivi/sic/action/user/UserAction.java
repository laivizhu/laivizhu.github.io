package com.laivi.sic.action.user;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.po.user.User;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/user")
public class UserAction extends ABasicDBAction<User>{

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
	
	@At
	public Response update(@Param("user")User user){
		dao.update(user);
		return success();
	}
}
