package com.laivi.knowledge.common.model.type;

import com.laivi.knowledge.basic.model.type.BasicType;

/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum FavoriteType implements BasicType<FavoriteType> {
	KNOWLEDGE("知识"),
	ARTICLE("文章"),
	COMMOTITY("商品"),
	PICTURE("图片"),
	MUSIC("音乐");
	
	private final String text;
	
	FavoriteType(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	public static FavoriteType fromText(String value) {
		for (FavoriteType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}

	@Override
	public FavoriteType getFromText(String text) {
		return FavoriteType.fromText(text);
	}
}