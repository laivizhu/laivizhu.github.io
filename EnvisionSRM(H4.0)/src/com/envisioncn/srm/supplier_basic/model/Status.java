package com.envisioncn.srm.supplier_basic.model;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
public enum Status {
	LISTALL("列出全部", -1), APPLYING("待初审", 0), FINALLY("待终审", 1), PASS("通过", 2), UNPASS("不通过", 3), STOP("终止", 4);

	private final String text;
	private final int value;

	Status(String text, int value) {
		this.text = text;
		this.value = value;
	}

	public String toText() {
		return text;
	}

	public int toValue() {
		return value;
	}

	public static Status fromValue(String text) {
		for (Status type : values()) {
			if (type.toText().endsWith(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}

	public static Status fromValue(int value) {
		for (Status type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}

}
