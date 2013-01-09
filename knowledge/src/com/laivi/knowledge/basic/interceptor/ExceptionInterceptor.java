package com.laivi.knowledge.basic.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateJdbcException;

import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.type.ResponseType;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
@SuppressWarnings("serial")
public class ExceptionInterceptor extends AbstractInterceptor {
	private static final String ERROR_MESSAGE_FORMAT = "{\"success\":false, \"msg\":\"%s\"}";
	private static final String DEFAULT_ERROR_MESSAGE = "系统繁忙，请稍后再试";

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface CheckException {
		ResponseType responseType() default ResponseType.JSON;
		String errorFormat() default ERROR_MESSAGE_FORMAT;
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		long startTime = System.currentTimeMillis();
		String methodName = actionInvocation.getProxy().getMethod();
		Method method = actionInvocation.getAction().getClass().getMethod(methodName);
		try {
			String errorFormat = ERROR_MESSAGE_FORMAT;
			ResponseType responseType = ResponseType.JSON;
			if (method != null && method.isAnnotationPresent(CheckException.class)) {
				CheckException annotation = method.getAnnotation(CheckException.class);
				errorFormat = annotation.errorFormat();
				responseType = annotation.responseType();
			}
			try {
				return actionInvocation.invoke();
			} catch (Exception e) {
				//e.printStackTrace();
				String path = null;
				String errorMessage = e.getMessage() == null ? DEFAULT_ERROR_MESSAGE : e.getMessage();
				if (errorMessage.contains("java.io.InputStream")) {
					errorMessage = ErrorMessageConstants.Common.FILE_NOT_FOUND;
					path = "error";
				}
				
				if(e instanceof HibernateJdbcException){
					responseType=ResponseType.HTML;
					errorMessage=ErrorMessageConstants.JDBCEXCEPTION;
				}
				if(e instanceof ErrorException){
					responseType=ResponseType.HTML;
				}
				ServletActionContext.getResponse().setContentType(responseType.toText());
				ServletActionContext.getResponse().getWriter().write(String.format(errorFormat, errorMessage));
				return path;
			}
		} finally {
			long endTime = System.currentTimeMillis();
			if (endTime - startTime > 3000) {
				//log.warn(String.format("Slow Request: %s.%s() costs %d seconds.",
				//actionInvocation.getProxy().getActionName(), method, endTime- startTime));
			}
		}
	}

}
