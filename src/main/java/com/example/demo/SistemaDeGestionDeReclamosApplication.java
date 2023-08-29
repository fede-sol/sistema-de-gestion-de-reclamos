package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SistemaDeGestionDeReclamosApplication {


	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SistemaDeGestionDeReclamosApplication.class, args);
		
		EjemploController ejemploController = context.getBean(EjemploController.class);
        ejemploController.realizarConsulta();

		context.close();
		

	}

}
