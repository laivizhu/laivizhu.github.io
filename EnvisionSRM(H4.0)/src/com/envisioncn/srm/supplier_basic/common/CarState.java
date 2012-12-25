package com.envisioncn.srm.supplier_basic.common;


/**
 * Copyright Envision
 * 
 * @author Mars
 * @version
 * @data 2012-12-03
 */
public enum CarState {
	STATE_UNSTART("未开始",0),
	STATE_ACTIVATED("已启动",1),
	STATE_FINISH("已完成",2);
	
	
	private final String text;
	private final int value;
	
	CarState(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public int toValue(){
		return this.value;
	}
	
	public String toText(){
		return this.text;
	}
	
	public static CarState fromValue(int value){
		for(CarState state:values()){
			if(state.toValue()==value){
				return state;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}
