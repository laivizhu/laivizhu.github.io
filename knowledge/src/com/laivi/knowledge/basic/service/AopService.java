package com.laivi.knowledge.basic.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.laivi.knowledge.basic.model.type.ExceptionType;
import com.laivi.knowledge.basic.model.type.ResponseType;

/**
 * @author janlu
 *
 */
@Aspect
@Component
public class AopService implements IAopService {
	private static final String ERROR_MESSAGE_FORMAT = "{success:false, msg:'%s'}";
	private static final String DEFAULT_ERROR_MESSAGE = "系统繁忙，请稍后再试";

	@Pointcut("execution(* com.janlu.knowledge..action.*.*(..))")
	public void pointCut(){}
	
	@AfterThrowing(pointcut="pointCut()",throwing="e")
	public String catchException(Exception e) throws IOException {
		if(e==null){
			return null;
		}
		String errorFormat = ERROR_MESSAGE_FORMAT;
		String errorMessage=null;
		if(e instanceof NullPointerException){
			errorMessage= ExceptionType.NULLVALUE.toText();
		}else if(e instanceof SQLException){
			errorMessage=ExceptionType.SQLERROR.toText();
		}else if(e instanceof NumberFormatException){
			errorMessage=ExceptionType.NUMBERPARSE.toText();
		}else if(e instanceof IOException){
			errorMessage=ExceptionType.IO.toText();
		}else if(e instanceof ParseException){
			errorMessage=ExceptionType.DATEPARSE.toText();
		}else if(e instanceof ArrayIndexOutOfBoundsException){
			errorMessage=ExceptionType.OUTARRAY.toText();
		}else{
			errorMessage=DEFAULT_ERROR_MESSAGE;
		}
		ServletActionContext.getResponse().setContentType(ResponseType.JSON.toText());
		ServletActionContext.getResponse().getWriter().write(String.format(errorFormat, errorMessage));
		return null;
	}

}
