package com.laivi.knowledge.shopping.model.type;

/**
 * User: laivi.zhu
 * Time: 13-01-17 下午11:32
 */
public enum StatusType {
	INIT("购物中",1),CONFIRM("已提交，等待发货",2),WAITING("发货中,等待确认",3),FINISH("确认收货,交易成功",4),RETURN("退货",5);
	
	private final String text;
	private final int value;
	
	StatusType(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public String toText() {
		return text;
	}
	
	public int toValue() {
		return value;
	}
	
	public static StatusType fromText(String value) {
		for (StatusType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	public static StatusType fromValue(int value) {
		for (StatusType type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}