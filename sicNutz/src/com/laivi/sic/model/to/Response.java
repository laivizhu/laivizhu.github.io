package com.laivi.sic.model.to;


public class Response {
	@SuppressWarnings("unused")
	private boolean success;
	
	@SuppressWarnings("unused")
	private String msg;

	public Response(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
}
