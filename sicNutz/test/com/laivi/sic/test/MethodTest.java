package com.laivi.sic.test;


import org.junit.Before;
import org.junit.Test;

public class MethodTest {
	
	@Before
	public void init(){
		
	}
	
	@Test
	public void testJson(){
	}
	
	@Test
	public void testStringReplace(){
		String id="userId";
		System.out.println("after replace:"+id.replaceAll("Id","").length());
	}
	
	
	
}
