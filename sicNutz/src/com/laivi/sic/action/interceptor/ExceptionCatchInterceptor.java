package com.laivi.sic.action.interceptor;

import java.lang.reflect.Method;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.interceptor.AbstractMethodInterceptor;
import org.nutz.mvc.annotation.At;

import com.laivi.sic.model.exception.ErrorException;

public class ExceptionCatchInterceptor extends AbstractMethodInterceptor {
	private static final String ERROR_MESSAGE_FORMAT = "{\"success\":false, \"msg\":\"%s\"}";
	private static final String DEFAULT_ERROR_MESSAGE = "系统繁忙，请稍后再试";  

	@Override
	public void filter(InterceptorChain chain) throws Throwable {
		try{
			if (beforeInvoke(chain.getCallingObj(), chain.getCallingMethod(), chain.getArgs()))
                chain.doChain();
            Object obj = afterInvoke(    chain.getCallingObj(),
                                        chain.getReturn(),
                                        chain.getCallingMethod(),
                                        chain.getArgs());
            
		}catch(Exception e){
			
		}
		super.filter(chain);
	}



	@Override
	public boolean whenException(Exception e, Object obj, Method method,
			Object... args) {
		if(method.isAnnotationPresent(At.class)){
			if(e instanceof ErrorException){
				System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
			}else{
				System.out.println(String.format(ERROR_MESSAGE_FORMAT, DEFAULT_ERROR_MESSAGE));
			}
		}
		return false;
	}

	
}
