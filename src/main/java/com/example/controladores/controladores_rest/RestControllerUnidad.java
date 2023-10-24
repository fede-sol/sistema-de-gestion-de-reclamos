package com.example.controladores.controladores_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controladores.Controlador;
import com.example.exceptions.UnidadException;
import com.example.views.PersonaView;

@RestController
@RequestMapping("/unidad")
@CrossOrigin
public class RestControllerUnidad {


    @Autowired
	Controlador controlador;


    @GetMapping("/dueños")
	public List<PersonaView> obtenerDueños(){

        try {
            List<PersonaView> lista = controlador.dueniosPorUnidad(1, "1", "1");
            return lista;
        } catch (UnidadException e) {
            throw e;
        }
	}

    @GetMapping("/inquilinos")
    public List<PersonaView> obtenerInquilinos(){

            try {
                List<PersonaView> lista = controlador.inquilinosPorUnidad(1, "1", "1");
                return lista;
            } catch (UnidadException e) {
                throw e;
            }
        }
}
