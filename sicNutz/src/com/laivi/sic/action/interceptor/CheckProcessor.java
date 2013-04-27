package com.laivi.sic.action.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.AbstractProcessor;
import org.nutz.validation.Errors;
import org.nutz.validation.ValidationUtils;
import org.nutz.validation.annotation.AnnotationValidation;

import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.po.user.LoginUser;
import com.laivi.sic.model.to.Response;

public class CheckProcessor extends AbstractProcessor {
	private static AnnotationValidation av = new AnnotationValidation();

	@Override
	public void process(ActionContext ac) throws Throwable {
		boolean isNext=true;
		Method method = ac.getMethod();
		if(method.isAnnotationPresent(CheckLogin.class)){
			HttpSession session=ac.getRequest().getSession();
			LoginUser user=(LoginUser)session.getAttribute("user");
			if(user==null){
				isNext=false;
				ac.setMethodReturn(new Response(false,"请先登录！"));
				this.renderView(ac);
			}
		}else if(method.isAnnotationPresent(CheckValue.class)){
			Object[] args=ac.getMethodArgs();
			Errors es = ValidationUtils.checkArgs(method.getParameterTypes(), args);
			if (null != es) {
				isNext=false;
				for (Object argsObj : args) {
					if (argsObj instanceof Errors)
						continue;
					av.validate(argsObj, es);
				}
				ac.setMethodReturn(new Response(false,(String)es.getErrorsList().toArray()[0]));
				this.renderView(ac);
			}
		}
		if(isNext){
			doNext(ac);
		}
	}

}
