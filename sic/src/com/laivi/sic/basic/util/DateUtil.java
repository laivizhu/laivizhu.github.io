package com.laivi.sic.basic.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.laivi.sic.basic.model.constants.AppConstants;

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
	
	private static final long ONE_MINUTE = 60;
	private static final long ONE_HOUR = 3600;
	private static final long ONE_DAY = 86400;
	private static final long ONE_MONTH = 2592000;
	private static final long ONE_YEAR = 31104000;
	
	public static Calendar calendar = Calendar.getInstance();
	
	/**
	 * 距离今天多久
	 * @param date
	 * @return 
	 */
	public static String fromToday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		long time = date.getTime() / 1000;
		long now = new Date().getTime() / 1000;
		long ago = now - time;
		if (ago <= ONE_HOUR)
			return ago / ONE_MINUTE + "分钟前";
		else if (ago <= ONE_DAY)
			return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE)
					+ "分钟前";
		else if (ago <= ONE_DAY * 2)
			return "昨天" + calendar.get(Calendar.HOUR_OF_DAY) + "点"
					+ calendar.get(Calendar.MINUTE) + "分";
		else if (ago <= ONE_DAY * 3)
			return "前天" + calendar.get(Calendar.HOUR_OF_DAY) + "点"
					+ calendar.get(Calendar.MINUTE) + "分";
		else if (ago <= ONE_MONTH) {
			long day = ago / ONE_DAY;
			return day + "天前" + calendar.get(Calendar.HOUR_OF_DAY) + "点"
					+ calendar.get(Calendar.MINUTE) + "分";
		} else if (ago <= ONE_YEAR) {
			long month = ago / ONE_MONTH;
			long day = ago % ONE_MONTH / ONE_DAY;
			return month + "个月" + day + "天前"
					+ calendar.get(Calendar.HOUR_OF_DAY) + "点"
					+ calendar.get(Calendar.MINUTE) + "分";
		} else {
			long year = ago / ONE_YEAR;
			int month = calendar.get(Calendar.MONTH) + 1;// JANUARY which is 0 so month+1
			return year + "年前" + month + "月" + calendar.get(Calendar.DATE)
					+ "日";
		}
	}
	
	/**
	 * 距离截止日期还有多长时间
	 * 
	 * @param date
	 * @return
	 */
	public static String fromDeadline(Date date) {
		long deadline = date.getTime() / 1000;
		long now = (new Date().getTime()) / 1000;
		long remain = deadline - now;
		if (remain <= ONE_HOUR)
			return "只剩下" + remain / ONE_MINUTE + "分钟";
		else if (remain <= ONE_DAY)
			return "只剩下" + remain / ONE_HOUR + "小时"
					+ (remain % ONE_HOUR / ONE_MINUTE) + "分钟";
		else {
			long day = remain / ONE_DAY;
			long hour = remain % ONE_DAY / ONE_HOUR;
			long minute = remain % ONE_DAY % ONE_HOUR / ONE_MINUTE;
			return "只剩下" + day + "天" + hour + "小时" + minute + "分钟";
		}

	}
	
	/**
	 * 距离今天的绝对时间
	 * 
	 * @param date
	 * @return
	 */
	public static String toToday(Date date) {
		long time = date.getTime() / 1000;
		long now = (new Date().getTime()) / 1000;
		long ago = now - time;
		if (ago <= ONE_HOUR)
			return ago / ONE_MINUTE + "分钟";
		else if (ago <= ONE_DAY)
			return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE) + "分钟";
		else if (ago <= ONE_DAY * 2)
			return "昨天" + (ago - ONE_DAY) / ONE_HOUR + "点" + (ago - ONE_DAY)
					% ONE_HOUR / ONE_MINUTE + "分";
		else if (ago <= ONE_DAY * 3) {
			long hour = ago - ONE_DAY * 2;
			return "前天" + hour / ONE_HOUR + "点" + hour % ONE_HOUR / ONE_MINUTE
					+ "分";
		} else if (ago <= ONE_MONTH) {
			long day = ago / ONE_DAY;
			long hour = ago % ONE_DAY / ONE_HOUR;
			long minute = ago % ONE_DAY % ONE_HOUR / ONE_MINUTE;
			return day + "天前" + hour + "点" + minute + "分";
		} else if (ago <= ONE_YEAR) {
			long month = ago / ONE_MONTH;
			long day = ago % ONE_MONTH / ONE_DAY;
			long hour = ago % ONE_MONTH % ONE_DAY / ONE_HOUR;
			long minute = ago % ONE_MONTH % ONE_DAY % ONE_HOUR / ONE_MINUTE;
			return month + "个月" + day + "天" + hour + "点" + minute + "分前";
		} else {
			long year = ago / ONE_YEAR;
			long month = ago % ONE_YEAR / ONE_MONTH;
			long day = ago % ONE_YEAR % ONE_MONTH / ONE_DAY;
			return year + "年前" + month + "月" + day + "天";
		}
	}
	
	public static String getYear() {
		return calendar.get(Calendar.YEAR) + "";
	}

	public static String getMonth() {
		int month = calendar.get(Calendar.MONTH) + 1;
		return month + "";
	}

	public static String getDay() {
		return calendar.get(Calendar.DATE) + "";
	}

	public static String get24Hour() {
		return calendar.get(Calendar.HOUR_OF_DAY) + "";
	}

	public static String getMinute() {
		return calendar.get(Calendar.MINUTE) + "";
	}

	public static String getSecond() {
		return calendar.get(Calendar.SECOND) + "";
	}


	/**
	 * 
	 * description:将日期字符串按特定的格式转为Date对象 data 2012-11-12 user Janlu.Zhu
	 * 
	 * @param dateString
	 *            :日期字符串
	 * @param dateFormat
	 *            :日期格式
	 * @return
	 * @throws java.text.ParseException
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
	
	public static long getMinuxTimeToNow(Date date){
		Date now=new Date();
		return now.getTime()-date.getTime();
	}
	
	public static long getDateTime(int dates){
		return dates*24*60*60*1000;
	}

	public static Date getFirstDate(int year,int month){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
	
	public static Date getLastDate(int year,int month){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		return cal.getTime();
	}
}
