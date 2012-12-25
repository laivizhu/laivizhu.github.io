package com.envisioncn.srm.supplier_development.common;

/**
 * Copyright Envision
 * 
 * @author Mars
 * @version
 * @data 2012-11-17
 */
public enum SecuritState {
	STATE_UNCONFIRM("待确认",0),
	STATE_CONFIRM("已确认",1),
	STATE_EFFECT("已生效",2),
	STATE_DELETE("已作废",3);
	
	
	private final String text;
	private final int value;
	
	SecuritState(String text,int value){
		this.text=text;
		this.value=value;
	}
	
	public int toValue(){
		return this.value;
	}
	
	public String toText(){
		return this.text;
	}
	
	public static SecuritState fromValue(int value){
		for(SecuritState state:values()){
			if(state.toValue()==value){
				return state;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
}
