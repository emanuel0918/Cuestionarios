package com.modelo.entidades;

public class Formato {

    private int idFormato;
    private Cuestionario idCuestionario;
    private Preguntas idPreguntas;

    public Formato() {
    }

    public int getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(int idFormato) {
        this.idFormato = idFormato;
    }

    public Cuestionario getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Cuestionario idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Preguntas getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(Preguntas idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

}
