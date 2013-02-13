package com.laivi.knowledge.basic.model.type;

/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum InformationLevel implements BasicType<InformationLevel>{
	COMMON("一般"),
	URGENT("紧急"),
	SERIOUS("严重");
	
	private final String text;
	
	InformationLevel(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	public static InformationLevel fromText(String value) {
		for (InformationLevel type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	@Override
	public InformationLevel getFromText(String text) {
		return InformationLevel.fromText(text);
	}

}