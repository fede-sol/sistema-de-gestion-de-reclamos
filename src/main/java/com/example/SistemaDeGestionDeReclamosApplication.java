package com.example;

import java.util.List;
//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.example.modelo.Edificio;
import com.example.modelo.Persona;
//import com.example.modelo.Reclamo;
import com.example.views.Estado;
import com.example.views.PersonaView;
import com.example.views.ReclamoView;
import com.example.views.UnidadView;

@SpringBootApplication
public class SistemaDeGestionDeReclamosApplication implements CommandLineRunner {

	@Autowired
	Controlador controlador;

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeGestionDeReclamosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		// Unidades por edificio ------------------------------------------------------------
		List<UnidadView> lista1 = controlador.getUnidadesPorEdificio(1);
		if (!lista1.isEmpty()) {
			for (UnidadView unidad : lista1) {
				System.out.println(unidad.toString());
			}
		} else {
			System.out.println("no hay unidades");
		}
		*/
		/* 
		// Habilitados por edificio ---------------------------------------------------------
		List<PersonaView> lista2 = controlador.habilitadosPorEdificio(1);
		if (!lista2.isEmpty()) {
			for (PersonaView persona : lista2) {
				System.out.println(persona.toString());
			}
		} else {
			System.out.println("no hay personas");
		}
		*/
		/* 
		// dueños por edificio --------------------------------------------------------------  
		List<PersonaView> lista3 = controlador.dueniosPorEdificio(1);
		if (!lista3.isEmpty()) {
			for (PersonaView persona : lista3) {
				System.out.println(persona.toString());
			}
		} else {
			System.out.println("no hay dueños");
		}
		*/
		/* 
		// Habitantes por edificio ----------------------------------------------------------
		List<PersonaView> lista4 = controlador.habitantesPorEdificio(1);
		if (!lista4.isEmpty()) {
			for (PersonaView persona : lista4) {
				System.out.println(persona.toString());
			}
		} else {
			System.out.println("no hay habitantes");
		}
		*/
		/* 
		// dueños por unidad ----------------------------------------------------------------
		List<PersonaView> lista5 = controlador.dueniosPorUnidad(1, "1", "1");
		if (!lista5.isEmpty()) {
			for (PersonaView persona : lista5) {
				System.out.println(persona.toString());
			}
		} else {
			System.out.println("no hay dueños");
		}
		*/
		/* 
		// inquilinos por unidad ------------------------------------------------------------
		List<PersonaView> lista6 = controlador.inquilinosPorUnidad(1, "9", "5");
		if (!lista6.isEmpty()) {
			for (PersonaView persona : lista6) {
				System.out.println(persona.toString());
			}
		} else {
			System.out.println("no hay dueños");
		}
		*/
		/*
		// agregar dueno a unidad -----------------------------------------------------------
		int tam = controlador.dueniosPorUnidad(1, "9", "5").size();
		controlador.agregarDuenioUnidad(1, "9", "5", "DNI30012288");
		int tam2 = controlador.dueniosPorUnidad(1, "9", "5").size();
		System.out.println(tam + " " + tam2);
		if(tam < tam2){
			System.out.println("se cargo el duenio");
		}else{
			System.out.println("no se cargo el duenio");
		}
		*/
		/*
		// agregar persona ------------------------------------------------------------------
		controlador.agregarPersona("99999999", "konstantinos", "konstagmail.com", "contraK");
		Persona lista8 = controlador.buscarPersona("99999999");
		if (lista8 != null) {
			System.out.println("se cargo exitosamente la persona " + lista8.getNombre());
		} else {
			System.out.println("no se cargo la persona");
		}
		*/
		/*
		// alquilar unidad ------------------------------------------------------------------
		controlador.alquilarUnidad(2, "4", "3", "CI 13230978");
		System.out.println("se alquilo la unidad");
		*/
		/* 
		// agregar inquilino a unidad -------------------------------------------------------
		int tam4 = controlador.buscarUnidad(1, "10", "6").getInquilinos().size();
		controlador.agregarInquilinoUnidad(1, "10", "6", "CI 13230978");
		int tam5 = controlador.buscarUnidad(1, "10", "6").getInquilinos().size();
		if(tam4 < tam5){
			System.out.println("se agrego el inquilino");
		}else{
			System.out.println("no se agrego el inquilino");
		}
		*/
		/* 
		// liberar unidad -------------------------------------------------------------------
		controlador.alquilarUnidad(1, "10", "6", "CI 13230978");
		boolean ab = controlador.buscarUnidad(1, "10", "6").estaHabitado();
		controlador.liberarUnidad(1, "10", "6");
		boolean ab1 = controlador.buscarUnidad(1, "10", "6").estaHabitado();
		if(ab){
			if(!ab1){
				System.out.println("se libero la unidad");
			}else{
				System.out.println("no se libero la unidad");
			}
			
		}else{
			System.out.println("la unidad esta libre");
		}
		*/
		/* 
		// habitar unidad -------------------------------------------------------------------
		controlador.liberarUnidad(1, "10", "6");
		boolean ab2 = controlador.buscarUnidad(1, "10", "6").estaHabitado();
		controlador.habitarUnidad(1, "10", "6");
		boolean ab3 = controlador.buscarUnidad(1, "10", "6").estaHabitado();
		if(!ab2){
			if(ab3){
				System.out.println("se habito la unidad");
			}else{
				System.out.println("no se habito la unidad");
			}
			
		}else{
			System.out.println("la unidad ya esta habitada");
		}
		*/
		/* 
		// eliminar persona -----------------------------------------------------------------
		Persona lista9 = controlador.buscarPersona("99999999");
		if (lista9 != null) {
			System.out.println("existe la persona " + lista9.getNombre());
		} else {
			System.out.println("no hay persona con ese nombre");
		}
		controlador.eliminarPersona("99999999");
		System.out.println("se elimino la persona");
		*/
		/* 
		// reclamos por edificio -----------------------------------------------------------
		List<ReclamoView> lista11 = controlador.reclamosPorEdificio(2);
		if (lista11 != null) {
			for (ReclamoView reclamo : lista11) {
				System.out.println(reclamo.toString());
			}
		} else {
			System.out.println("no hay reclamos");
		}
		*/
		/* 
		// reclamos por unidad --------------------------------------------------------------
		List<ReclamoView> lista12 = controlador.reclamosPorUnidad(2, "25", "5"); ///1, "8", "6"
		if (!lista12.isEmpty()) {
			for (ReclamoView reclamo : lista12) {
				System.out.println(reclamo.toString());
			}
		} else {
			System.out.println("no hay reclamos");
		}
		*/
		/* 
		// reclamos por numero --------------------------------------------------------------
		List<ReclamoView> lista13 = controlador.reclamosPorNumero(2);
		if (!lista13.isEmpty()) {
			for (ReclamoView reclamo : lista13) {
				System.out.println(reclamo.toString());
			}
		} else {
			System.out.println("no hay reclamos");
		}
		*/
		
		// agregar reclamo ------------------------------------------------------------------
		Long numero = controlador.reclamoRepository.count();
		controlador.agregarReclamo(1, "2", "1", "222222", "2", "nose es para probar");
		Long numero2 = controlador.reclamoRepository.count();
		if (numero < numero2) {
			System.out.println("se guardo un reclamo");
		} else {
			System.out.println("no hubo cambios en la cantidad de reclamos");
		}
		
		/* 
		// reclamos por estado --------------------------------------------------------------
		System.out.println(controlador.reclamosPorEstado(Estado.abierto));
		
		// reclamosPorPersona----------------------------------------------------------------
		List<ReclamoView> reclamos = controlador.reclamosPorPersona("DNI29988738");
		if (!reclamos.isEmpty()) {
			for (ReclamoView reclamo : reclamos) {
				System.out.println(reclamo.toString());
			}
		} else {
			System.out.println("no hay reclamos");
		}
		
		// eliminar persona -----------------------------------------------------------------
		Persona lista14 = controlador.buscarPersona("DNI30108780");
		if (lista14 != null) {
			System.out.println("existe la persona " + lista14.getNombre());
		} else {
			System.out.println("no hay persona con ese nombre");
		}
		controlador.eliminarPersona("DNI30108780");
		
		// reclamos por edificio ------------------------------------------------------------
		List<ReclamoView> lista15 = controlador.reclamosPorEdificio(2);
		if (lista15 != null) {
			for (ReclamoView reclamo : lista15) {
				System.out.println(reclamo.toString());
			}
		} else {
			System.out.println("no hay reclamos");
		}
		
		// reclamos por unidad --------------------------------------------------------------		
		List<ReclamoView> lista16 = controlador.reclamosPorUnidad(1, "10", "6");
		if (lista16 != null) {
			System.out.println(lista16.size());
		} else {
			System.out.println("no hay reclamos");
		}
		
		// reclamos por numero --------------------------------------------------------------
		List<ReclamoView> lista = controlador.reclamosPorNumero(2);
		if (lista != null) {
			for (ReclamoView reclamo : lista) {
				System.out.println(reclamo.toString());
			}
		} else {
			System.out.println("no hay reclamos");
		}
		
		// agregar reclamo ------------------------------------------------------------------
		Long num = controlador.reclamoRepository.count();
		controlador.agregarReclamo(1, "10", "1", "CI 13230978", "2", "nose es para probar1");
		Long num2 = controlador.reclamoRepository.count();
		if (num < num2) {
			System.out.println("se guardo un reclamo");
		} else {
			System.out.println("no hubo cambios en la cantidad de reclamos");
		}
		
		// reclamos por estado --------------------------------------------------------------
		System.out.println(controlador.reclamosPorEstado(Estado.nuevo));
		
		// agregarImagenAReclamo-------------------------------------------------------------
		controlador.agregarImagenAReclamo(1, "i.imgur.com/NyBxg4H.jpeg", "jpeg");
		
		// cambiarEstado---------------------------------------------------------------------
		controlador.cambiarEstado(1, Estado.enProceso);
		
		*/

	}
	////// ver el comentario de edificio.java
	////// buscar unidad es por sus caracteristicas pero buscar edificio es por codigo ??
	////// sacar a algun duenio de la base de datos para poder borrar personas
	////// reclamos por unidada ######################################
	////// puse en public el buscar unidad
}