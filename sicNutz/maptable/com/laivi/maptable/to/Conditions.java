package com.laivi.maptable.to;

import java.util.ArrayList;


@SuppressWarnings("serial")
public class Conditions extends ArrayList<Condition> implements Where{

	public static Conditions CreateCondition() {
		return new Conditions();
	}

	public Conditions put(Condition condition) {
		this.add(condition);
		return this;
	}

	@Override
	public String toSql() {
		StringBuilder sb=new StringBuilder(" where ");
		for(Condition con:this){
			switch(con.getConditonType()){
			case ACSORDER:
				break;
			case AND:
				break;
			case BETWEENT:
				break;
			case DESCORDER:
				break;
			case IN:
				break;
			case LIEK:
				break;
			case NOT:
				break;
			case OR:
				break;
			default:
				sb.append(con.getProperty()+con.getConditonType().toText()+con.getFirstValue()+" and ");
				break;
			}
		}
		return null;
	}
	
}
