package com.laivi.maptable;

public enum GenerateColumn {

	STRING("class java.lang.String","varchar(255)"),
	LONG("long","bigint(64)"),
	INT("int","int(32)"),
	BOOLEAN("boolean","tinyint(1)"),
	DATE("class java.util.Date","datetime");
	
	private final String type;
	private final String column;
	
	GenerateColumn(String type,String column){
		this.type=type;
		this.column=column;
	}
	
	public String toType(){
		return this.type;
	}
	
	public String toColumn(){
		return this.column;
	}
	
	public static GenerateColumn fromType(String type){
		for(GenerateColumn tempColumn:values()){
			if(tempColumn.toType().equals(type)){
				return tempColumn;
			}
		}
		return GenerateColumn.STRING;
	}
}
