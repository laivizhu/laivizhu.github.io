package com.laivi.sic.model.type;


/**
 * User: laivi.zhu
 * Time: 13-01-17 下午11:32
 */
public enum CategoryLevel implements BasicType<CategoryLevel>{
	Root("商品大类"),SecondLevel("商品二级类别"),ThirdLevel("商品三级类别");
	
	private final String text;
	
	CategoryLevel(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
	
	public static CategoryLevel fromText(String value) {
		for (CategoryLevel type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}

	@Override
	public CategoryLevel getFromText(String text) {
		return CategoryLevel.fromText(text);
	}
}