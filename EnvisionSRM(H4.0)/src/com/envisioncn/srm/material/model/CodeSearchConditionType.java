package com.envisioncn.srm.material.model;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-17
 */
public enum CodeSearchConditionType {
	Code("SAP Code", "code"), Name("物料名称", "name"), CategoryName("所属类别", "materialCategory.name"), CreateDate("创建日期",
			"inDate"), ModifyDate("修改日期", "modifyDate");

	private final String text;
	private final String property;

	CodeSearchConditionType(String text, String property) {
		this.text = text;
		this.property = property;
	}

	public String toText() {
		return this.text;
	}

	public String toProperty() {
		return this.property;
	}

	public static CodeSearchConditionType fromValue(String text) {
		for (CodeSearchConditionType type : values()) {
			if (type.toText().endsWith(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}

}
