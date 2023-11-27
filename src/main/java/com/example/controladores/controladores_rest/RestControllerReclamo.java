package com.example.controladores.controladores_rest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
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
import jakarta.servlet.http.HttpServletResponse;

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
	public ReclamoView buscarPorNumero(@PathVariable("numero") Integer numero,@RequestParam("documento") String documento) {
        try {

            ReclamoView reclamo = controlador.reclamoPorNumero(numero);
            for (PersonaView persona : controlador.habilitadosPorEdificio(reclamo.getEdificio().getCodigo())) {
                if(persona.getDocumento().equals(documento)){
                    return reclamo;
                }
            }
            throw new PersonaException("No tiene permisos para ver este reclamo.");


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
	public ReclamoView cambiarEstado(@RequestParam("numero") Integer numero,@RequestParam("estado") Estado estado,@RequestParam("documento") String documento,@RequestParam("observacion") String observacion) {
        try {

            //check si la persona que quiere cambiar el estado es la misma que creo el reclamo
            ReclamoView reclamo = controlador.reclamoPorNumero(numero);
            if(!reclamo.getUsuario().getDocumento().equals(documento))
                throw new ReclamoException("No tiene permisos para cambiar el estado de este reclamo.");

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