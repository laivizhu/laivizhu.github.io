package com.envisioncn.srm.basic.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.envisioncn.srm.basic.model.constants.AppConstants;

/**
 * 
 * Copyright Envision 日期处理工具
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public class DateUtil {

	public static final String DATEFORMAT = "MM/dd/yyyy";
	public static final String DATETIMEFORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String MONTHFORMAT = "yyyy-MM";
	public static final String YEARMINUTE = "MM/dd/yyyy HH:mm";
	public static final String MINUTE = "HH:mm";
	public static final String ACCESSDATAFORMAT = "yyyy/MM/dd HH:mm:ss";
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	public static final String DATEUPLOADFORMAT = "yyyyMMddHHmmss";

	/**
	 * 
	 * description:将日期字符串按特定的格式转为Date对象 data 2012-11-12 user Janlu.Zhu
	 * 
	 * @param dateString
	 *            :日期字符串
	 * @param dateFormat
	 *            :日期格式
	 * @return
	 * @throws ParseException
	 */
	public static Date formatString(String dateString, String dateFormat) throws ParseException {
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			return df.parse(dateString);
		} catch (ParseException e) {
			throw new ParseException("日期格式错误", 0);
		}
	}

	public static Date formatString(String dateString) throws ParseException {
		return formatString(dateString, DEFAULT_DATE_PATTERN);
	}

	/**
	 * 
	 * description:将日期对象转为特定的日期字符串 data 2012-11-12 user Janlu.Zhu
	 * 
	 * @param date
	 * @param strFormat
	 * @return
	 */
	public static String formatDate(Date date, String strFormat) {
		if (date == null) {
			return AppConstants.EMPTY;
		}
		DateFormat df = new SimpleDateFormat(strFormat);
		return df.format(date);
	}

	public static String formatDate(Date date) {
		return formatDate(date, DEFAULT_DATE_PATTERN);
	}

	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static Date formateAddOneDate(String dateString) throws ParseException {
		Date date = formatString(dateString);
		Date addOneDate = new Date(date.getTime() + 24 * 60 * 60 * 1000);
		return addOneDate;
	}

	public static String getCurrentDateFormatString() {
		return UUID.randomUUID().toString() + DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT);
	}

	public static String getCurrentDateFormatStringPdf() {
		return UUID.randomUUID().toString() + DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT)
				+ AppConstants.POINT + AppConstants.FileCategory.PDF;
	}

	public static String getCurrentDateFormatStringExcel() {
		return UUID.randomUUID().toString() + DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT)
				+ AppConstants.POINT + AppConstants.FileCategory.EXCEL;
	}

}
