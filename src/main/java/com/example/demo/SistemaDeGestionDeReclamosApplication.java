/* 
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
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
		

		List<Persona> lista = persona.findAll();
		for (Persona persona : lista) {
			System.out.println(persona.getDocumento());
		}

	}

}
*/