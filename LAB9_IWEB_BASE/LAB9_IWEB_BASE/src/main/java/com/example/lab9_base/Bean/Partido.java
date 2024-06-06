package com.example.lab9_base.Bean;

public class Partido {
    private int idPartido;
    private String fecha;
    private int numeroJornada;
    private SeleccionNacional seleccionLocal;
    private SeleccionNacional seleccionVisitante;
    private Arbitro arbitro;

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public SeleccionNacional getSeleccionLocal() {
        return seleccionLocal;
    }

    public void setSeleccionLocal(SeleccionNacional seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public SeleccionNacional getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public void setSeleccionVisitante(SeleccionNacional seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }
}
