package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.servicios")
@ComponentScan("com.controladores")
@SpringBootApplication
public class SistemaDeGestionDeReclamosApplication {


	public static void main(String[] args) {
		SpringApplication.run(SistemaDeGestionDeReclamosApplication.class, args);
	}
}