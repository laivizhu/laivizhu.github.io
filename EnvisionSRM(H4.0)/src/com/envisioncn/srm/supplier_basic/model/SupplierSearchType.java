/**
 * 
 */
package com.envisioncn.srm.supplier_basic.model;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
public enum SupplierSearchType {
	SUPPLIERCODE("供应商编号", "code"), SUPPLIERNAME("供应商名称", "name"), SUPPLIERPERSON("负责人", "personName");

	private final String text;
	private final String property;

	SupplierSearchType(String text, String property) {
		this.text = text;
		this.property = property;
	}

	public String toText() {
		return this.text;
	}

	public String toProperty() {
		return this.property;
	}

	public static SupplierSearchType fromValue(String text) {
		for (SupplierSearchType type : values()) {
			if (type.toText().equals(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}

}
