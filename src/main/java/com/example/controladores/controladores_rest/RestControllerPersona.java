package com.example.controladores.controladores_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controladores.Controlador;

@RestController
@RequestMapping("/unidad")
@CrossOrigin
public class RestControllerPersona {


    @Autowired
	Controlador controlador;
}
