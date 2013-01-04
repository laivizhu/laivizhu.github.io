package com.laivi.knowledge.basic.model.type;

/**
 * User: dizem
 * Time: 12-6-18 下午11:32
 */
public enum TagType {
	ARTICLE("文章",2),
	KNOWLEDGE("知识",1);
	
	private final String text;
	private final int value;
	
	TagType(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public String toText() {
		return text;
	}
	
	public int toValue() {
		return value;
	}
	
	public static TagType fromText(String value) {
		for (TagType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	public static TagType fromValue(int value) {
		for (TagType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}