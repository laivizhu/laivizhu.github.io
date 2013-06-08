package com.laivi.maptable.type;

public enum ConditionType {

	EQ("="), LE("<="), GE(">="), LT("<"), GT(">"), LIEK("like"), BETWEENT("between"),IN("in"),NOT("!="), OR("or"),AND("and"), DESCORDER(
			"desc"), ACSORDER("asc");
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
		return ConditionType.EQ;
	}
}
