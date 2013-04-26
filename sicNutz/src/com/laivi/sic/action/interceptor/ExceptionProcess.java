package com.laivi.sic.action.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.nutz.lang.Lang;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.AbstractProcessor;

import com.laivi.sic.model.exception.ErrorException;

public class ExceptionProcess extends AbstractProcessor {

	private static final String ERROR_MESSAGE_FORMAT = "{\"success\":false, \"msg\":\"%s\"}";
	private static final String DEFAULT_ERROR_MESSAGE = "系统繁忙，请稍后再试"; 
	@Override
	public void process(ActionContext ac) throws Throwable {
		Object module = ac.getModule();
        Method method = ac.getMethod();
        Object[] args = ac.getMethodArgs();
        try {
        	new Throwable().printStackTrace();
        	Object re = method.invoke(module, args);
            ac.setMethodReturn(re);
            doNext(ac);
        } catch (IllegalAccessException e) {
            throw Lang.unwrapThrow(e);
        }catch (IllegalArgumentException e) {
            throw Lang.unwrapThrow(e);
        }catch (InvocationTargetException e) {
            throw Lang.unwrapThrow(e);
        }catch(Exception e){
        	String returnMsg=null;
        	if(e instanceof ErrorException){
        		returnMsg=String.format(ERROR_MESSAGE_FORMAT, e.getMessage());
			}else{
				returnMsg=String.format(ERROR_MESSAGE_FORMAT, DEFAULT_ERROR_MESSAGE);
			}
        	ac.setMethodReturn(returnMsg);
            doNext(ac);
        }

	}

}
