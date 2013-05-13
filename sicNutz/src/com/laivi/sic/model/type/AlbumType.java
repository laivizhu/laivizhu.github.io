package com.laivi.sic.model.type;


/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum AlbumType implements BasicType<AlbumType>{
	MUSIC("音乐专辑"),
	PICTURE("图片相册");
	
	private final String text;
	
	AlbumType(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	public static AlbumType fromText(String value) {
		for (AlbumType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}

	@Override
	public AlbumType getFormText(String text) {
		return AlbumType.fromText(text);
	}
}