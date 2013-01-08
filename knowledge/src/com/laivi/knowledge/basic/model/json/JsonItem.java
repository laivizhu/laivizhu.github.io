package com.laivi.knowledge.basic.model.json;

import java.util.HashMap;

import com.laivi.knowledge.basic.util.JsonUtil;

@SuppressWarnings("serial")
public class JsonItem extends HashMap<String, Object> {
	public JsonItem add(String key, Object value) {
		this.put(key, value);
		return this;
	}
	
	public String toFormDataString(boolean success){
		return new JsonFormData<JsonItem>(success,this).toJson();
	}
	
	public String toString(){
		return JsonUtil.parseObject(this);
	}
}
