package com.envisioncn.srm.material.model;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-17
 */
public enum CategorySearchConditionType {
	Name("类别名称", "name"), CategoryType("所属类别", "categoryType"), CreateDate("创建日期", "createDate"), ModifyDate("修改日期",
			"modifyDate");

	private final String text;
	private final String property;

	CategorySearchConditionType(String text, String property) {
		this.text = text;
		this.property = property;
	}

	public String toText() {
		return this.text;
	}

	public String toProperty() {
		return this.property;
	}

	public static CategorySearchConditionType fromValue(String text) {
		for (CategorySearchConditionType type : values()) {
			if (type.toText().endsWith(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}

}
