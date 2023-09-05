package com.example.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
En la anotación @Entity, deberías especificar el nombre de la tabla a la que se mapea la entidad. 
Algo así como @Entity(name = "imagen").

El atributo idReclamo está marcado como @ManyToOne, pero debería ser un tipo de entidad en lugar de 
un int. Deberías tener algo como @ManyToOne(targetEntity = Reclamo.class). 
Además, asegúrate de que la clase Reclamo exista y esté correctamente mapeada.

Faltan los getters y setters para el atributo idReclamo. Deberías agregarlos si planeas acceder a 
ese atributo.

No estás utilizando la anotación @JoinColumn correctamente en la relación @ManyToOne. Deberías 
especificar el nombre de la columna en la tabla Imagen que se utiliza como clave externa hacia 
la tabla Reclamo. Algo así como @JoinColumn(name = "id_reclamo").

Si este es todo el código de la clase Imagen, entonces falta el constructor que inicialice
el atributo idReclamo. Deberías tener un constructor que acepte un parámetro idReclamo.
*/

@Entity
@Table(name="imagenes")
public class Imagen {

	@Id
	private int numero;
	@Column(name="path")
	private String direccion;
	private String tipo;
	private int idReclamo;


	public Imagen(){}

	public Imagen(String direccion, String tipo) {
		this.direccion = direccion;
		this.tipo = tipo;
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
}
