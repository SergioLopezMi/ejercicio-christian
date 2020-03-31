package com.sergio.coches.exception;

public class objetoDuplicadoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public objetoDuplicadoException(String message) {		
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public String getLocalizedMessage() {
		return message;
	}
}
