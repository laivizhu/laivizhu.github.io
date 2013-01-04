package com.laivi.knowledge.basic.model.json;

import net.sf.json.JSONObject;

/**
 * @author Administrator
 *
 */
public class FromDataItem<T> {
	private boolean success;
	
	private T data;
	
	public FromDataItem(boolean success, T data) {
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

	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
	
	
	
}
