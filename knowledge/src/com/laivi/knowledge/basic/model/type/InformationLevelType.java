package com.laivi.knowledge.basic.model.type;

/**
 * User: dizem
 * Time: 12-6-18 下午11:32
 */
public enum InformationLevelType {
	COMMON("一般",1),
	URGENT("紧急",2),
	SERIOUS("严重",3);
	
	private final String text;
	private final int value;
	
	InformationLevelType(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public String toText() {
		return text;
	}
	
	public int toValue() {
		return value;
	}
	
	public static InformationLevelType fromText(String value) {
		for (InformationLevelType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	public static InformationLevelType fromValue(int value) {
		for (InformationLevelType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}