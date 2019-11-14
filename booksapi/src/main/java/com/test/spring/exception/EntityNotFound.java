package com.test.spring.exception;

public class EntityNotFound extends RuntimeException{
	private String exceptionMsg;
	

	public EntityNotFound(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	
}
