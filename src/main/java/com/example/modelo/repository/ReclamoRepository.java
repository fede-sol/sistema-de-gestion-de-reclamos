package com.example.modelo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Reclamo;
import com.example.views.Estado;


public interface ReclamoRepository extends JpaRepository<Reclamo, Integer>{

    public Optional<Reclamo> findByNumero(int numero);

    public List<Reclamo> findAllByEstado(Estado estado);

    // find by persona
    public List<Reclamo> findAllByUsuario_Documento(String documento);
}

