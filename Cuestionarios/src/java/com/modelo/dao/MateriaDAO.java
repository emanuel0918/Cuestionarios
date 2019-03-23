package com.modelo.dao;

import com.modelo.conexion.Conexion;
import com.modelo.entidades.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO extends Conexion {
    private final String SeleccionaTodas = "Select * from Materia";
    private final String SeleccionaMateria = "Select * from Materia where idMateria=?";
    
    public Materia SeleccionaMateria(int idMateria) throws SQLException, ClassNotFoundException{
        Materia materia = null;
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(SeleccionaMateria);
        pst.setInt(1, idMateria);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            materia = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombreMateria(rs.getString("nombreMateria"));
        }
        Desconectar();
        return materia;
    }
    
    public List<Materia> LeeTodas() throws SQLException, ClassNotFoundException{
        List<Materia> listaMaterias = new ArrayList();
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(SeleccionaTodas);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Materia materia = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombreMateria(rs.getString("nombreMateria"));
            listaMaterias.add(materia);
        }
        Desconectar();
        return listaMaterias;
    }
}
