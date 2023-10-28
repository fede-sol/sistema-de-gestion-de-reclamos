package com.example.controladores.controladores_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controladores.Controlador;
import com.example.exceptions.ReclamoException;
import com.example.exceptions.UnidadException;
import com.example.modelo.Reclamo;
import com.example.modelo.Unidad;
import com.example.views.PersonaView;
import com.example.views.ReclamoView;
import com.example.views.UnidadView;

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

    @PutMapping("/liberar-unidad")
	public UnidadView liberarUnidad(@RequestBody Unidad unidad) {
        try {
            return controlador.liberarUnidad(unidad.getId(), unidad.getPiso(), unidad.getNumero());
        } catch (UnidadException e) {
            throw e;
        }
	}

    @PutMapping("/habitar-unidad")
	public UnidadView habitarUnidad(@RequestBody Unidad unidad) {
        try {
            return controlador.habitarUnidad(unidad.getId(), unidad.getPiso(), unidad.getNumero());
        } catch (UnidadException e) {
            throw e;
        }
	}

    @GetMapping("/reclamos-por-unidad")
	public List<ReclamoView> reclamosPorUnidad(@RequestBody Unidad unidad){
        try {
            return controlador.reclamosPorUnidad(unidad.getId(), unidad.getPiso(), unidad.getNumero());
        } catch (UnidadException e) {
            throw e;
        }
	}


}
