/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.model.po.basic;



/**
 * @author laivi
 * Desc:
 */
public interface IBasicDBEntity extends IJsonEntity{
	
	long getId();
	
	boolean isDeleteIs();
	
	void setDeleteIs(boolean deleteIs);
	
	
}
