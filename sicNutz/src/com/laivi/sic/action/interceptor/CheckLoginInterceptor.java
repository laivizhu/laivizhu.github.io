package com.laivi.sic.action.interceptor;

import java.lang.reflect.Method;

import org.nutz.aop.interceptor.AbstractMethodInterceptor;

import com.laivi.sic.model.annotation.CheckLogin;

public class CheckLoginInterceptor extends AbstractMethodInterceptor {

	@Override
	public boolean beforeInvoke(Object obj, Method method, Object... args) {
		if(method.isAnnotationPresent(CheckLogin.class)){
			
		}
		return super.beforeInvoke(obj, method, args);
	}
	
	

	
}
