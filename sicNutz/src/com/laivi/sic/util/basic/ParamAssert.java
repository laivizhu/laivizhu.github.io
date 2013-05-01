package com.laivi.sic.util.basic;

import com.laivi.sic.model.exception.ErrorException;

/**
 * Copyright Envision 参数验证处理工具
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public final class ParamAssert {
	private ParamAssert() {
	}

	public static void isNotEmptyString(String s, String errorInfo) throws ErrorException {
		isTrue(s != null && DataUtil.notEmptyString(s), errorInfo);
	}
	
	public static void isNotEmptyString(String s, String errorInfo,boolean isMsg) throws ErrorException {
		isTrue(s != null && DataUtil.notEmptyString(s), errorInfo,isMsg);
	}

	public static void isNotNull(Object o, String errorInfo) throws ErrorException {
		isTrue(o != null, errorInfo);
	}

	public static void isNull(Object o, String errorInfo) throws ErrorException {
		isTrue(o == null, errorInfo);
	}

	public static void isEqual(Object a, Object b, String errorInfo) throws ErrorException {
		isTrue(a.equals(b), errorInfo);
	}

	public static void isNotEqual(Object a, Object b, String errorInfo) throws ErrorException {
		isTrue(!a.equals(b), errorInfo);
	}

	public static void isSame(Object a, Object b, String errorInfo) throws ErrorException {
		isTrue(a == b, errorInfo);
	}

	public static void isTrue(boolean result, String errorInfo) throws ErrorException {
		if (!result) {
			throw new ErrorException(errorInfo);
		}
	}
	
	public static void isTrue(boolean result, String errorInfo,boolean isMsg) throws ErrorException {
		if (!result) {
			throw new ErrorException(errorInfo,isMsg);
		}
	}


}
