package com.laivi.knowledge.common.model.type;

import com.laivi.knowledge.basic.model.type.BasicType;

/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum FromOtherType implements BasicType<FromOtherType> {
	KNOWLEDGE("知识"),
	ARTICLE("文章"),
	PICTURE("图片"),
	MUSIC("音乐");
	
	private final String text;
	
	FromOtherType(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	public static FromOtherType fromText(String value) {
		for (FromOtherType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}

	@Override
	public FromOtherType getFromText(String text) {
		return FromOtherType.fromText(text);
	}
}