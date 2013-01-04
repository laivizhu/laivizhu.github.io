package com.laivi.knowledge.basic.model.exception;

import com.laivi.knowledge.basic.util.CommonUtil;

@SuppressWarnings("serial")
public class ErrorException extends Exception {
	public ErrorException(String message) {
        super(CommonUtil.getI18NMsg(message));
	}

    public ErrorException(String message,boolean isMessage){
        super(message);
    }

	public ErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
