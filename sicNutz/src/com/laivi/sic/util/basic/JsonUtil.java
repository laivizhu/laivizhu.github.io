package com.laivi.sic.util.basic;

import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.laivi.knowledge.basic.model.po.JsonEntity;

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
}
