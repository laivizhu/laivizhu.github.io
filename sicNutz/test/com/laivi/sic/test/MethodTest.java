package com.laivi.sic.test;


import org.junit.Test;
import org.nutz.validation.Errors;
import org.nutz.validation.annotation.AnnotationValidation;

import com.laivi.sic.model.po.user.LoginUser;

public class MethodTest {
	@Test
	public void testJson(){
	}
	
	@Test
	public void testVal(){
		AnnotationValidation av = new AnnotationValidation();
        LoginUser b = new LoginUser(); 
        b.setAccount("laivifdf");
        b.setPassword("123456789");
        Errors ers = av.validate(b);
        System.out.println(ers.getErrorsMap().get("account"));
	}
}
