package com.laivi.sic.basic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * User: dizem@126.com
 * Time: 12-7-14 下午10:54
 */
public class DateConverter extends StrutsTypeConverter {
	private static final List<SimpleDateFormat> DATE_FORMATS = Arrays.asList(
			new SimpleDateFormat("MM/dd/yyyy"),
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
			new SimpleDateFormat("yyyy/MM/dd hh:mm:ss"),
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy/MM/dd"));


	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values != null && values.length > 0) {
			return tryParseDate(values[0], 0);
		} else {
			return null;
		}
	}

	private Date tryParseDate(String value, int formatIndex) {
		if (DATE_FORMATS.size() <= formatIndex) {
			return null;
		}
		try {
			return DATE_FORMATS.get(formatIndex).parse(value);
		} catch (ParseException e) {
			return tryParseDate(value, formatIndex++);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		return DATE_FORMATS.get(1).format((Date) o);
	}
}
