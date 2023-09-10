package com.example.modelo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Unidad;
import com.example.modelo.Persona;



public interface UnidadRepository extends JpaRepository<Unidad, Integer>{

    public List<Unidad> findAllByDueniosDocumento(String documento);

    // find unidad por (int codigo, String piso, String numero)
    public Optional<Unidad> findByEdificioCodigoAndPisoAndNumero(int codigo, String piso, String numero);

}
