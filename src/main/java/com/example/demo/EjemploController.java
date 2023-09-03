package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class EjemploController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired 
    public EjemploController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> realizarConsulta() {
        String consulta = "SELECT * FROM edificios";
        List<Map<String, Object>> resultados = jdbcTemplate.queryForList(consulta);

        // Maneja los resultados como necesites
        for (Map<String, Object> fila : resultados) {
            // Procesa cada fila
            System.out.println("Código: " + fila.get("codigo") +
                               ", Nombre: " + fila.get("nombre") +
                               ", Dirección: " + fila.get("direccion"));
        }

        return resultados;
    }
}


