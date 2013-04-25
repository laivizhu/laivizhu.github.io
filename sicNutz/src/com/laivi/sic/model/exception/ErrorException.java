package com.laivi.sic.model.exception;

import com.laivi.sic.util.basic.CommonUtil;


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
