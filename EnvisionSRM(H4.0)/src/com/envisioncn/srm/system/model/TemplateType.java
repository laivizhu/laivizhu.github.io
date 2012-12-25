/**
 * 
 */
package com.envisioncn.srm.system.model;


/**
 * Copyright Envision
 *
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-25
 */
public enum TemplateType {
	Supplier("供应商模板",0);
	
	private final String text;
	private final int value;
	
	TemplateType(String text,int value){
		this.text=text;
		this.value=value;
	}

	public String toText(){
		return this.text;
	}
	
	public int toValue(){
		return this.value;
	}
	
	public static TemplateType fromValue(String text) {
		for (TemplateType type : values()) {
			if (type.toText().endsWith(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}
	
	public static TemplateType fromValue(int value) {
		for (TemplateType type : values()) {
			if (type.toValue()==value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}
