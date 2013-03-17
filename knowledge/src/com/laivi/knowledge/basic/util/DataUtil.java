package com.laivi.knowledge.basic.util;

import java.math.BigDecimal;
import java.util.Random;
import java.util.regex.Pattern;

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
	
	public static String append(Object... objects) {
		if (objects.length == 1) {
			return objects[0].toString();
		}
		StringBuilder sb = new StringBuilder();
		for (Object o : objects) {
			sb.append(o);
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
	
	public static boolean isIncludeId(long id,String ids){
		if(DataUtil.notEmptyString(ids)){
			Long[] idArrays=DataUtil.changeIdString(ids);
			for(Long tempId:idArrays){
				if(id==tempId) return true;
			}
		}
		return false;
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
		content=DataUtil.Html2Text(content);
		if(content.length()>charLength){
			return content.substring(0, charLength)+AppConstants.ELLIPSIS;
		}else{
			return content;
		}
	}

	public static String getRealUrl(String url){
		return AppConstants.URL+url;
	}
	
	public static String abbreviate(String str, int width, String ellipsis) {
		if (str == null || AppConstants.EMPTY.equals(str)) {
			return AppConstants.EMPTY;
		}
		int d = 0; // byte length
		int n = 0; // char length
		for (; n < str.length(); n++) {
			d = (int) str.charAt(n) > 256 ? d + 2 : d + 1;
			if (d > width) {
				break;
			}
		}
		if (d > width) {
			n = n - ellipsis.length() / 2;
			return str.substring(0, n > 0 ? n : 0) + ellipsis;
		}
		return str = str.substring(0, n);
	}

	public static String Html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = AppConstants.EMPTY;
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		java.util.regex.Pattern p_html1;
		java.util.regex.Matcher m_html1;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			String regEx_html1 = "<[^>]+";
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(AppConstants.EMPTY); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(AppConstants.EMPTY); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(AppConstants.EMPTY); // 过滤html标签

			p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
			m_html1 = p_html1.matcher(htmlStr);
			htmlStr = m_html1.replaceAll(AppConstants.EMPTY); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;// 返回文本字符串
	}
}
