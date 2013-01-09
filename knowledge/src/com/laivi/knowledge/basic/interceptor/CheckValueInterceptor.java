package com.laivi.knowledge.basic.interceptor;

import java.lang.reflect.Method;

import com.laivi.knowledge.basic.model.annotation.Check;
import com.laivi.knowledge.basic.util.ParamAssert;
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
public class CheckValueInterceptor extends AbstractInterceptor{
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String methodName = actionInvocation.getProxy().getMethod();
		Method method = actionInvocation.getAction().getClass().getMethod(methodName);
		if(method!=null){
			if(method.isAnnotationPresent(Check.class)){
				ParamAssert.isTrue(true, "");
			}
			return actionInvocation.invoke();
		}
		return null;
	}

}
