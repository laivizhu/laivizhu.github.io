package com.laivi.maptable.to;


public class WhereCnd implements Where{

	private String field;

	private String condition;

	private Object value;

	public WhereCnd(String field, String condition, Object value) {
		this.field = field;
		this.condition = condition;
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toSql() {
		return null;
	}
}
