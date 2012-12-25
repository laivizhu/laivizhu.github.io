/**
 * 
 */
package com.janlu.util;

import java.lang.reflect.Method;
import java.util.Date;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import com.janlu.annotation.RunTime;

/**
 * @author janlu
 *
 */
public class MethodCglibProxy implements MethodInterceptor {
	private Object target;
	
	private MethodCglibProxy(Object target){
		this.target=target;
	}
	
	@SuppressWarnings("unchecked")
	public static <T>T getInstance(T target) {
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(new MethodCglibProxy(target));
		return (T)enhancer.create();
	}
	
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object result=null;
		if(method != null && method.isAnnotationPresent(RunTime.class)){
			RunTime runTime=method.getAnnotation(RunTime.class);
			long start=new Date().getTime();
			result=methodProxy.invoke(target, args);
			long end=new Date().getTime();
			System.out.println(runTime.message()+(end-start));
		}else{
			result=methodProxy.invoke(target, args);
		}
		return result;
	}

}
