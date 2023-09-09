package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.modelo.Edificio;
import com.example.modelo.Persona;
import com.example.views.PersonaView;
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
		 // Unidades por edificio
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
		 // Habilitados por edificio
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
		 // dueños por edificio
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
		
		// Habitantes por edificio
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
			// dueños por unidad
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
			// inquilinos por unidad
			List<PersonaView> lista = controlador.inquilinosPorUnidad(1,9,5);
			if (lista != null){
				for (PersonaView persona : lista) {
					System.out.println(persona.toString());
				   }
			   }else{
				   System.out.println("no hay dueños");
			   }
			   
			*/



	}

}
