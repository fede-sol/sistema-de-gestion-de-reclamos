package com.example.controladores.controladores_rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.controladores.Controlador;
import com.example.exceptions.EdificioException;
import com.example.exceptions.PersonaException;
import com.example.exceptions.ReclamoException;
import com.example.exceptions.UnidadException;
import com.example.modelo.Reclamo;
import com.example.views.Estado;
import com.example.views.PersonaView;
import com.example.views.ReclamoView;
import com.servicios.ManejadorArchivos;

@RestController
@RequestMapping("/reclamos")
@CrossOrigin
public class RestControllerReclamo {

    @Autowired
	Controlador controlador;

    @Autowired
    ManejadorArchivos manejadorArchivos;


    @GetMapping("/get")
    public List<ReclamoView> getReclamos() {
        try {
            List<ReclamoView> reclamos = controlador.getReclamos();
            return reclamos;
        } catch (ReclamoException e) {
            throw e;
        }
    }

    @GetMapping("/buscar/id/{numero}")
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
            ReclamoView nuevoReclamo = controlador.agregarReclamo(reclamo.getEdificio().getCodigo(), reclamo.getUnidad().getPiso(), reclamo.getUnidad().getNumero(), reclamo.getUsuario().getDocumento(), reclamo.getUbicacion(), reclamo.getDescripcion());
            return nuevoReclamo;
        } catch (EdificioException e) {
            throw e;
        } catch (UnidadException e) {
            throw e;
        } catch (PersonaException e) {
            throw e;
        }
	}


    @GetMapping("/buscar/estado/{estado}")
	public List<ReclamoView> buscarPorEstado(@PathVariable("estado") Estado estado,@RequestParam("documento") String documento) {

        List<ReclamoView> reclamosFiltrados = new ArrayList<ReclamoView>();

        List<ReclamoView> reclamos = controlador.reclamosPorEstado(estado);
        for (ReclamoView reclamoView : reclamos) {
            for (PersonaView persona : controlador.habilitadosPorEdificio(reclamoView.getEdificio().getCodigo())) {
                if(persona.getDocumento().equals(documento)){
                    reclamosFiltrados.add(reclamoView);
                }
            }
        }

        return reclamosFiltrados;

	}


    @PutMapping("/cambiar-estado")
	public ReclamoView cambiarEstado(@RequestParam("numero") Integer numero,@RequestParam("estado") Estado estado,@RequestParam("observacion") String observacion) {
        try {
            ReclamoView reclamoActualizado = controlador.cambiarEstado(numero, estado,observacion);
            return reclamoActualizado;
        } catch (ReclamoException e) {
            throw e;

        }
	}


    @PostMapping("/cargar-imagen")
    public String handleFileUpload(@RequestParam("imagen") MultipartFile file,@RequestParam("idReclamo") Integer id,@RequestParam("documento") String documento) throws IOException {

        ReclamoView reclamo = controlador.reclamoPorNumero(id);
        if(!reclamo.getUsuario().getDocumento().equals(documento))
            throw new ReclamoException("No tiene permisos para agregar imagenes al reclamo.");

        if (!file.isEmpty()) {
            try {
                manejadorArchivos.subirArchivo(file);
                controlador.agregarImagenAReclamo(id, "imagenes/" +file.getOriginalFilename(), manejadorArchivos.obtenerExtension(file));

                return "Imagen agregada exitosamente.";
            } catch (IOException e) {
                throw e;
            }
        } else {
            return "No se encontró la imagen.";
        }
    }





}