package com.laivi.sic.action.user;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;
import org.nutz.validation.Errors;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.po.user.LoginUser;
import com.laivi.sic.model.po.user.User;
import com.laivi.sic.model.to.Response;

@IocBean
public class LoginAction extends ABasicDBAction<LoginUser> {

	@At
	public Response login(@Param("account")String account,@Param("password")String password,HttpSession session)throws Exception{
		if(Strings.isBlank(account)|| Strings.isBlank(password))
			return failure("");
		account=account.trim().intern();
		password=password.trim().intern();
		LoginUser user=dao.fetch(LoginUser.class,Cnd.where("name","=",account).and("password","=",password));
		if(user==null)
			return failure("");
		session.setAttribute("user", user);
		return success();
	}
	
	@At
	@Ok(">>:/")
	public void logout(HttpSession session){
		session.invalidate();
	}
	
	@At
	@CheckValue
	public Response regiest(@Param("::loginUser.") final LoginUser loginUser,@Param("::user.") final User user,Errors es){
		System.out.println("error count="+es.errorCount());
		Trans.exec(new Atom(){
			@Override
			public void run() {
				dao.insert(loginUser);
				dao.insert(user);
			}
		});
		return success();
	}
	
	public Response resetPassword(String email){
		return success();
	}

	@Override
	public Class<LoginUser> getEntityClass() {
		return LoginUser.class;
	}

	

	
	
	
	
	
	
}
