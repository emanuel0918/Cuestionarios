package com.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conexion;
    
    public Conexion(){
        
    }
    
    public void Conectar() throws SQLException, ClassNotFoundException{
       String url = "jdbc:mysql://localhost:3306/cuestionarios"; 
       String mySQLDriver = "com.mysql.jdbc.Driver";
       String user = "root";
       String password = "root";
       Class.forName(mySQLDriver);
       conexion = DriverManager.getConnection(url,user,password);
       System.out.println("Conexion exitosa");
    }
    
    public void Desconectar() throws SQLException{
        if(conexion != null){
            conexion.close();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
}
