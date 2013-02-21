package com.laivi.knowledge.common.model.type;

import com.laivi.knowledge.basic.model.type.BasicType;

/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum CategoryType implements BasicType<CategoryType> {
	KNOWLEDGE("知识"),
	ARTICLE("文章"),
	COMMOTITY("商品"),
	PICTURE("图片"),
	MUSIC("音乐");
	
	private final String text;
	
	CategoryType(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	public static CategoryType fromText(String value) {
		for (CategoryType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}

	@Override
	public CategoryType getFromText(String text) {
		return CategoryType.fromText(text);
	}
}