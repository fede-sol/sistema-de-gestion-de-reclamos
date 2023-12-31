package com.example.modelo;

import com.example.views.ImagenView;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	@Column(name = "path")
	private String direccion;
	private String tipo;
	@JoinColumn(name = "idreclamo")
	@Column(nullable = true)
	private int idreclamo;

	public Imagen() {
	}

	public Imagen(String direccion, String tipo, int idreclamo) {
		this.direccion = direccion;
		this.tipo = tipo;
		this.idreclamo = idreclamo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ImagenView toView() {
		return new ImagenView(numero, direccion, tipo);
	}
}
