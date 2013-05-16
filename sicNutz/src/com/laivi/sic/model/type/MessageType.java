package com.laivi.sic.model.type;


/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum MessageType implements BasicType<MessageType>{
	CONFIRM("确认"),
	ALERT("警告"),
	INFORMATION("信息"),
	REQUEST("请求");
	
	private final String text;
	
	MessageType(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
		
	public static MessageType fromText(String value) {
		for (MessageType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	@Override
	public MessageType getFromText(String text) {
		return MessageType.fromText(text);
	}

}