package com.laivi.knowledge.basic.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.laivi.knowledge.basic.model.annotation.CheckLogin;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.user.model.po.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-9
 */
@SuppressWarnings("serial")
public class CheckLoginInterceptor extends AbstractInterceptor{
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String methodName = actionInvocation.getProxy().getMethod();
		Method method = actionInvocation.getAction().getClass().getMethod(methodName);
		HttpServletRequest request=ServletActionContext.getRequest();
		User user=(User)request.getSession().getAttribute("user");
		if(method!=null){
			if(method.isAnnotationPresent(CheckLogin.class)){
				if(user==null){
					throw new ErrorException("error.user.notLogin");
				}
			}
		}
		return actionInvocation.invoke();
	}

}
