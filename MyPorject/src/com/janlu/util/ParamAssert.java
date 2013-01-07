package com.janlu.util;

import com.janlu.exception.AlgorithmException;



public final class ParamAssert {
	private ParamAssert() {
	}

	public static void isTrue(boolean result, String errorInfo) throws AlgorithmException {
		if (result) {
			throw new AlgorithmException(errorInfo);
		}
	}
	
	public static void isNull(Object object,String errorInfo)throws AlgorithmException{
		if(object==null){
			throw new AlgorithmException(errorInfo);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T>T nullValue(Object object,T value){
		if(object==null){
			return value;
		}else{
			return (T)object;
		}
	}
	
}
