/**
 * 
 */
package com.envisioncn.srm.basic.model.type;

/**
 * @author Janlu
 * 
 */
public enum ConditionType {

	EQ("大于"), LE("小于等于"), GE("大于等于"), LT("小于"), GT("大于"), LIEK("类似于"), BETWEENT("两者之间"), NOT("否定"), OR("或"), DESCORDER(
			"按什么降序"), ACSORDER("按什么升序");
	private final String text;

	ConditionType(String text) {
		this.text = text;
	}

	public String toText() {
		return text;
	}

	public static ConditionType fromValue(String text) {
		for (ConditionType type : values()) {
			if (type.toText().endsWith(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}
}
