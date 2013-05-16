package com.laivi.sic.model.type;

import com.laivi.sic.model.po.media.Music;
import com.laivi.sic.model.po.media.Picture;


/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum AlbumType implements BasicType<AlbumType>{
	MUSIC("音乐专辑",Music.class),
	PICTURE("图片相册",Picture.class);
	
	private final String text;
	private final Class<?> klass; 
	
	AlbumType(String text,Class<?> klass){
		this.klass=klass;
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	public Class<?> toKlass(){
		return klass;
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
	public AlbumType getFromText(String text) {
		return AlbumType.fromText(text);
	}
}