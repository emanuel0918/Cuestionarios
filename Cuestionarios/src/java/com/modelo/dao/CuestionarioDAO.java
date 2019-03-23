package com.modelo.dao;

import com.modelo.conexion.Conexion;
import com.modelo.entidades.Cuestionario;
import com.modelo.entidades.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CuestionarioDAO extends Conexion {
    
    private static final String SelectCuestionarioswhereMaterias = "Select c.idCuestionario,c.nombreCuestionario,c.descripcionCuestionario from "
                                                                    + "Cuestionarios c, Materia m where c.idMateria=m.idMateria "
                                                                    + "and m.idMateria = ?";
   
    private static final String SeleccionaCuestuinario = "Select * from Cuestionarios where idCuestionario=?";
    
    
    public Cuestionario SeleccionaCuestionario(int idCuestionario) throws SQLException, ClassNotFoundException{
        Cuestionario cuestionario = null;
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(SeleccionaCuestuinario);
        pst.setInt(1, idCuestionario);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            cuestionario = new Cuestionario();
            cuestionario.setIdCuestionario(rs.getInt("idCuestionario"));
            cuestionario.setNombreCuestionario(rs.getString("nombreCuestionario"));
            cuestionario.setDescripcionCuestionario(rs.getString("descripcionCuestionario"));
            MateriaDAO mdao = new MateriaDAO();
            Materia materia = mdao.SeleccionaMateria(rs.getInt("idMateria"));
            cuestionario.setIdMateria(materia);
        }
        Desconectar();
        return cuestionario;
    }
    
    public List<Cuestionario> SeleccionaCuestionarios(int idMateria) throws SQLException, ClassNotFoundException{
        Conectar();
        List<Cuestionario> listaCuestionarios = new ArrayList();
        PreparedStatement pst = getConexion().prepareStatement(SelectCuestionarioswhereMaterias);
        pst.setInt(1, idMateria);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Cuestionario cuestionario = new Cuestionario();
            cuestionario.setIdCuestionario(rs.getInt("idCuestionario"));
            cuestionario.setNombreCuestionario(rs.getString("nombreCuestionario"));
            cuestionario.setDescripcionCuestionario(rs.getString("descripcionCuestionario"));
            listaCuestionarios.add(cuestionario);
        }
        Desconectar();
        return listaCuestionarios;
    }
}
