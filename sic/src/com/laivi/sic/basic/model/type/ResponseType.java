package com.laivi.sic.basic.model.type;

/**
 * User: dizem
 * Time: 12-6-18 下午11:32
 */
public enum ResponseType {
	JSON("text/json;charset=UTF-8"),
	HTML("text/html;charset=UTF-8");

	private final String text;

	ResponseType(String text) {
		this.text = text;
	}

	public String toText() {
		return text;
	}
}