package com.example.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import com.example.views.EdificioView;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "edificios")
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private String direccion;

	@OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER)
	private List<Unidad> unidades;

	public Edificio() {
	}

	public Edificio(int codigo, String nombre, String direccion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		unidades = new ArrayList<Unidad>();
	}

	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}

	public Set<Persona> habilitados() {
		Set<Persona> habilitados = new HashSet<Persona>();
		for (Unidad unidad : unidades) {
			List<Persona> duenios = unidad.getDuenios();
			for (Persona p : duenios)
				habilitados.add(p);
			List<Persona> inquilinos = unidad.getInquilinos();
			for (Persona p : inquilinos)
				habilitados.add(p);
		}
		return habilitados;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public Set<Persona> duenios() {
		Set<Persona> resultado = new HashSet<Persona>();
		for (Unidad unidad : unidades) {
			resultado.addAll(unidad.getDuenios());
		}
		return resultado;
	}

	public Set<Persona> habitantes() {
		
		Set<Persona> resultado = new HashSet<Persona>();
		for (Unidad unidad : unidades) {
			if (unidad.estaHabitado()) {
				List<Persona> inquilinos = unidad.getInquilinos();
				if (inquilinos.size() > 0){
					for (Persona p : inquilinos){
						resultado.add(p);
					}
				}else {
					List<Persona> duenios = unidad.getDuenios();  /////// duenios no son necesariamente habitantes
					for (Persona p : duenios)
						resultado.add(p);
				}
			}
		}
		return resultado;
	}

	public EdificioView toView() {
		return new EdificioView(codigo, nombre, direccion);
	}
}