package com.modelo.dao;

import com.modelo.conexion.Conexion;
import com.modelo.entidades.Opciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OpcionesDAO extends Conexion {
    private static final String SeleccionaIOpciones = "Select o.nombrePregunta1,o.nombrePregunta2,o.nombrePregunta3,o.nombrePregunta4 "
                                                    + "from pregunta p,opciones o where o.idPregunta=p.idPregunta and p.idPregunta=?";
    
    public Opciones SelecionaOpcion(int idPregunta) throws SQLException, ClassNotFoundException{
        Opciones opciones = null;
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(SeleccionaIOpciones);
        pst.setInt(1, idPregunta);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            opciones = new Opciones();
            opciones.setOpcion1(rs.getString("nombrePregunta1"));
            opciones.setOpcion2(rs.getString("nombrePregunta2"));
            opciones.setOpcion3(rs.getString("nombrePregunta3"));
            opciones.setOpcion4(rs.getString("nombrePregunta4"));
        }    
        Desconectar();
        return opciones;
    }
}
