/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.basic.action;

/**
 * @author laivi
 * Desc:
 */
public interface IBasicDBAction<T> extends IBasicAction{

	String add() throws Exception;
	String delete()throws Exception;
	String deletes()throws Exception;
	String update()throws Exception;
	String list()throws Exception;
	String get()throws Exception;
	
	
	
}
