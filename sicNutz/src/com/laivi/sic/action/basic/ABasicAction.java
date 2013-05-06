package com.laivi.sic.action.basic;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;

import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.po.user.LoginUser;
import com.laivi.sic.model.to.Response;

public class ABasicAction implements IBasicAction {

	protected Response response(boolean success,String msg){
		return new Response(success,msg);
	}
	
	protected Response success(){
		return new Response(true,AppConstants.EMPTY);
	}
	
	protected Response failure(String msg){
		return new Response(false,msg);
	}
	
	protected boolean isSys(HttpSession session){
		LoginUser user=getLoginUser(session);
		if(user!=null &&user.isSysIs()){
			return true;
		}
		return false;
	}
	
	protected LoginUser getLoginUser(HttpSession session){
		return (LoginUser)session.getAttribute("user");
	}
	
	protected long getUserId(HttpSession session){
		LoginUser user=getLoginUser(session);
		if(user!=null){
			return user.getId();
		}else{
			return 0;
		}
	}
	
	protected Cnd getUserCnd(HttpSession session){
		Cnd cnd=null;
		if(this.isSys(session)){
			cnd=Cnd.where("userId","=", this.getUserId(session));
		}
		return cnd;
	}
}
