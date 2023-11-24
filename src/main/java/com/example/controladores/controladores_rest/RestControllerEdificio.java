package com.example.controladores.controladores_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controladores.Controlador;
import com.example.exceptions.EdificioException;
import com.example.views.EdificioView;
import com.example.views.PersonaView;
import com.example.views.ReclamoView;
import com.example.views.UnidadView;

@RestController
@RequestMapping("/edificio")
@CrossOrigin
public class RestControllerEdificio {

    @Autowired
    Controlador controlador;

    @GetMapping("/get")
    public List<EdificioView> obtenerEdificios() {
        try {
            List<EdificioView> edificios = controlador.getEdificios();
            return edificios;
        } catch (EdificioException e) {
            throw e;
        }
    }

    @GetMapping("/unidades/{codigo}")
    public List<UnidadView> obtenerUnidades(@PathVariable("codigo") Integer codigo) {
        try {
            List<UnidadView> unidades = controlador.getUnidadesPorEdificio(codigo);
            return unidades;
        } catch (EdificioException e) {
            throw e;
        }
    }

    @GetMapping("/habilitados/{codigo}")
    public List<PersonaView> obtenerHabilitados(@PathVariable("codigo") Integer codigo) {

        try {
            List<PersonaView> habilitados = controlador.habilitadosPorEdificio(codigo);
            return habilitados;
        } catch (EdificioException e) {
            throw e;
        }
    }

    @GetMapping("/duenios/{codigo}")
    public List<PersonaView> obtenerDuenios(@PathVariable("codigo") Integer codigo) {

        try {
            List<PersonaView> duenios = controlador.dueniosPorEdificio(codigo);
            return duenios;
        } catch (EdificioException e) {
            throw e;
        }
    }

    @GetMapping("/habitantes/{codigo}")
    public List<PersonaView> obtenerHabitantes(@PathVariable("codigo") Integer codigo) {
        try {
            List<PersonaView> habitantes = controlador.habitantesPorEdificio(codigo);
            return habitantes;

        } catch (EdificioException e) {
            throw e;
        }
    }

    @GetMapping("/reclamos/{codigo}")
    public List<ReclamoView> obtenerReclamos(@PathVariable("codigo") Integer codigo) {
        try {
            List<ReclamoView> reclamos = controlador.reclamosPorEdificio(codigo);
            return reclamos;
        } catch (EdificioException e) {
            throw e;
        }
    }

}
