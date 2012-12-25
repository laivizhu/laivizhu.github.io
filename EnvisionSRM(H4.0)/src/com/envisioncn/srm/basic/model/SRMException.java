package com.envisioncn.srm.basic.model;

/**
 * Copyright Envision 系统自定义异常
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
@SuppressWarnings("serial")
public class SRMException extends Exception {
	public SRMException(String message) {
		super(message);
	}

	public SRMException(String message, Throwable cause) {
		super(message, cause);
	}

}
