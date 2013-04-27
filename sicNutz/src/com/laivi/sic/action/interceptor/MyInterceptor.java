package com.laivi.sic.action.interceptor;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.interceptor.AbstractMethodInterceptor;

import com.laivi.sic.model.to.Response;

public class MyInterceptor extends AbstractMethodInterceptor {
	//private static final String DEFAULT_ERROR_MESSAGE = "系统繁忙，请稍后再试";  

	@Override
	public void filter(InterceptorChain chain) throws Throwable {
		try{
			if (beforeInvoke(chain.getCallingObj(), chain.getCallingMethod(), chain.getArgs()))
                chain.doChain();
            Object obj = afterInvoke(chain.getCallingObj(),chain.getReturn(),chain.getCallingMethod(),chain.getArgs());
            chain.setReturnValue(obj);
		}catch(Exception e){
			Response response=null;
			if (whenError(e, chain.getCallingObj(), chain.getCallingMethod(), chain.getArgs())){
				/*if(e instanceof ErrorException){
					response=new Response(false, e.getMessage());
				}else{
					response=new Response(false, e.getMessage());
				}*/
				throw e;
			}
			chain.setReturnValue(response);
		}catch (Throwable e) {
            if (whenError(e, chain.getCallingObj(), chain.getCallingMethod(), chain.getArgs()))
                throw e;
        }
	}
}
