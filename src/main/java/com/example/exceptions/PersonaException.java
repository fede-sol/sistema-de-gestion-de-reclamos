package com.example.exceptions;

public class PersonaException extends RuntimeException {

	private static final long serialVersionUID = -2835873129858130160L;

	public PersonaException(String mensaje) {
		super(mensaje);
	}
}
