package com.envisioncn.srm.basic.model;

import com.envisioncn.srm.basic.model.type.ConditionType;

/**
 * @author Janlu
 * 
 */
public class Condition {

	private String property;

	private ConditionType conditonType;

	private Object firstValue;

	private Object secondValue;

	private boolean isCascade;

	public Condition() {
	}

	public Condition(String property, ConditionType conditionType) {
		this(property, conditionType, null, null, false);
	}

	public Condition(String property, ConditionType conditionType, Object firstValue, Object secondValue,
			boolean isCascade) {
		this.property = property;
		this.conditonType = conditionType;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.isCascade = isCascade;
	}

	public Condition(String property, Object firstValue) {
		this(property, ConditionType.EQ, firstValue, null, false);
	}

	public Condition(String property, Object firstValue, boolean isCascade) {
		this(property, ConditionType.EQ, firstValue, null, isCascade);
	}

	public Condition(String property, ConditionType conditionType, Object firstValue) {
		this(property, conditionType, firstValue, null, false);
	}

	public Condition(String property, ConditionType conditionType, Object firstValue, boolean isCascade) {
		this(property, conditionType, firstValue, null, isCascade);
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public ConditionType getConditonType() {
		return conditonType;
	}

	public void setConditonType(ConditionType conditonType) {
		this.conditonType = conditonType;
	}

	public Object getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(Object firstValue) {
		this.firstValue = firstValue;
	}

	public Object getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(Object secondValue) {
		this.secondValue = secondValue;
	}

	public boolean isCascade() {
		return isCascade;
	}

	public void setCascade(boolean isCascade) {
		this.isCascade = isCascade;
	}

}
