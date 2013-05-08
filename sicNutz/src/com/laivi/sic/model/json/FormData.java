package com.laivi.sic.model.json;



/**
 * @author laivi
 *
 */
public class FormData {
	private boolean success;
	
	private Object data;
	
	public FormData(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
