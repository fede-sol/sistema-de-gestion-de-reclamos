package com.example.modelo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.example.views.Estado;
import com.example.views.ImagenView;
import com.example.views.ReclamoView;

@Entity
@Table(name = "reclamos")
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idreclamo")
	private int numero;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "documento")
	private Persona usuario;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo")
	private Edificio edificio;
	private String ubicacion;
	private String descripcion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "identificador")
	private Unidad unidad;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idreclamo")
	private List<Imagen> imagenes;

	public Reclamo() {
	}

	public Reclamo(Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = Estado.nuevo;
		imagenes = new ArrayList<Imagen>();
	}

	public void agregarImagen(Imagen imagen) {
		imagenes.add(imagen);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Persona getUsuario() {
		return usuario;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public Estado getEstado() {
		return estado;
	}

	public List<Imagen> getImagenes() {
		return this.imagenes;
	}

	public void borrarImagenes() {
		this.imagenes = new ArrayList<Imagen>();
	}

	public void cambiarEstado(Estado estado) {
		this.estado = estado;
	}

	public ReclamoView toView() {

		List<ImagenView> imagenes = new ArrayList<ImagenView>();
		for (Imagen imagen : this.imagenes)
			imagenes.add(imagen.toView());

		if(unidad == null)
			return new ReclamoView(numero, usuario.toView(), edificio.toView(), ubicacion,descripcion, null, estado, imagenes);
		else
			return new ReclamoView(numero, usuario.toView(), edificio.toView(), ubicacion,descripcion, unidad.toView(), estado, imagenes);
	}
}