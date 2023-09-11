package com.example.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


import com.example.views.PersonaView;

@Entity
@Table(name="personas")
public class Persona {

	@Id
	@Column(name="documento",length = 20) //RECORDATORIO PONER EL LARGO DEL VARCHAR DE LA BD
	private String documento;
	private String nombre;
	private String mail;
	@Column(name="contrasenia")
	private String password;


	public Persona(){

	}

	public Persona(String documento, String nombre, String mail, String password) {
		this.documento = documento;
		this.nombre = nombre;
		this.mail = mail;
		this.password = password;
	}

	public void cambiarPassword(String password) {
		this.password = password;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}


	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public PersonaView toView() {
		return new PersonaView(documento, nombre);
	}
}
