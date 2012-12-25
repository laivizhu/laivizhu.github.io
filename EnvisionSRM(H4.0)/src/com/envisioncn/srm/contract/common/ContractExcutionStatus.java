package com.envisioncn.srm.contract.common;


/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version 1.0
 * @data 2012-11-25
 */

public enum ContractExcutionStatus {
	ContractCreated("已创建","00"),
	ContractPendingApproval("待审批","10"),
	ContractBeenApproval("已审批","20"),
	ContractUnBeenApproval("审批未通过","30"),
	ContractModify("变更待审批","40"),
	ContractModify1("已变更","45"),
	ContractCancel("取消待审批","50"),
	ContractOver("已终止","60");
	
	private final String text;
	private final String property;
	
	ContractExcutionStatus(String text,String property){
		this.text=text;
		this.property=property;
	}
	
	public String toText(){
		return this.text;
	}
	
	public String toProperty(){
		return this.property;
	}
	
	public static ContractExcutionStatus fromValue(String text) {
		for (ContractExcutionStatus status : values()) {
			if (status.toProperty().equals(text)) {
				return status;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}
	
	public static ContractExcutionStatus fromValue1(String property) {
		for (ContractExcutionStatus status : values()) {
			if (status.toProperty() == property) {
				return status;
			}
		}
		throw new IllegalArgumentException("not support value: " + property);
	}

}

