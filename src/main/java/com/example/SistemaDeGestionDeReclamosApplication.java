package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Optional;

import com.example.modelo.repository.PersonaRepository;
import com.example.modelo.Persona;


@SpringBootApplication
public class SistemaDeGestionDeReclamosApplication implements CommandLineRunner{


	@Autowired
	PersonaRepository persona;

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeGestionDeReclamosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Optional<Persona> lista = persona.findByNombre("");
		
		

		if(lista.isPresent()){
			System.out.println("Nombre "+lista.get().getNombre());
			System.out.println(lista.get().getDocumento());
			System.out.println(lista.get().getMail());
		}
			

	}

}
