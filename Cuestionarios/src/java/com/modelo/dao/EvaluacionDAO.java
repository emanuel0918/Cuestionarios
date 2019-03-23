package com.modelo.dao;

import com.modelo.conexion.Conexion;
import com.modelo.entidades.Evaluacion;
import com.modelo.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EvaluacionDAO extends Conexion {
    private static final String EvaluacionAlumno = "Insert into Evaluacion calificacionEvaluacion,nombreCuestionario,"
                                                   + "idUsuario values (?,?,?)";
    
    private static final String SeleccionaEvaluaciones = "Select * from Evaluacion e,Usuario u where "
                                                        + "e.idUsuario=u.idUsuario and e.idUsuario=?";
    
    public void RegistraEvaluacion(Evaluacion evaluacion) throws SQLException, ClassNotFoundException{
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(EvaluacionAlumno);
        pst.setInt(1, evaluacion.getCalificacionEvaluacion());
        pst.setString(2, evaluacion.getNombreEvaluacion());
        pst.setString(3, evaluacion.getIdUsuario().getIdUsuario());
        pst.executeUpdate();
        Desconectar();
    }
    
    public List<Evaluacion> LeeEvaluaciones(String idUsuario) throws SQLException, ClassNotFoundException{
        List<Evaluacion> listaEvaluaciones = new ArrayList();
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(SeleccionaEvaluaciones);
        pst.setString(1, idUsuario);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Evaluacion evaluacion = new Evaluacion();
            evaluacion.setIdEvaluacion(rs.getInt("idEvaluacion"));
            evaluacion.setCalificacionEvaluacion(rs.getInt("calificacionEvaluacion"));
            evaluacion.setNombreEvaluacion(rs.getString("nombreCuestionario"));
            UsuarioDAO udao = new UsuarioDAO();
            Usuario usuario = udao.LeeUsuario(rs.getString("idUsuario"));
            evaluacion.setIdUsuario(usuario);
            listaEvaluaciones.add(evaluacion);
        }
        Desconectar();
        return listaEvaluaciones;
    }
}