package com.laivi.maptable.to;

public class Order implements Where {
	
	public String field;
	
	private boolean isDesc;
	
	public Order(String field, boolean isDesc) {
		this.field = field;
		this.isDesc = isDesc;
	}

	public static Order desc(String field){
		return new Order(field,true);
	}
	
	public static Order asc(String field){
		return new Order(field,false);
	}
	

	@Override
	public String toSql() {
		return null;
	}

}
