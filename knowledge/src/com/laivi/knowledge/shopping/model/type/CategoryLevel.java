package com.laivi.knowledge.shopping.model.type;

/**
 * User: laivi.zhu
 * Time: 13-01-17 下午11:32
 */
public enum CategoryLevel {
	Root("商品大类",1),SecondLevel("商品二级类别",2),ThirdLevel("商品三级类别",3);
	
	private final String text;
	private final int value;
	
	CategoryLevel(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public String toText() {
		return text;
	}
	
	public int toValue() {
		return value;
	}
	
	public static CategoryLevel fromText(String value) {
		for (CategoryLevel type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	public static CategoryLevel fromValue(int value) {
		for (CategoryLevel type : values()) {
			if (type.toValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}