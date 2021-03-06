/**
 * Copyright Laivi 2013-4-14
 * Version 1.0 sic
 */
package com.laivi.sic.basic.model.type;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author laivi
 * Desc:
 */
public enum TimeFormat {
	Date("yyyy-MM-dd"),
	DateTime_12h("yyyy-MM-dd hh:mm:ss"),
	DateTime_24h("yyyy-MM-dd HH:mm:ss"),
	
	ISO8601Long_LongFormZone("yyyy-MM-dd'T'HH:mm:ssz"),
	ISO8601Long_RFC822Zone("yyyy-MM-dd'T'HH:mm:ssZ"),
	ISO8601Short("yyyyMMddHHmmssZ"),
	
	TimeLong_12h("hh:mm:ss"),
	TimeLong_24h("HH:mm:ss"),
	
	TimeShort_12h("hh:mm"),
	TimeShort_24h("HH:mm"),
	
	RSS("E, d MMM yyyy H:mm:ss GMT");
	
	public static String format(final DateFormat format, final Date date) {
		return format.format(date);
	}
	
	public static String format(final DateFormat format, final Date date, final TimeZone zone) {
		DateFormat newFormat = (DateFormat) format.clone();
		newFormat.setTimeZone(zone);
		return newFormat.format(date);
	}
	
	public static String format(final String pattern, final Date date) {
		return format(new SimpleDateFormat(pattern), date);
	}
	
	public static String formatCST(final DateFormat format, final Date date) {
		return format(format, date, TimeZone.getTimeZone("CST"));
	}
	
	public static String formatGMT(final DateFormat format, final Date date) {
		return format(format, date, TimeZone.getTimeZone("GMT"));
	}
	
	public static String formatUTC(final DateFormat format, final Date date) {
		return format(format, date, TimeZone.getTimeZone("UTC"));
	}

	public static Date parse(final DateFormat format, final String source) throws ParseException {
		return format.parse(source);
	}

	public static Date parse(final String pattern, final String source) throws ParseException {
		return parse(new SimpleDateFormat(pattern), source);
	}

	private final ThreadLocal<DateFormat> format = new ThreadLocal<DateFormat>();

	private TimeFormat(final String pattern) {
		format.set(new SimpleDateFormat(pattern));
	}
	
	public String format(final Date date) {
		return format(format.get(), date);
	}

	public String format(final Date date, final TimeZone zone) {
		return format(format.get(), date, zone);
	}

	public String formatCST(final Date date) {
		return format(format.get(), date, TimeZone.getTimeZone("CST"));
	}
	
	public String formatGMT(final Date date) {
		return format(format.get(), date, TimeZone.getTimeZone("GMT"));
	}
	public String formatUTC(final Date date) {
		return format(format.get(), date, TimeZone.getTimeZone("UTC"));
	}

	public DateFormat cloneFormat() {
		return (DateFormat) format.get().clone();
	}

	public Date parse(final String source) throws ParseException {
		return parse(format.get(), source);
	}
}
