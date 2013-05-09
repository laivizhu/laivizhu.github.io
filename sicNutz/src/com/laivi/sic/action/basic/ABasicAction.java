package com.laivi.sic.action.basic;

import org.nutz.dao.Cnd;
import org.nutz.mvc.Mvcs;

import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.po.user.LoginUser;
import com.laivi.sic.model.to.Response;

public abstract class ABasicAction implements IBasicAction {
	

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
		LoginUser user=getLoginUser();
		if(user!=null &&user.isSysIs()){
			return true;
		}
		return false;
	}
	
	protected LoginUser getLoginUser(){
		return (LoginUser)Mvcs.getHttpSession().getAttribute("user");
	}
	
	protected long getUserId(){
		LoginUser user=getLoginUser();
		if(user!=null){
			return user.getId();
		}else{
			return 0;
		}
	}
	
	protected Cnd getUserCnd(){
		Cnd cnd=null;
		if(this.isSys()){
			cnd=Cnd.where("userId","=", this.getUserId());
		}
		return cnd;
	}
	
	protected String getRealPath(String path){
		return Mvcs.getServletContext().getRealPath(path);
	}
}
