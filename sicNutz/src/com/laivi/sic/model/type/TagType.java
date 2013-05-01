package com.laivi.sic.model.type;

public enum TagType {
	ARTICLE("文章"),KNOWLEDGE("知识");
	
	private final String text;
	
	TagType(String text){
		this.text=text;
	}
	
	public String toText(){
		return this.text;
	}
}
