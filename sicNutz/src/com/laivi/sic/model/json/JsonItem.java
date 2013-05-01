/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.model.json;

import java.util.HashMap;

import org.nutz.json.Json;

/**
 * @author laivi
 * Desc:
 */
@SuppressWarnings("serial")
public class JsonItem extends HashMap<String,Object>{
	public JsonItem add(String key, Object value) {
		this.put(key, value);
		return this;
	}
	
	public String toJsonForm(boolean success){
		return new FormDataItem<JsonItem>(true,this).returnJson();
	}
	
	public String returnJson(){
		return Json.toJson(this);
	}
}
