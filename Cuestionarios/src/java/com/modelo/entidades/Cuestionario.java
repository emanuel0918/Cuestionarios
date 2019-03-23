package com.modelo.entidades;

public class Cuestionario {

    private int idCuestionario;
    private String nombreCuestionario;
    private String descripcionCuestionario;
    private Materia idMateria;

    public Cuestionario() {
    }

    public int getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public String getNombreCuestionario() {
        return nombreCuestionario;
    }

    public void setNombreCuestionario(String nombreCuestionario) {
        this.nombreCuestionario = nombreCuestionario;
    }

    public String getDescripcionCuestionario() {
        return descripcionCuestionario;
    }

    public void setDescripcionCuestionario(String descripcionCuestionario) {
        this.descripcionCuestionario = descripcionCuestionario;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

}
