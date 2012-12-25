package com.envisioncn.srm.supplier_basic.common;


/**
 * Copyright Envision
 * 
 * @author Mars
 * @version
 * @data 2012-12-03
 */
public enum CarTaskState {
	TEMPORARY_MEASURE("临时措施",0),
	CAUSE_ANALYSIS("根本原因分析",1),
	PERMANENT_CORRECTIVE("永久性纠正措施",2),
	PREVENTIVE_ACTIONS("防止再发生",3);
	
	
	private final String text;
	private final int value;
	
	CarTaskState(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public int toValue(){
		return this.value;
	}
	
	public String toText(){
		return this.text;
	}
	
	public static CarTaskState fromValue(int value){
		for(CarTaskState state:values()){
			if(state.toValue()==value){
				return state;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}
