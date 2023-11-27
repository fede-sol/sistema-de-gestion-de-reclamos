package com.example.views;

public class SeguimientoView {

    private int idreclamo;
    private Estado estadoAnterior;
    private Estado estadoNuevo;
    private String observacion;

    public SeguimientoView() {
    }

    public SeguimientoView(int idreclamo, Estado estadoAnterior, Estado estadoNuevo, String observacion) {
        this.idreclamo = idreclamo;
        this.estadoAnterior = estadoAnterior;
        this.estadoNuevo = estadoNuevo;
        this.observacion = observacion;
    }

    public int getIdreclamo() {
        return idreclamo;
    }


    public Estado getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(Estado estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public Estado getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(Estado estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public String getObservacion() {
        return observacion;
    }
}
