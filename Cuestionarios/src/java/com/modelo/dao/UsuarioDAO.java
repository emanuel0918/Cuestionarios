package com.modelo.dao;

import com.modelo.conexion.Conexion;
import com.modelo.entidades.Persona;
import com.modelo.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends Conexion {

    private final String SeleccionaUsuario = "Select * from Usuario where idUsuario = ?";

    public Usuario LeeUsuario(String idUsuario) throws SQLException, ClassNotFoundException {
        Usuario usuario = null;
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(SeleccionaUsuario);
        pst.setString(1, idUsuario);
        ResultSet rs = pst.executeQuery();       
        if (rs.next()){
            usuario = new Usuario();
            usuario.setIdUsuario(rs.getString("idUsuario"));
            usuario.setPasswordUsuario(rs.getString("passwordUsuario"));
            usuario.setCategoriaUsuario(rs.getString("categoriaUsuario"));
            PersonaDAO pdao = new PersonaDAO();
            Persona persona = pdao.LeePersona(rs.getInt("idPersona"));
            usuario.setIdPersona(persona);
        }
        Desconectar();
        return usuario;
    }

}
