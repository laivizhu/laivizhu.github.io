package com.envisioncn.srm.material.model;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
public enum NormType {
	Norm1("", 0), Norm2("", 1);

	private final String text;
	private final int value;

	NormType(String text, int value) {
		this.text = text;
		this.value = value;
	}

	public String toText() {
		return text;
	}

	public int toValue() {
		return value;
	}

	public static NormType fromValue(String text) {
		for (NormType type : values()) {
			if (type.toText().endsWith(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}

	public static NormType fromValue(int value) {
		for (NormType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}

}
