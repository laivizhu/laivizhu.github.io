package com.laivi.knowledge.basic.model.exception;

@SuppressWarnings("serial")
public class ErrorFileException extends Exception {
    public ErrorFileException(String message) {
		super(message);
	}

	public ErrorFileException(String message, Throwable cause) {
		super(message, cause);
	}
}
