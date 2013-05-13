package com.laivi.sic.model.type;

public enum CategoryType {
	ARTICLE("文章"),
	KNOWLEDGE("知识"),
	COMMOTITY("商品"),
	PICTURE("图片"),
	MUSIC("音乐"),
	BOOK("书籍");
	
	private final String text;
	
	CategoryType(String text){
		this.text=text;
	}
	
	public String toText(){
		return this.text;
	}
}
