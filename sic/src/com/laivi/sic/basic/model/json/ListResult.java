package com.laivi.sic.basic.model.json;

import java.util.List;

import net.sf.json.JSONObject;

public class ListResult<T> {
	private List<T> root;
	private int totalProperty;
	private boolean success=true;

	public ListResult() {
	}

	public ListResult(List<T> root, int totalProperty) {
		this.root = root;
		this.totalProperty = totalProperty;
	}

	public List<T> getRoot() {
		return root;
	}

	public void setRoot(List<T> root) {
		this.root = root;
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public String toJson() {
		return JSONObject.fromObject(this).toString();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
