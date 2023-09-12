package com.example.modelo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Imagen;


public interface ImagenRepository extends JpaRepository<Imagen, Integer>{

    public Optional<Imagen> findByNumero(int numero);
    public List<Imagen> findByidreclamo(int idreclamo);
}
