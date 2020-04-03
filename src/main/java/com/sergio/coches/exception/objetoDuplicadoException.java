package com.sergio.coches.exception;

public class ObjetoDuplicadoException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public ObjetoDuplicadoException(String message) {
		this.message = message;
	}
}
