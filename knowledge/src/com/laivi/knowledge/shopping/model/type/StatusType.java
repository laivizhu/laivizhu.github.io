package com.laivi.knowledge.shopping.model.type;

import com.laivi.knowledge.basic.model.type.BasicType;

/**
 * User: laivi.zhu
 * Time: 13-01-17 下午11:32
 */
public enum StatusType implements BasicType<StatusType>{
	INIT("购物中"),CONFIRM("已提交，等待发货"),WAITING("发货中,等待确认"),FINISH("确认收货,交易成功"),RETURN("退货");
	
	private final String text;
	
	StatusType(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	
	public static StatusType fromText(String value) {
		for (StatusType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	@Override
	public StatusType getFromText(String text) {
		return StatusType.fromText(text);
	}

}