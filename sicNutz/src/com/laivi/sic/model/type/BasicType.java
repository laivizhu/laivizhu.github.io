/**
 * Copyright Laivi 2013-4-14
 * Version 1.0 sic
 */
package com.laivi.sic.model.type;

/**
 * @author laivi
 * Desc:
 */
public interface BasicType<T> {
	String toText();
	T getFormText(String text);
}
