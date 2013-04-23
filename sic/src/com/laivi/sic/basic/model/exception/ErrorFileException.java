package com.laivi.sic.basic.model.exception;

@SuppressWarnings("serial")
public class ErrorFileException extends Exception {
    public ErrorFileException(String message) {
		super(message);
	}

	public ErrorFileException(String message, Throwable cause) {
		super(message, cause);
	}
}
