package com.laivi.sic.action.basic;

import javax.servlet.http.HttpSession;

import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.po.user.LoginUser;
import com.laivi.sic.model.to.Response;

public class ABasicAction implements IBasicAction {
	
	protected HttpSession session;

	protected Response response(boolean success,String msg){
		return new Response(success,msg);
	}
	
	protected Response success(){
		return new Response(true,AppConstants.EMPTY);
	}
	
	protected Response failure(String msg){
		return new Response(false,msg);
	}
	
	protected boolean isSys(){
		return false;
	}
	
	protected LoginUser getLoginUser(HttpSession session){
		return (LoginUser)session.getAttribute("user");
	}
}
