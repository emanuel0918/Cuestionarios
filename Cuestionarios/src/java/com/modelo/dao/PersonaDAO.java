package com.modelo.dao;

import com.modelo.conexion.Conexion;
import com.modelo.entidades.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO extends Conexion {
    private final String SeleccionaTodos = "Select * from Persona";
    private final String SeleccionaUno = "Select * from Persona where idPersona = ?";
    
    public PersonaDAO(){
        super();
    }
    
    public Persona LeePersona(int idPersona) throws SQLException, ClassNotFoundException{
        Persona persona = null;
        Conectar();
        PreparedStatement pst = getConexion().prepareStatement(SeleccionaUno);
        pst.setInt(1, idPersona);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            persona = new Persona();
            persona.setIdPersona(rs.getInt("idPersona"));
            persona.setNombre(rs.getString("nombre"));
            persona.setApellidoMaterno(rs.getString("apellidomaterno"));
            persona.setApellidoPaterno(rs.getString("apellidopaterno"));
            persona.setEmail(rs.getString("email"));
            persona.setTelefono(rs.getString("telefono"));
        }
        Desconectar();
        return persona;
    }
    
    
    public List<Persona> LeeTodos() throws SQLException, ClassNotFoundException{
        Conectar();
        List<Persona> personas = new ArrayList();
        PreparedStatement pstm =  getConexion().prepareStatement(SeleccionaTodos);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Persona p = new Persona();
            p.setIdPersona(rs.getInt("idPersona"));
            p.setNombre(rs.getString("nombre"));
            p.setApellidoMaterno(rs.getString("apellidomaterno"));
            p.setApellidoPaterno(rs.getString("apellidopaterno"));
            p.setEmail(rs.getString("email"));
            p.setTelefono(rs.getString("telefono"));
            personas.add(p);
        }
        Desconectar();
        return personas;
    }
}
