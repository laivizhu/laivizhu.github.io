package com.laivi.knowledge.knowledge.model.type;

import com.laivi.knowledge.basic.model.type.BasicType;

/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum TagType implements BasicType<TagType>{
	KNOWLEDGE("知识"),
	ARTICLE("文章");
	
	private final String text;
	
	
	TagType(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	public static TagType fromText(String value) {
		for (TagType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	@Override
	public TagType getFromText(String text) {
		return TagType.fromText(text);
	}
}