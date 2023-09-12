package com.example.modelo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.modelo.Edificio;
import com.example.modelo.Reclamo;
import com.example.modelo.Unidad;
import com.example.views.Estado;


public interface ReclamoRepository extends JpaRepository<Reclamo, Integer>{

    public List<Reclamo> findByNumero(int numero);

    public List<Reclamo> findAllByEstado(Estado estado);


 
    public List<Reclamo> findByEdificio(Edificio codigo); ///// no lo uso(santiago)
    public List<Reclamo> findByEdificio_Codigo(int codigo);

    public List<Reclamo> findByUnidad(Unidad identificador);///// no lo uso(santiago)
    public List<Reclamo> findByUnidad_Id(int identificador);
    

    // find by persona
    public List<Reclamo> findAllByUsuario_Documento(String documento);

}

