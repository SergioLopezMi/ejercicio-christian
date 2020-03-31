package com.sergio.coches.exception;

public class ObjetoNoEncontradoException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ObjetoNoEncontradoException(String message) {
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
