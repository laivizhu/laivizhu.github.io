package com.laivi.sic.model.type;

public enum Status {
	UNREAD("未读"),READED("已读"),DELETED("已删除");
	
	private final String text;
	
	Status(String text){
		this.text=text;
	}
	
	public String toText(){
		return this.text;
	}
}
