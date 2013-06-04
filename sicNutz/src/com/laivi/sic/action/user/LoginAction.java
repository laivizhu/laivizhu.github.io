package com.laivi.sic.action.user;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.laivi.sic.action.basic.ADownloadAction;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.po.user.LoginUser;
import com.laivi.sic.model.po.user.User;
import com.laivi.sic.model.to.Response;

@IocBean
public class LoginAction extends ADownloadAction<LoginUser> {

	@At
	public Response login(String email,String password,HttpSession session)throws Exception{
		if(Strings.isBlank(email)|| Strings.isBlank(password))
			return failure("账号和密码不能为空");
		email=email.trim().intern();
		password=password.trim().intern();
		LoginUser user=dao.fetch(LoginUser.class,Cnd.where("email","=",email).and("password","=",password));
		if(user==null)
			return failure("账号或密码错误");
		session.setAttribute("user", user);
		return success();
	}
	
	
	
	@At
	@CheckValue
	public Response regiest(@Param("::loginUser.") final LoginUser loginUser,@Param("::user.") final User user){
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
