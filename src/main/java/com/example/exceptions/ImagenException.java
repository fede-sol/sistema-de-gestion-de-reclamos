package com.example.exceptions;

public class ImagenException extends RuntimeException {

	private static final long serialVersionUID = 6332415080946078382L;

	public ImagenException(String mensaje) {
		super(mensaje);
	}
}
