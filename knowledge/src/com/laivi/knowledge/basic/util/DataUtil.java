package com.laivi.knowledge.basic.util;

import java.math.BigDecimal;
import java.util.Random;

import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;

/**
 * 
 * Copyright Envision 数据处理工具
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public class DataUtil {
	private static int DEFAULT_SCALE = 2;
	private static int DEFAULT_CHAR = 200;

	/**
	 * 
	 * description:按精度控制Double数值输出 data 2012-11-12 user Janlu.Zhu
	 * 
	 * @param value
	 * @return
	 */
	public static String getDoubleString(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
		return bd.toString();
	}

	/**
	 * 
	 * description:按精度控制Double数值输出 data 2012-11-12 user Janlu.Zhu
	 * 
	 * @param value
	 * @return
	 */
	public static String getDoubleString(double value, int scale) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
		return bd.toString();
	}

	public static int parseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(value.toString() + "不能转换为整数");
		}
	}

	public static double parseDouble(String value) {
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(value.toString() + "不能转换为double");
		}
	}

	/**
	 * 
	 * description:将id数组转为字符串 data 2012-11-12 user Janlu.Zhu
	 * 
	 * @param ids
	 * @return
	 */
	public static String arrayToString(int[] ids) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ids.length; i++) {
			sb.append(ids[i]);
			if (i != (ids.length - 1)) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	public static Long[] changeIdString(String idStrings){
		String[] idArray=idStrings.split(",");
		Long[] ids=new Long[idArray.length];
		for(int i=0;i<idArray.length;i++){
			ids[i]=Long.parseLong(idArray[i]);
		}
		return ids;
	}

	public static String getRandPassword() {
		String passwordChar = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(passwordChar.charAt(rand.nextInt(passwordChar.length())));
		}
		return sb.toString();
	}

	public static boolean notEmptyString(String value) {
		if (value != null && !"".endsWith(value)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getNumberString(String value,int length){
		return DataUtil.getNumberString(value, 0, length);
	}
	
	public static String getNumberString(String value,int prefix,int length){
		if(DataUtil.notEmptyString(value)){
			return String.valueOf(Long.parseLong(value)+1);
		}else{
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < length-1; i++){
				sb.append('0');
			}
			return String.valueOf(prefix)+sb.toString();
		}
	}
	
	public static long getIndexStringId(String value,int index) throws ErrorException {
		try{
			String[] ids=value.split(",");
			return Long.parseLong(ids[index-1]);
		}catch(Exception e){
			throw new ErrorException("字符串不合法");
		}
	}
	
	public static String getDefaultChar(String content)throws ErrorException{
		return DataUtil.getDefaultChar(content,DEFAULT_CHAR);
	}
	
	public static String getDefaultChar(String content,int charLength)throws ErrorException{
		if(content.length()>charLength){
			return content.substring(0, charLength)+AppConstants.ELLIPSIS;
		}else{
			return content;
		}
		
	}
	
}
