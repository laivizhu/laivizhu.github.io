package com.laivi.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public  class ValidationUtil {
	
	private static final String mobile_regex = "1\\d{10}";
	private static final String email_regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	private static final String chinese_regex = "[\u4e00-\u9fa5]+";
	private static final String account_regex = "^[a-zA-Z][a-zA-Z0-9_]+";

	public static boolean required(String fieldName,Object target,String errorMsg)throws Exception{
		if (null == target) {
			throw new Exception(errorMsg);
		}
		if(target instanceof String && "".equals(((String) target).trim())){
			throw new Exception(errorMsg);
		}
		return true;
	}
	
	/**
	 * 正则表达式验证
	 * 
	 * @param fieldName
	 * @param obj
	 * @param regex
	 * @param errorMsg
	 * @param errors
	 * @return
	 */
	public static boolean regex(String fieldName, Object target, String regex, String errorMsg)throws Exception {
		if (null == target || !(target instanceof String)) {
			throw new Exception(errorMsg);
		}

		final Matcher m = Pattern.compile(regex, Pattern.MULTILINE + Pattern.DOTALL).matcher((String) target);
		if (!m.matches()) {
			throw new Exception(errorMsg);
		}
		return true;
	}
	
	/**
	 * Email 验证
	 * 
	 * @param fieldName
	 * @param obj
	 * @param errorMsg
	 * @param errors
	 * @return
	 */
	public static boolean email(String fieldName, Object target, String errorMsg)throws Exception {
		return regex(fieldName, target, email_regex, errorMsg);
	}
	
	/**
	 * 手机号验证
	 * 
	 * @param fieldName
	 * @param obj
	 * @param errorMsg
	 * @param errors
	 * @return
	 */
	public static boolean mobile(String fieldName, Object target, String errorMsg)throws Exception {
		return regex(fieldName, target, mobile_regex, errorMsg);
	}
	
	/**
	 * 只允许中文验证
	 * 
	 * @param fieldName
	 * @param obj
	 * @param errorMsg
	 * @param errors
	 * @return
	 */
	public static boolean chinese(String fieldName, Object target, String errorMsg)throws Exception {
		return regex(fieldName, target, chinese_regex, errorMsg);
	}
	
	/**
	 * 账号验证
	 * 
	 * @param fieldName
	 * @param target
	 * @param errorMsg
	 * @param errors
	 * @return
	 */
	public static boolean account(String fieldName, Object target, String errorMsg)throws Exception {
		return regex(fieldName, target, account_regex, errorMsg);
	}
	
	/**
	 * 字符串长度必须在一定区间范围内验证
	 * 
	 * @param fieldName
	 * @param obj
	 * @param interval
	 *            长度限定区间，如果传空的数组也不会报错，但验证将总是会通过
	 * @param errorMsg
	 * @param errors
	 * @return
	 */
	public static boolean stringLength(	String fieldName,
										Object target,
										int[] interval,
										String errorMsg)throws Exception {
		int minLength = 0;
		int maxLength = Integer.MAX_VALUE;
		if (interval.length >= 1) {
			minLength = interval[0];
		}
		if (interval.length >= 2) {
			maxLength = interval[1];
		}
		return stringLength(fieldName, target, minLength, maxLength,errorMsg);
	}
	
	/**
	 * 字符串长度必须在一定区间范围内验证
	 * 
	 * @param fieldName
	 * @param obj
	 * @param minLength
	 * @param maxLength
	 * @param errorMsg
	 * @param errors
	 * @return
	 */
	public static boolean stringLength(	String fieldName,
										Object target,
										int minLength,
										int maxLength,
										String errorMsg)throws Exception {
		if (null == target || !(target instanceof String)) {
			throw new Exception(errorMsg);
		}
		String str = (String) target;
		if (str.length() < minLength || str.length() > maxLength) {
			throw new Exception(errorMsg);
		}
		return true;
	}
	
	/**
	 * 判断指定值是否在某个区间
	 * 
	 * @param fieldName
	 * @param target
	 * @param interval
	 * @param errorMsg
	 * @param errors
	 * @return
	 */
	public static boolean limit(String fieldName, Object target,	double[] interval,	String errorMsg)throws Exception {
		double minLength = 0;
		double maxLength = Double.MAX_VALUE;
		if (interval.length >= 1) {
			minLength = interval[0];
		}
		if (interval.length >= 2) {
			maxLength = interval[1];
		}
		return limit(fieldName, target, minLength, maxLength, errorMsg);
	}
	
	/**
	 * 判断指定值是否在某个区间,兼容 int、long、float、double
	 * 
	 * @param fieldName
	 * @param target
	 * @param interval
	 * @param errorMsg
	 * @param errors
	 * @return
	 */
	public static boolean limit(String fieldName, Object target,	double minValue, double maxValue, String errorMsg)throws Exception {
		if (null == target) {
			throw new Exception(errorMsg);
		}
		Double d = null;
		if (target instanceof Double) {
			d = (Double) target;
		} else if (target instanceof Integer) {
			d = ((Integer) target).doubleValue();
		} else if (target instanceof Long) {
			d = ((Long) target).doubleValue();
		} else if (target instanceof Float) {
			d = ((Float) target).doubleValue();
		}
		if (d == null || d < minValue || d > maxValue) {
			throw new Exception(errorMsg);
		}
		return true;
	}
	
}
