package com.example.views;

public class PersonaView {

	private String documento;
	private String nombre;
	private String mail;

	public PersonaView() {}

	public PersonaView(String documento, String nombre, String mail) {
		this.documento = documento;
		this.nombre = nombre;
		this.mail = mail;

	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail(){
		return mail;
	}

	public String toString() {
		return documento + " " + nombre;
	}
}
