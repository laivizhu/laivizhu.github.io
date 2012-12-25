package com.envisioncn.srm.basic.model.type;

/**
 * 
 * Copyright Envision 返回参数类型
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public enum ResponseType {
	JSON("text/json;charset=UTF-8"), HTML("text/html;charset=UTF-8");

	private final String text;

	ResponseType(String text) {
		this.text = text;
	}

	public String toText() {
		return text;
	}
}