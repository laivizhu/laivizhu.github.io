package com.janlu.knowledge.test;

import org.junit.Test;

import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.util.DataUtil;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
public class UtilTest {
	
	@Test
	public void testDataUtil() throws ErrorException{
		String str="字符串不合法abc不合法";
		System.out.println(DataUtil.getDefaultChar(str,9));
	}

}
