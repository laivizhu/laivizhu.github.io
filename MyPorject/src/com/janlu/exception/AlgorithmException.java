/**
 * 
 */
package com.janlu.exception;

/**
 * @author janlu
 *
 */
@SuppressWarnings("serial")
public class AlgorithmException extends Exception{
	public AlgorithmException(String message) {
		super(message);
	}

	public AlgorithmException(String message, Throwable cause) {
		super(message, cause);
	}
}
