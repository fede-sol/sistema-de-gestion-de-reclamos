package com.example.modelo;

import com.example.views.Estado;
import com.example.views.SeguimientoView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "seguimientos")
public class Seguimiento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseguimiento")
    private int id;
    @JoinColumn(name = "idReclamo")
    private int idreclamo;
    @Enumerated(EnumType.STRING)
    private Estado estadoanterior;
    @Enumerated(EnumType.STRING)
    private Estado estadonuevo;
    private String observacion;


    public Seguimiento() {
	}

    public Seguimiento(int idreclamo, Estado estadoAnterior, Estado estadoNuevo, String observacion) {
        this.idreclamo = idreclamo;
        this.estadoanterior = estadoAnterior;
        this.estadonuevo = estadoNuevo;
        this.observacion = observacion;
    }


    public int getIdreclamo() {
        return idreclamo;
    }

    public void setIdreclamo(int idreclamo) {
        this.idreclamo = idreclamo;
    }

    public Estado getEstadoAnterior() {
        return estadoanterior;
    }

    public void setEstadoAnterior(Estado estadoAnterior) {
        this.estadoanterior = estadoAnterior;
    }

    public Estado getEstadoNuevo() {
        return estadonuevo;
    }

    public void setEstadoNuevo(Estado estadoNuevo) {
        this.estadonuevo = estadoNuevo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    public SeguimientoView toView() {
        return new SeguimientoView(idreclamo, estadoanterior, estadonuevo, observacion);
    }


}
