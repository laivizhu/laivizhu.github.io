/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laivi
 * Desc:
 */
@SuppressWarnings("serial")
public final class JsonList implements Serializable {
	private boolean success=true;
	private int totalProperty;
	private List<Object> root = new ArrayList<Object>();
	
	
	public JsonList() {
	}

	public JsonList(List<Object> root, int totalProperty) {
		this.root = root;
		this.totalProperty = totalProperty;
	}
	public void add(Object item) {
        root.add(item);
    }
	
	public void setSize(){
		this.totalProperty=this.root.size();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public List<Object> getRoot() {
		return root;
	}

	public void setRoot(List<Object> root) {
		this.root = root;
	}
	
	
}
