package com.laivi.knowledge.basic.model.type;


/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum ExceptionType implements BasicType<ExceptionType>{
	
	SUCCESS("成功"),
	NUMBERPARSE("字符数据转换数据值异常,有不合法字符数据"),
	NULLVALUE("空值异常，数据不完整"),
	DATEPARSE("日期转换异常，日期格式错误"),
	SQLERROR("数据库语法错误,SQL操作语法不合法"),
	OUTARRAY("数据越界异常"),
	DATAUNIQUE("数据重复异样"),
	IO("文件操作异样");
	
	private final String text;
	
	ExceptionType(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	public ExceptionType getFromText(String value){
		return ExceptionType.fromText(value);
	}

	public static ExceptionType fromText(String value) {
		for (ExceptionType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}