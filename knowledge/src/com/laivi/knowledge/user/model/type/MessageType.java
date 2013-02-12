package com.laivi.knowledge.user.model.type;

/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum MessageType {
	CONFIRM("确认",1),
	ALERT("警告",2),
	INFORMATION("信息",3),
	REQUEST("请求",4);
	
	private final String text;
	private final int value;
	
	MessageType(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public String toText() {
		return text;
	}
	
	public int toValue() {
		return value;
	}
	
	public static MessageType fromText(String value) {
		for (MessageType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	public static MessageType fromValue(int value) {
		for (MessageType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}