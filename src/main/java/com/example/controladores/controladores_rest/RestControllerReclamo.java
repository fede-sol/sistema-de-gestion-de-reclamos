package com.example.controladores.controladores_rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractFileResolvingResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.example.controladores.Controlador;
import com.example.exceptions.EdificioException;
import com.example.exceptions.PersonaException;
import com.example.exceptions.ReclamoException;
import com.example.exceptions.UnidadException;
import com.example.modelo.Reclamo;
import com.example.views.Estado;
import com.example.views.ImagenView;
import com.example.views.ReclamoView;
import com.servicios.ImgBBService;
import com.servicios.ManejadorArchivos;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/reclamos")
@CrossOrigin
public class RestControllerReclamo {

    @Autowired
	Controlador controlador;

    @Autowired
    ManejadorArchivos manejadorArchivos;



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
	public List<ReclamoView> buscarPorEstado(@PathVariable("estado") Estado estado) {

		List<ReclamoView> reclamo = controlador.reclamosPorEstado(estado);
        return reclamo;

	}


    @PutMapping("/cambiar-estado")
	public ReclamoView cambiarEstado(@RequestBody Reclamo reclamo) {
        try {
            ReclamoView reclamoActualizado = controlador.cambiarEstado(reclamo.getNumero(), reclamo.getEstado());
            return reclamoActualizado;
        } catch (ReclamoException e) {
            throw e;

        }
	}


    @PostMapping("/cargar-imagen")
    public String handleFileUpload(@RequestParam("imagen") MultipartFile file,@RequestParam("idReclamo") Integer id) throws IOException {
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



    @GetMapping("/imagenes/{nombre}")
    public void serveImageHandler(HttpServletResponse response,@PathVariable("nombre") String nombre) throws Exception {

        try {
            InputStream fileInputStream= new FileInputStream("imagenes/"+nombre);
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream,response.getOutputStream());
        } catch(Exception e) {
            throw e;
        }

    }

}