package com.example.controladores.controladores_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controladores.Controlador;
import com.example.exceptions.EdificioException;
import com.example.views.PersonaView;
import com.example.views.ReclamoView;
import com.example.views.UnidadView;

@RestController
@RequestMapping("/edificio")
@CrossOrigin
public class RestControllerEdificio {

    @Autowired
    Controlador controlador;

    @GetMapping("/unidades")
    public List<UnidadView> obtenerUnidades() {

        try {
            List<UnidadView> unidades = controlador.getUnidadesPorEdificio(1);
            return unidades;
        } catch (EdificioException e) {
            throw e;
        }
    }

    @GetMapping("/habilitados")
    public List<PersonaView> obtenerHabilitados() {

        try {
            List<PersonaView> habilitados = controlador.habilitadosPorEdificio(1);
            return habilitados;
        } catch (EdificioException e) {
            throw e;
        }
    }

    @GetMapping("/duenios")
    public List<PersonaView> obtenerDuenios() {

        try {
            List<PersonaView> duenios = controlador.dueniosPorEdificio(1);
            return duenios;
        } catch (EdificioException e) {
            throw e;
        }
    }

    @GetMapping("/habitantes")
    public List<PersonaView> obtenerHabitantes() {
        try {
            List<PersonaView> habitantes = controlador.habitantesPorEdificio(1);
            return habitantes;

        } catch (EdificioException e) {
            throw e;
        }
    }

    @GetMapping("/reclamos")
    public List<ReclamoView> obtenerReclamos() {
        try {
            List<ReclamoView> reclamos = controlador.reclamosPorEdificio(1);
            return reclamos;
        } catch (EdificioException e) {
            throw e;
        }
    }

}
