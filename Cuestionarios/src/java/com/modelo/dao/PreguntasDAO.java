package com.modelo.dao;

import com.modelo.conexion.Conexion;
import com.modelo.entidades.Cuestionario;
import com.modelo.entidades.Preguntas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreguntasDAO extends Conexion {
    private static final String PreguntasDeCuestionario = "Select p.idPregunta,p.nombrePregunta,p.nombreRespuesta,p.idCuestionario from Cuestionarios c, Pregunta p "
                                                          + "where p.idCuestionario=c.idCuestionario and c.idCuestionario=?";
    
    public List<Preguntas> SeleccionaPreguntas(int idCuestionario) throws SQLException, ClassNotFoundException{
        List<Preguntas> listaPreguntas = new ArrayList();
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(PreguntasDeCuestionario);
        pst.setInt(1, idCuestionario);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Preguntas pregunta = new Preguntas();
            pregunta.setIdPreguntas(rs.getInt("idPregunta"));
            pregunta.setPregunta(rs.getString("nombrePregunta"));
            pregunta.setRespuesta(rs.getString("nombreRespuesta"));
            CuestionarioDAO cdao = new CuestionarioDAO();
            Cuestionario cuestionario = cdao.SeleccionaCuestionario(rs.getInt("idCuestionario"));
            pregunta.setIdCuestionario(cuestionario);
            listaPreguntas.add(pregunta);
        }
        Desconectar();
        return listaPreguntas;
    }
}
