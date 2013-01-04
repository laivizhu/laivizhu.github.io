package com.laivi.knowledge.basic.model.type;

/**
 * User: dizem
 * Time: 12-6-18 下午11:32
 */
public enum ExceptionType {
	
	SUCCESS("成功",0),
	NUMBERPARSE("字符数据转换数据值异常,有不合法字符数据",1),
	NULLVALUE("空值异常，数据不完整",2),
	DATEPARSE("日期转换异常，日期格式错误",3),
	SQLERROR("数据库语法错误,SQL操作语法不合法",4),
	OUTARRAY("数据越界异常",5),
	DATAUNIQUE("数据重复异样",6),
	IO("文件操作异样",7);
	
	private final String text;
	private final int value;
	
	ExceptionType(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public String toText() {
		return text;
	}
	
	public int toValue() {
		return value;
	}
	
	public static ExceptionType fromText(String value) {
		for (ExceptionType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	public static ExceptionType fromValue(int value) {
		for (ExceptionType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}