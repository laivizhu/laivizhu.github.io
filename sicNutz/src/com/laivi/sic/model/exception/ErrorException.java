package com.laivi.sic.model.exception;



@SuppressWarnings("serial")
public class ErrorException extends Exception {
	public ErrorException(String message) {
        super(message);
	}

    public ErrorException(String message,boolean isMessage){
        super(message);
    }

	public ErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
