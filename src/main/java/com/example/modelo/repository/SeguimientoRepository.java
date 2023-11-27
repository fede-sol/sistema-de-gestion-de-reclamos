package com.example.modelo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Seguimiento;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Integer> {
    public List<Seguimiento> findAllByIdreclamo(int idreclamo);
}
