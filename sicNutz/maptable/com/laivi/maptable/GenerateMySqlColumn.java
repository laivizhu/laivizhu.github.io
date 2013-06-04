package com.laivi.maptable;

public enum GenerateMySqlColumn {

	STRING("class java.lang.String","varchar(255)"),
	LONG("long","bigint(64)"),
	INT("int","int(32)"),
	BOOLEAN("boolean","tinyint(1)"),
	DATE("class java.util.Date","datetime");
	
	private final String type;
	private final String column;
	
	GenerateMySqlColumn(String type,String column){
		this.type=type;
		this.column=column;
	}
	
	public String toType(){
		return this.type;
	}
	
	public String toColumn(){
		return this.column;
	}
	
	public static GenerateMySqlColumn fromType(String type){
		for(GenerateMySqlColumn tempColumn:values()){
			if(tempColumn.toType().equals(type)){
				return tempColumn;
			}
		}
		return GenerateMySqlColumn.STRING;
	}
}
