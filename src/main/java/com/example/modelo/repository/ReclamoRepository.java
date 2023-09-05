package com.example.modelo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Reclamo;


public interface ReclamoRepository extends JpaRepository<Reclamo, Integer>{

    public Optional<Reclamo> findByNumero(int numero);
}

