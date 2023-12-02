package com.example.modelo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.modelo.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

    public Optional<Edificio> findByNombre(String nombre);
    public List<Edificio> findAllByUnidadesDueniosDocumentoAndUnidadesInquilinosDocumento(String documento,String documento2);
}
