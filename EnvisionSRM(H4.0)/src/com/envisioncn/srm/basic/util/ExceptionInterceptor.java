package com.envisioncn.srm.basic.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import org.apache.struts2.ServletActionContext;

import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.model.type.ResponseType;
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
				String path=null;
				String errorMessage = e.getMessage() == null ? DEFAULT_ERROR_MESSAGE : e.getMessage();
				if (errorMessage.indexOf("java.io.InputStream") != -1) {
					errorMessage = ErrorMessageConstants.Common.FILE_NOT_FOUND;
					path="error";
				}
				ServletActionContext.getResponse().setContentType(responseType.toText());
				ServletActionContext.getResponse().getWriter().write(String.format(errorFormat, errorMessage));
				return path;
			}
		} finally {
			long endTime = System.currentTimeMillis();
			if (endTime - startTime > 3000) {
				// log.warn(String.format("Slow Request: %s.%s() costs %d seconds.",
				// actionInvocation.getProxy().getActionName(), method, endTime
				// - startTime));
			}
		}
	}

}
