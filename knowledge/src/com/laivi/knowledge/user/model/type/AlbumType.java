package com.laivi.knowledge.user.model.type;

/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum AlbumType {
	MUSIC("音乐专辑",1),
	PICTURE("图片相册",2);
	
	private final String text;
	private final int value;
	
	AlbumType(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public String toText() {
		return text;
	}
	
	public int toValue() {
		return value;
	}
	
	public static AlbumType fromText(String value) {
		for (AlbumType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	public static AlbumType fromValue(int value) {
		for (AlbumType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}