package com.example.controladores.controladores_rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controladores.Controlador;
import com.example.exceptions.EdificioException;
import com.example.exceptions.PersonaException;
import com.example.exceptions.ReclamoException;
import com.example.exceptions.UnidadException;
import com.example.modelo.Reclamo;
import com.example.views.ReclamoView;

@RestController
@RequestMapping("/reclamos")
@CrossOrigin
public class RestControllerReclamo {

    @Autowired
	Controlador controlador;


    @GetMapping("/buscar/{numero}")
	public ReclamoView buscarPorNumero(@PathVariable("numero") Integer numero) {
        try {
		    ReclamoView reclamo = controlador.reclamoPorNumero(numero);
            return reclamo;
        } catch (ReclamoException e) {
            throw e;
        }
	}


    @PostMapping("/agregar")
	public ReclamoView agregarReclamo(@RequestBody Reclamo reclamo) {
        try {
            ReclamoView nuevoReclamo = controlador.agregarReclamo(reclamo.getEdificio().getCodigo(), reclamo.getUnidad().getId(), reclamo.getUsuario().getDocumento(), reclamo.getUbicacion(), reclamo.getDescripcion());
            return nuevoReclamo;
        } catch (EdificioException e) {
            throw e;
        } catch (UnidadException e) {
            throw e;
        } catch (PersonaException e) {
            throw e;
        }
	}



}
