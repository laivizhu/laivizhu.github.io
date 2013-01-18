package com.laivi.knowledge.common.model.type;

/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum FavoriteType {
	KNOWLEDGE("知识",1),
	ARTICLE("文章",2),
	COMMOTITY("商品",3);
	
	private final String text;
	private final int value;
	
	FavoriteType(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public String toText() {
		return text;
	}
	
	public int toValue() {
		return value;
	}
	
	public static FavoriteType fromText(String value) {
		for (FavoriteType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	public static FavoriteType fromValue(int value) {
		for (FavoriteType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}