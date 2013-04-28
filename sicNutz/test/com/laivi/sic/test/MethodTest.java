package com.laivi.sic.test;


import org.junit.Before;
import org.junit.Test;
import org.nutz.validation.Errors;
import org.nutz.validation.annotation.AnnotationValidation;

import com.laivi.sic.model.po.user.LoginUser;

public class MethodTest {
	
	@Before
	public void init(){
		
	}
	
	@Test
	public void testJson(){
	}
	
	@Test
	public void testVal(){
		AnnotationValidation av = new AnnotationValidation();
        LoginUser b = new LoginUser(); 
        b.setUidendity("23fasdfasd");
        b.setPassword("123456789");
        b.setEmail("fasdl@gamilcom");
        Errors ers = av.validate(b);
        System.out.println(ers.getErrorsMap().get("account"));
	}
	
	
	
}
