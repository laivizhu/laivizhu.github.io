package com.laivi.sic.model.json;

import org.nutz.json.Json;


/**
 * @author laivi
 *
 */
public class FormDataItem<T> {
	private boolean success;
	
	private T data;
	
	public FormDataItem(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}

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
	
	public String returnJson(){
		return Json.toJson(this);
	}

}
