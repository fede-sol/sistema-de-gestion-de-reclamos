package com.example.controladores.controladores_rest;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class RestImage {

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
