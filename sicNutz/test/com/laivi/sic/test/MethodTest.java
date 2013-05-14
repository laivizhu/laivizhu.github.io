package com.laivi.sic.test;


import org.junit.Before;
import org.junit.Test;

import com.laivi.sic.util.basic.DataUtil;

public class MethodTest {
	
	@Before
	public void init(){
		
	}
	
	
	@Test
	public void testSimple(){
		String str1="30条有关爱情的句子";
		String str2="30条有关爱情的句子";
		System.out.println("simple:"+DataUtil.getSimilarDegree(str1, str2));
	}
	
	
	
}
