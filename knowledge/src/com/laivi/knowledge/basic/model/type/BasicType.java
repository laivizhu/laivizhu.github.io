package com.laivi.knowledge.basic.model.type;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 13, 2013
 */
public interface BasicType<T> {
	String toText();
	T getFromText(String text);
}
