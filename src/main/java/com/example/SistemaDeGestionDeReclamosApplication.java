package com.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.modelo.Persona;


@SpringBootApplication
public class SistemaDeGestionDeReclamosApplication implements CommandLineRunner{

	@Autowired
	Controlador controlador;


	public static void main(String[] args) {
		SpringApplication.run(SistemaDeGestionDeReclamosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		controlador.prueba();



	}

}
