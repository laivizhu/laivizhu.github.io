package com.envisioncn.srm.material.model;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
public enum LevelType {
	Property("属性级别", 0), Target("指标", 1);

	private final String text;
	private final int value;

	LevelType(String text, int value) {
		this.text = text;
		this.value = value;
	}

	public String toText() {
		return text;
	}

	public int toValue() {
		return value;
	}

	public static LevelType fromValue(String text) {
		for (LevelType type : values()) {
			if (type.toText().endsWith(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}

	public static LevelType fromValue(int value) {
		for (LevelType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}

}
