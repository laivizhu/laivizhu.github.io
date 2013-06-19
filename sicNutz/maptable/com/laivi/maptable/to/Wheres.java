package com.laivi.maptable.to;

import java.util.ArrayList;


@SuppressWarnings("serial")
public class Wheres extends ArrayList<Where> {
	
	public static Wheres newWheres(){
		return new Wheres();
	}
	
	public Wheres where(String field,String cnd,Object value){
		this.add(new WhereCnd(field,cnd,value));
		return this;
	}
	

}
