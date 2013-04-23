package com.laivi.nutz.action;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.laivi.nutz.model.po.User;

@IocBean
@At("/user")
public class TestAction {
	
	private static final Log log=Logs.get();
	
	@Inject
	private Dao dao;
	
	@At
	public boolean login(@Param("name")String name,@Param("password")String password,HttpSession session){
		if(Strings.isBlank(name)|| Strings.isBlank(password))
			return false;
		name=name.trim().intern();
		password=password.trim().intern();
		User user=dao.fetch(User.class,Cnd.where("name","=",name).and("password","=",password));
		if(user==null)
			return false;
		session.setAttribute("user", user);
		return true;
	}
	
	@At
	@Ok(">>:/")
	public void logout(HttpSession session){
		session.invalidate();
	}
	
	@At
	public Object me(@Attr("user")User user){
		return user;
	}
	
	@At
	public Object test(){
		log.debug("Dao == "+dao);
		return new Date();
	}

}
