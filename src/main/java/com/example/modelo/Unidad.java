package com.example.modelo;


import java.util.ArrayList;
import java.util.List;

import com.example.exceptions.UnidadException;
import com.example.views.EdificioView;
import com.example.views.UnidadView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="unidades")
public class Unidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="identificador")
	private int id;
	private String piso;
	private String numero;
	private char habitado;
	@ManyToOne
	@JoinColumn(name="codigoedificio")
	private Edificio edificio;
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "duenios",
		joinColumns = @JoinColumn( name="identificador"),
        inverseJoinColumns = @JoinColumn(name = "documento")
    )
    private List<Persona> duenios;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "inquilinos",
		joinColumns = @JoinColumn( name="identificador"),
        inverseJoinColumns = @JoinColumn(name = "documento")
    )
    private List<Persona> inquilinos;

	public Unidad(){

	}

	public Unidad(int id, String piso, String numero, Edificio edificio) {
		this.id = id;
		this.piso = piso;
		this.numero = numero;
		this.habitado = 'N';
		this.edificio = edificio;
		this.duenios = new ArrayList<Persona>();
		this.inquilinos = new ArrayList<Persona>();
	}

	public void transferir(Persona nuevoDuenio) {
		duenios = new ArrayList<Persona>();
		duenios.add(nuevoDuenio);
	}

	public void agregarDuenio(Persona duenio) {
		duenios.add(duenio);
	}

	public void alquilar(Persona inquilino) throws UnidadException {
		if(!this.estaHabitado()) {
			this.habitado = 'S';
			inquilinos = new ArrayList<Persona>();
			inquilinos.add(inquilino);
		}
		else
			throw new UnidadException("La unidad esta ocupada");
	}

	public void agregarInquilino(Persona inquilino) {
		inquilinos.add(inquilino);
	}

	public boolean estaHabitado() {
		return habitado == 'S' ;
	}

	public void liberar() {
		this.inquilinos = new ArrayList<Persona>();
		this.habitado = 'N';
	}

	public void habitar() throws UnidadException {
		if(this.estaHabitado())
			throw new UnidadException("La unidad ya esta habitada");
		else
			this.habitado = 'S';
	}

	public int getId() {
		return id;
	}

	public String getPiso() {
		return piso;
	}

	public String getNumero() {
		return numero;
	}


	public Edificio getEdificio() {
		return edificio;
	}

	public List<Persona> getDuenios() {
		return duenios;
	}

	public List<Persona> getInquilinos() {
		return inquilinos;
	}

	public UnidadView toView() {
		EdificioView auxEdificio = edificio.toView();
		return new UnidadView(id, piso, numero, estaHabitado(), auxEdificio);
	}
}
