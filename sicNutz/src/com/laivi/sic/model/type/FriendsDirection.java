package com.laivi.sic.model.type;


/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum FriendsDirection implements BasicType<FriendsDirection>{
	INIT("建立"),
	REJECT("拒绝"),
	BEFORE("前向"),
	AFTER("后向"),
	DOUBLE("双向");
	
	private final String text;
	
	FriendsDirection(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
		
	public static FriendsDirection fromText(String value) {
		for (FriendsDirection type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
		

	@Override
	public FriendsDirection getFromText(String text) {
		return FriendsDirection.fromText(text);
	}

}