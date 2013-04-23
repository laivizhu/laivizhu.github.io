/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.basic.model.json;

import java.util.HashMap;

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
		return null;
	}
	
	public String toString(){
		return null;
	}
}
