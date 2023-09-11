package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.modelo.Edificio;
import com.example.modelo.Persona;
import com.example.modelo.Reclamo;
import com.example.views.Estado;
import com.example.views.PersonaView;
import com.example.views.ReclamoView;
import com.example.views.UnidadView;


@SpringBootApplication
public class SistemaDeGestionDeReclamosApplication implements CommandLineRunner{

	@Autowired
	Controlador controlador;


	public static void main(String[] args) {
		SpringApplication.run(SistemaDeGestionDeReclamosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		 /*

		 // Unidades por edificio -------------------------------------------------------
		 List<UnidadView> lista = controlador.getUnidadesPorEdificio(1);
		 if (lista != null){
			 for (UnidadView unidad : lista) {
				 System.out.println(unidad.toString());
				}
			}else{
				System.out.println("no hay unidades");
			}

		*/
		/*

		 // Habilitados por edificio -------------------------------------------------------
		 List<PersonaView> lista = controlador.habilitadosPorEdificio(1);
		 if (lista != null){
			 for (PersonaView persona : lista) {
				 System.out.println(persona.toString());
				}
			}else{
				System.out.println("no hay personas");
			}

		*/
		/*

		// dueños por edificio -------------------------------------------------------
		List<PersonaView> lista = controlador.dueniosPorEdificio(1);
		if (lista != null){
			for (PersonaView persona : lista) {
				System.out.println(persona.toString());
			}
		}else{
			System.out.println("no hay dueños");
		}

		*/
		/*

		// Habitantes por edificio -------------------------------------------------------
		List<PersonaView> lista = controlador.habitantesPorEdificio(1);
		 if (lista != null){
			 for (PersonaView persona : lista) {
				 System.out.println(persona.toString());
				}
			}else{
				System.out.println("no hay habitantes");
			}

		*/
		/*

		// dueños por unidad -------------------------------------------------------
		List<PersonaView> lista = controlador.dueniosPorUnidad(1,1,1);
		if (lista != null){
			for (PersonaView persona : lista) {
				System.out.println(persona.toString());
				}
			}else{
				System.out.println("no hay dueños");
			}

		*/
		/*

		// inquilinos por unidad -------------------------------------------------------
		List<PersonaView> lista = controlador.inquilinosPorUnidad(1,9,5);
		if (lista != null){
			for (PersonaView persona : lista) {
				System.out.println(persona.toString());
				}
			}else{
				System.out.println("no hay dueños");
			}

		*/
		/*

		// transferir unidad (dueno) -------------------------------------------------------
		controlador.transferirUnidad(1, "10", "6", "CI 13230978");

		*/
		/*

		// agregar dueno a unidad -------------------------------------------------------
		controlador.agregarDuenioUnidad(1, "10", "6", "CI 13230978");

		*/
		//##############################################
		/* 
		// agregar persona ---------------------------------------------------
		Persona lista = controlador.getPersona("konstantinos");

		if (lista != null){
			System.out.println(lista.getNombre());
		}else{
			System.out.println("no hay persona con ese nombre");
		}

		controlador.agregarPersona("99999999", "konstantinos", "konstagmail.com", "contraK");

		Persona lista2 = controlador.getPersona("konstantinos");

		if (lista2 != null){
			System.out.println("se cargo exitosamente la persona " + lista2.getNombre());
		}else{
			System.out.println("no se cargo la persona");
		}
		*/
		/* 
		// eliminar persona ---------------------------------------------------
		Persona lista = controlador.getPersona("konstantinos");

		if (lista != null){
			System.out.println("existe la persona " + lista.getNombre());
		}else{
			System.out.println("no hay persona con ese nombre");
		}

		controlador.eliminarPersona("99999999");

		Persona lista2 = controlador.getPersona("konstantinos");

		if (lista2 != null){
			System.out.println("no se elimino la persona " + lista2.getNombre());
		}else{
			System.out.println("se elimino exitosamente la persona");
		}
		*/
		/* 
		// reclamos por edificio -------------------------------------------------------
		List<ReclamoView> lista = controlador.reclamosPorEdificio(2);
		if (lista != null){
			for (ReclamoView reclamo : lista) {
				System.out.println(reclamo.toString());
				}
		}else{
			System.out.println("no hay reclamos");
		}
		*/
		/* 
		// reclamos por unidad -------------------------------------------------------
		List<ReclamoView> lista = controlador.reclamosPorUnidad(2, "2", "2");
		if (lista != null){
			for (ReclamoView reclamo : lista) {
				System.out.println(reclamo.toString());
				}
		}else{
			System.out.println("no hay reclamos");
		}
		*/
		/* 
		// reclamos por numero -------------------------------------------------------
		List<ReclamoView> lista = controlador.reclamosPorNumero(2);
		if (lista != null){
			for (ReclamoView reclamo : lista) {
				System.out.println(reclamo.toString());
				}
		}else{
			System.out.println("no hay reclamos");
		}
		*/
		/* 
		// agregar reclamo -------------------------------------------------------
		Long num = controlador.reclamoRepository.count();
		controlador.agregarReclamo(2, "2", "2", "222222", "2", "nose es para probar");
		Long num2 = controlador.reclamoRepository.count();

		if(num < num2){
			System.out.println("se guardo un reclamo");
		}else{
			System.out.println("no hubo cambios en la cantidad de reclamos");
		}
		*/
		/* 
		// reclamos por estado -------------------------------------------------------
		System.out.println(controlador. reclamosPorEstado(Estado.abierto));
		*/
		



	}

}

// ANOTACIONES
/*
 tenemos metodos para buscar personas por el nombre "getPersona" y por el documento "buscarPersona"
 estos metodos deverian seguir la misma comvencion y denotar bajo que criterio se realiza la busqueda
 buscarPersona es private y getPersona no, no deverian ser las dos public?

 reclamos por unidad, deveria tomar como parametro la misma unidad, actualmente esta tomando su edificio, piso y numero

 public Persona getPersona(String nombre) en controlador, no habria q pasar esto al repository?
 */