package com.laivi.knowledge.user.model.type;

/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum FriendsDirection {
	INIT("建立",0),
	REJECT("决绝",1),
	BEFORE("前向",2),
	AFTER("后向",3),
	DOUBLE("双向",4);
	
	private final String text;
	private final int value;
	
	FriendsDirection(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public String toText() {
		return text;
	}
	
	public int toValue() {
		return value;
	}
	
	public static FriendsDirection fromText(String value) {
		for (FriendsDirection type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	public static FriendsDirection fromValue(int value) {
		for (FriendsDirection type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}