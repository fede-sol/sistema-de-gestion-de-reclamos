package com.example.exceptions;

public class ReclamoException extends RuntimeException {

	private static final long serialVersionUID = 6646850323041998390L;

	public ReclamoException(String mensaje) {
		super(mensaje);
	}
}
