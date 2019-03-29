package com.modelo.dao;

import com.modelo.conexion.Conexion;
import com.modelo.entidades.Opciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OpcionesDAO extends Conexion {
    private static final String SeleccionaIOpciones = "Select o.opcion1,o.opcion2,o.opcion3,o.opcion4 "
                                                    + "from pregunta p,opciones o where o.idPregunta=p.idPregunta and p.idPregunta=?";
    
    public Opciones SelecionaOpcion(int idPregunta) throws SQLException, ClassNotFoundException{
        Opciones opciones = null;
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(SeleccionaIOpciones);
        pst.setInt(1, idPregunta);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            opciones = new Opciones();
            opciones.setOpcion1(rs.getString("opcion1"));
            opciones.setOpcion2(rs.getString("opcion2"));
            opciones.setOpcion3(rs.getString("opcion3"));
            opciones.setOpcion4(rs.getString("opcion4"));
        }    
        Desconectar();
        return opciones;
    }
}
