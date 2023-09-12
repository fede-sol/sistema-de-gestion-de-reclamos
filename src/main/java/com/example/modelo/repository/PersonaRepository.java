package com.example.modelo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {

    public Optional<Persona> findByNombre(String nombre);
}
