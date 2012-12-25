package com.envisioncn.srm.contract.common;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version 1.0
 * @data 2012-11-25
 */

public enum YearContractType {
	YearContract("生产性物料年度合同模板","0"),
	YearContractNo("非生产性物料年度合同模板","1");
	
	private final String text;
	private final String property;
	
	YearContractType(String text,String property){
		this.text=text;
		this.property=property;
	}
	
	public String toText(){
		return this.text;
	}
	
	public String toProperty(){
		return this.property;
	}
	
	public static YearContractType fromValue(String text) {
		for (YearContractType type : values()) {
			if (type.toProperty().equals(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}
	

}

