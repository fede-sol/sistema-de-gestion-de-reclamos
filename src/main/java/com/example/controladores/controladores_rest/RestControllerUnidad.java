package com.example.controladores.controladores_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/buscar/{identificador}")
    public UnidadView getUnidad(@PathVariable("identificador") Integer identificador) {
        try {
            UnidadView unidad = controlador.getUnidad(identificador);
            return unidad;
        } catch (UnidadException e) {
            throw e;
        }
    }


    // dueños por unidad
    @GetMapping("/dueños")
	public List<PersonaView> obtenerDueños(@RequestParam int codigo, @RequestParam String piso, @RequestParam String numero){

        try {
            List<PersonaView> lista = controlador.dueniosPorUnidad(codigo, piso, numero);
            return lista;
        } catch (UnidadException e) {
            throw e;
        }
	}

    // inquilinos por unidad
    @GetMapping("/inquilinos")
    public List<PersonaView> obtenerInquilinos(@RequestParam int codigo, @RequestParam String piso, @RequestParam String numero){

        try {
            List<PersonaView> lista = controlador.inquilinosPorUnidad(codigo, piso, numero);
            return lista;
        } catch (UnidadException e) {
            throw e;
        }
    }

    // transferir unidad
    @PutMapping("/transferir")
    public UnidadView transferirUnidad(@RequestParam int codigo, @RequestParam String piso, @RequestParam String numero, @RequestParam String documento){

        try {
            return controlador.transferirUnidad(codigo, piso, numero, documento);
        } catch (UnidadException e) {
            throw e;
        }
    }

    // agregar duenio unidad
    @PutMapping("/agregarDuenio")
    public UnidadView agregarDuenioUnidad(@RequestParam int codigo, @RequestParam String piso, @RequestParam String numero, @RequestParam String documento){

        try {
            return controlador.agregarDuenioUnidad(codigo, piso, numero, documento);
        } catch (UnidadException e) {
            throw e;
        }
    }

    // alquilar unidad
    @PutMapping("/alquilar")
    public UnidadView alquilarUnidad(@RequestParam int codigo, @RequestParam String piso, @RequestParam String numero, @RequestParam String documento){

        try {
            return controlador.alquilarUnidad(codigo, piso, numero, documento);
        } catch (UnidadException e) {
            throw e;
        }
    }

    // agregar inquilino unidad
    @PutMapping("/agregarInquilino")
    public UnidadView agregarInquilinoUnidad(@RequestParam int codigo, @RequestParam String piso, @RequestParam String numero, @RequestParam String documento){

        try {
            return controlador.agregarInquilinoUnidad(codigo, piso, numero, documento);
        } catch (UnidadException e) {
            throw e;
        }
    }

    @PutMapping("/liberar-unidad")
	public UnidadView liberarUnidad(@RequestParam int codigo, @RequestParam String piso, @RequestParam String numero) {
        try {
            return controlador.liberarUnidad(codigo, piso, numero);
        } catch (UnidadException e) {
            throw e;
        }
	}

    @PutMapping("/habitar-unidad")
	public UnidadView habitarUnidad(@RequestParam int codigo, @RequestParam String piso, @RequestParam String numero) {
        try {
            return controlador.habitarUnidad(codigo, piso, numero);
        } catch (UnidadException e) {
            throw e;
        }
	}

    @GetMapping("/reclamos-por-unidad")
	public List<ReclamoView> reclamosPorUnidad(@RequestParam int codigo, @RequestParam String piso, @RequestParam String numero){
        try {
            return controlador.reclamosPorUnidad(codigo, piso, numero);
        } catch (UnidadException e) {
            throw e;
        }
	}


}
