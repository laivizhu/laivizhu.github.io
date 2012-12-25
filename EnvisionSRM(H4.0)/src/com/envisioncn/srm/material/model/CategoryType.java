package com.envisioncn.srm.material.model;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
public enum CategoryType {
	MaterialClassify("物料分类", 0), MaterialCategory("物料类别", 1), MaterialSubCategory("物料子类别", 2), MaterialTeam("物料小组", 3);

	private final String text;
	private final int value;

	CategoryType(String text, int value) {
		this.text = text;
		this.value = value;
	}

	public String toText() {
		return text;
	}

	public int toValue() {
		return value;
	}

	public static CategoryType fromValue(String text) {
		for (CategoryType type : values()) {
			if (type.toText().endsWith(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}

	public static CategoryType fromValue(int value) {
		for (CategoryType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}

}
