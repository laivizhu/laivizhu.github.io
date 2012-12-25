package com.envisioncn.srm.supplier_basic.common;


/**
 * Copyright Envision
 * 
 * @author Mars
 * @version
 * @data 2012-12-03
 */
public enum CarDepartmentState {
	PURCHASE_DEPARTMENT("采购部",0),
	QUALITY_DEPARTMENT("质量工程部",1);
	
	
	private final String text;
	private final int value;
	
	CarDepartmentState(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public int toValue(){
		return this.value;
	}
	
	public String toText(){
		return this.text;
	}
	
	public static CarDepartmentState fromValue(int value){
		for(CarDepartmentState state:values()){
			if(state.toValue()==value){
				return state;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}
