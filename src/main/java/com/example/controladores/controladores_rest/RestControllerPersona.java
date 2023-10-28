package com.example.controladores.controladores_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controladores.Controlador;
import com.example.exceptions.PersonaException;
import com.example.modelo.Persona;
import com.example.views.PersonaView;
import com.example.views.ReclamoView;

@RestController
@RequestMapping("/personas")
@CrossOrigin
public class RestControllerPersona {


    @Autowired
	Controlador controlador;

    @GetMapping("/buscar-reclamos/{dni}")
	public List<ReclamoView> buscarReclamosPorDni(@PathVariable("dni") String dni ) {
        try {
		    List<ReclamoView> reclamo = controlador.reclamosPorPersona(dni);
            return reclamo;
        } catch (PersonaException e) {
            throw e;
        }
	}

    @PostMapping("/agregar")
	public PersonaView agregarPersona(@RequestBody Persona persona) {
        try {
            PersonaView personaO = controlador.agregarPersona(persona.getDocumento(), persona.getNombre(), persona.getMail(), persona.getPassword());
            return personaO;
        } catch (PersonaException e) {
            throw e;
        }
	}

    @DeleteMapping("/eliminar/{dni}")
    public String eliminarPersona(@PathVariable("dni") String dni ) {
        try {
            return controlador.eliminarPersona(dni);
        } catch (PersonaException e) {   /// las unicas exceptions que tiene son PersonaException
            throw e;
        }
	}
}
