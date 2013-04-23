/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.basic.model.po;

/**
 * @author laivi
 * Desc:
 */
public interface IBasicJsonEntity extends IBasicDBEntity {
	String toJson();
	
	String toFormJson(boolean success);
}
