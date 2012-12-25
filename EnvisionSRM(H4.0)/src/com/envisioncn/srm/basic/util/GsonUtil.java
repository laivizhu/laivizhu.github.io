package com.envisioncn.srm.basic.util;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date 2012-11-17
 * 
 */
public class GsonUtil {

	public static <T extends List<?>> String toJson(T list, int itemCount) {

		StringBuffer data = new StringBuffer();
		Gson gson = new Gson();
		Type type = new TypeToken<T>() {
		}.getType();
		gson.toJson(list, type);
		data.append("{\"root\":");
		data.append(gson.toJson(list, type));
		data.append(",");
		data.append("\"totalItem\":");
		data.append(itemCount);
		data.append("}");
		return data.toString();
	}

	public static String toJson(JsonElement element, int recordsCount) {
		Gson gson = new Gson();
		StringBuffer data = new StringBuffer();
		data.append("{\"root\":");
		data.append(gson.toJson(element));
		data.append(",");
		data.append("\"totalItem\":");
		data.append(recordsCount);
		data.append("}");
		return data.toString();
	}

}
