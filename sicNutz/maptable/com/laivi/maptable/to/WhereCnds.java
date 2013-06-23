package com.laivi.maptable.to;

public class WhereCnds implements Where {

	private WhereCnd firstCnd;
	
	private WhereCnd secondCnd;
	
	private boolean isOr;
	
	public WhereCnds(WhereCnd firstCnd, boolean isOr, WhereCnd secondCnd) {
		this.firstCnd = firstCnd;
		this.isOr = isOr;
		this.secondCnd = secondCnd;
	}

	public static WhereCnds create(WhereCnd first,WhereCnd second){
		return new WhereCnds(first,false,second);
	}
	
	public static WhereCnds create(WhereCnd first,WhereCnd second,boolean isOr){
		return new WhereCnds(first,isOr,second);
	}
	
	
	
	@Override
	public String toSql() {
		// TODO Auto-generated method stub
		return null;
	}

}
