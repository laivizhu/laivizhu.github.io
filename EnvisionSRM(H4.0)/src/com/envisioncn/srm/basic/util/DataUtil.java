package com.envisioncn.srm.basic.util;

import java.math.BigDecimal;
import java.util.Random;

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

}
