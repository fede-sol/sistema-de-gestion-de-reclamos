package com.servicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ManejadorArchivos {


    public void subirArchivo(MultipartFile file) throws IllegalStateException, IOException{
        Path currRelativePath = Paths.get("");
        String currAbsolutePathString = currRelativePath.toAbsolutePath().toString();
        String filename = file.getOriginalFilename();
        File dest = new File(currAbsolutePathString+"/imagenes/" +filename);
        file.transferTo(dest);

    }


    public String obtenerExtension(MultipartFile archivo) {
        String nombreArchivo = archivo.getOriginalFilename();
        int lastIndex = nombreArchivo.lastIndexOf('.');
        if (lastIndex >= 0) {
            return nombreArchivo.substring(lastIndex + 1);
        } else {
            return ""; // No se encontró una extensión.
        }
    }

}
