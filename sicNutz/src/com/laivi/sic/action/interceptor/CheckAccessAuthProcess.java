package com.laivi.sic.action.interceptor;

import java.lang.reflect.Method;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.AbstractProcessor;

public class CheckAccessAuthProcess extends AbstractProcessor {

	@Override
	public void process(ActionContext ac) throws Throwable {
		Method method = ac.getMethod();
		try{
			doNext(ac);
		}catch(Exception e){
			throw e;
		}
	}

}
