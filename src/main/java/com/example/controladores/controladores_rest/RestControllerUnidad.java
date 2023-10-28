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


    // dueños por unidad
    @GetMapping("/dueños")
	public List<PersonaView> obtenerDueños(@RequestBody Unidad unidad){

        try {
            List<PersonaView> lista = controlador.dueniosPorUnidad(unidad.getId(),unidad.getPiso(), unidad.getNumero());
            return lista;
        } catch (UnidadException e) {
            throw e;
        }
	}

    // inquilinos por unidad
    @GetMapping("/inquilinos")
    public List<PersonaView> obtenerInquilinos(@RequestBody Unidad unidad){

        try {
            List<PersonaView> lista = controlador.inquilinosPorUnidad(unidad.getId(),unidad.getPiso(), unidad.getNumero());
            return lista;
        } catch (UnidadException e) {
            throw e;
        }
    }

    // transferir unidad
    @GetMapping("/transferir")
    public void transferirUnidad(@RequestBody Unidad unidad, @RequestBody String documento){

        try {
            controlador.transferirUnidad(unidad.getId(),unidad.getPiso(), unidad.getNumero(), documento);
        } catch (UnidadException e) {
            throw e;
        }
    }

    // agregar duenio unidad
    @GetMapping("/agregarDueño")
    public void agregarDueñoUnidad(@RequestBody Unidad unidad, @RequestBody String documento){

        try {
            controlador.agregarDuenioUnidad(unidad.getId(),unidad.getPiso(), unidad.getNumero(), documento);
        } catch (UnidadException e) {
            throw e;
        }
    }

    // alquilar unidad
    @GetMapping("/alquilar")
    public void alquilarUnidad(@RequestBody Unidad unidad, @RequestBody String documento){

        try {
            controlador.alquilarUnidad(unidad.getId(),unidad.getPiso(), unidad.getNumero(), documento);
        } catch (UnidadException e) {
            throw e;
        }
    }

    // agregar inquilino unidad
    @GetMapping("/agregarInquilino")
    public void agregarInquilinoUnidad(@RequestBody Unidad unidad, @RequestBody String documento){

        try {
            controlador.agregarInquilinoUnidad(unidad.getId(),unidad.getPiso(), unidad.getNumero(), documento);
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
