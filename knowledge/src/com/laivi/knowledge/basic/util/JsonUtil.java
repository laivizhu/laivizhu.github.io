package com.laivi.knowledge.basic.util;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.laivi.knowledge.basic.model.json.JsonEntity;

/**
 * Util for converting Java object to JSON string.
 */
public final class JsonUtil {

	private static class DateJsonValueProcessor implements JsonValueProcessor {
		public Object processArrayValue(Object value, JsonConfig jsonConfig) {
			return process(value);
		}

		public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
			return process(value);
		}

		private Object process(Object value) {
			return DateUtil.formatDate((Date) value);
		}
	}

	private static class JsonEntityProcessor implements JsonValueProcessor {
		public Object processArrayValue(Object o, JsonConfig jsonConfig) {
			return process(o);
		}

		public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
			return process(o);
		}

		private Object process(Object value) {
			return ((JsonEntity) value).toJson();
		}
	}

	private static final JsonConfig JSON_CONFIG = new JsonConfig();

	static {
		JSON_CONFIG.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());
		JSON_CONFIG.registerJsonValueProcessor(JsonEntity.class, new JsonEntityProcessor());
	}

	public static String parseObject(Object object) {
		return JSONObject.fromObject(object, JSON_CONFIG).toString();
	}

	public static String parseArray(Object object) {
		return JSONArray.fromObject(object, JSON_CONFIG).toString();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String toJson(Object o) {
		if (o == null)
			return "null";
		if (o instanceof String)
			return string2Json((String) o);
		if (o instanceof Boolean)
			return boolean2Json((Boolean) o);
		if (o instanceof Number)
			return number2Json((Number) o);
		if (o instanceof Map)
			return map2Json((Map<Object, Object>) o);
		if (o instanceof Object[])
			return array2Json((Object[]) o);
		if (o instanceof int[])
			return intArray2Json((int[]) o);
		if (o instanceof boolean[])
			return booleanArray2Json((boolean[]) o);
		if (o instanceof long[])
			return longArray2Json((long[]) o);
		if (o instanceof float[])
			return floatArray2Json((float[]) o);
		if (o instanceof double[])
			return doubleArray2Json((double[]) o);
		if (o instanceof short[])
			return shortArray2Json((short[]) o);
		if (o instanceof byte[])
			return byteArray2Json((byte[]) o);
		if (o instanceof List)
			return list2Json((List) o);
		throw new RuntimeException("Unsupported type: " + o.getClass().getName());
	}

	private static String array2Json(Object[] array) {
		if (array.length == 0)
			return "[]";
		StringBuilder sb = new StringBuilder(array.length << 4);
		sb.append('[');
		for (Object o : array) {
			sb.append(toJson(o));
			sb.append(',');
		}
		// set last ',' to ']':
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	private static String intArray2Json(int[] array) {
		if (array.length == 0)
			return "[]";
		StringBuilder sb = new StringBuilder(array.length << 4);
		sb.append('[');
		for (int o : array) {
			sb.append(Integer.toString(o));
			sb.append(',');
		}
		// set last ',' to ']':
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	private static String longArray2Json(long[] array) {
		if (array.length == 0)
			return "[]";
		StringBuilder sb = new StringBuilder(array.length << 4);
		sb.append('[');
		for (long o : array) {
			sb.append(Long.toString(o));
			sb.append(',');
		}
		// set last ',' to ']':
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	private static String booleanArray2Json(boolean[] array) {
		if (array.length == 0)
			return "[]";
		StringBuilder sb = new StringBuilder(array.length << 4);
		sb.append('[');
		for (boolean o : array) {
			sb.append(Boolean.toString(o));
			sb.append(',');
		}
		// set last ',' to ']':
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	private static String floatArray2Json(float[] array) {
		if (array.length == 0)
			return "[]";
		StringBuilder sb = new StringBuilder(array.length << 4);
		sb.append('[');
		for (float o : array) {
			sb.append(Float.toString(o));
			sb.append(',');
		}
		// set last ',' to ']':
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	private static String doubleArray2Json(double[] array) {
		if (array.length == 0)
			return "[]";
		StringBuilder sb = new StringBuilder(array.length << 4);
		sb.append('[');
		for (double o : array) {
			sb.append(Double.toString(o));
			sb.append(',');
		}
		// set last ',' to ']':
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	private static String shortArray2Json(short[] array) {
		if (array.length == 0)
			return "[]";
		StringBuilder sb = new StringBuilder(array.length << 4);
		sb.append('[');
		for (short o : array) {
			sb.append(Short.toString(o));
			sb.append(',');
		}
		// set last ',' to ']':
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	private static String byteArray2Json(byte[] array) {
		if (array.length == 0)
			return "[]";
		StringBuilder sb = new StringBuilder(array.length << 4);
		sb.append('[');
		for (byte o : array) {
			sb.append(Byte.toString(o));
			sb.append(',');
		}
		// set last ',' to ']':
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	private static String map2Json(Map<Object, Object> map) {
		if (map.isEmpty())
			return "{}";
		StringBuilder sb = new StringBuilder(map.size() << 4);
		sb.append('{');
		Set<Object> keys = map.keySet();
		for (Object key : keys) {
			Object value = map.get(key);
			if (key instanceof String) {
				sb.append(toJson(key));
			} else {
				sb.append('\"');
				sb.append(toJson(key));
				sb.append('\"');
			}
			sb.append(':');
			sb.append(toJson(value));
			sb.append(',');
		}
		// set last ',' to '}':
		sb.setCharAt(sb.length() - 1, '}');
		return sb.toString();
	}

	private static String list2Json(List<Object> list) {
		if (list.isEmpty())
			return "[]";
		StringBuilder sb = new StringBuilder(list.size() << 4);
		sb.append('[');
		for (Object value : list) {
			sb.append(toJson(value));
			sb.append(',');
		}
		// set last ',' to '}':
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	private static String boolean2Json(Boolean bool) {
		return bool.toString();
	}

	private static String number2Json(Number number) {
		return number.toString();
	}

	private static String string2Json(String s) {
		StringBuilder sb = new StringBuilder(s.length() + 20);
		sb.append('\"');
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '\"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '/':
				sb.append("\\/");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			default:
				sb.append(c);
			}
		}
		sb.append('\"');
		return sb.toString();
	}

}
