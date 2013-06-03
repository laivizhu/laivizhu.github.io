package com.laivi.sic.action.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.AbstractProcessor;

import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.po.user.LoginUser;
import com.laivi.sic.model.to.Response;
import com.laivi.validation.AnnotationValidation;

public class CheckProcessor extends AbstractProcessor {
	private static AnnotationValidation av = new AnnotationValidation();

	@Override
	public void process(ActionContext ac) throws Throwable {
		boolean isNext=true;
		Method method = ac.getMethod();
		try{
			if(method.isAnnotationPresent(CheckLogin.class)){
				HttpSession session=ac.getRequest().getSession();
				LoginUser user=(LoginUser)session.getAttribute("user");
				if(user==null){
					isNext=false;
					ac.setMethodReturn(new Response(false,"请先登录！"));
					this.renderView(ac);
				}
			}else if(method.isAnnotationPresent(CheckValue.class)){
				Object[] args=ac.getMethodArgs();
				for (Object argsObj : args) {
					av.validate(argsObj);
				}
			}
			if(isNext){
				doNext(ac);
			}
		}catch(Exception e){
			if(e.getMessage()!=null&& !"".equals(e.getMessage())){
				ac.setMethodReturn(new Response(false,e.getMessage()));
			}else{
				ac.setMethodReturn(new Response(false,"系统错误！"));
			}
			this.renderView(ac);
		}
		
	}

}
