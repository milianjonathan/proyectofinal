/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AJFVCclases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author gweng
 */
public class AJFVCconexion {
    public static final String URL = "jdbc:mysql://localhost/escuela"+"?useTimezone=true&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "ky9029";
    PreparedStatement ps;
    ResultSet rs;
    public static Connection getConnection() {
        Connection Conexion = null;
        try {
            
            //la siguiente linea depende de la version del que utilice se hace necesario o no, con las versiones actuales 
            //no es necesario por lo que se deja en comentado
             Class.forName("com.mysql.cj.jdbc.Driver");
            Conexion = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (Conexion != null){
                System.out.println( "Conexion Exitosa");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        return Conexion;
    }
    
}
