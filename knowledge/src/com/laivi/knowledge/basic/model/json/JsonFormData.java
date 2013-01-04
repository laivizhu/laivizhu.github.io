package com.laivi.knowledge.basic.model.json;

import net.sf.json.JSONObject;

public class JsonFormData<T> {
	private boolean success;
	
	private T data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public JsonFormData(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public String toJson(){
		return JSONObject.fromObject(this).toString();
	}

}
