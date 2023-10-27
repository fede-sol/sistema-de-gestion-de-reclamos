package com.example.views;

import java.util.List;

public class ReclamoView {

	private int numero;
	private PersonaView usuario;
	private EdificioView edificio;
	private String ubicacion;
	private String descripcion;
	private UnidadView unidad;
	private Estado estado;
	private List<ImagenView> imagenes;

	public ReclamoView() {
	}

	public ReclamoView(int numero, PersonaView usuario, EdificioView edificio, String ubicacion, String descripcion,
			UnidadView unidad, Estado estado, List<ImagenView> imagenes) {
		this.numero = numero;
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = estado;
		this.imagenes = imagenes;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public PersonaView getUsuario() {
		return this.usuario;
	}

	public void setUsuario(PersonaView usuario) {
		this.usuario = usuario;
	}

	public EdificioView getEdificio() {
		return this.edificio;
	}

	public void setEdificio(EdificioView edificio) {
		this.edificio = edificio;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ImagenView> getImagenes() {
		return this.imagenes;
	}

	public String toString() {
		return numero + " " + usuario + " " + edificio + " " + ubicacion + " " +
				descripcion + " " + unidad + " " + estado + " " + imagenes;
	}

}