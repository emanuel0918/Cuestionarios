package com.modelo.entidades;

public class Usuario {

    private String idUsuario;
    private String passwordUsuario;
    private String categoriaUsuario;
    private Persona idPersona;

    public Usuario() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public String getCategoriaUsuario() {
        return categoriaUsuario;
    }

    public void setCategoriaUsuario(String categoriaUsuario) {
        this.categoriaUsuario = categoriaUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", passwordUsuario=" + passwordUsuario + ", categoriaUsuario=" + categoriaUsuario + ", idPersona=" + idPersona + '}';
    }
    

}
