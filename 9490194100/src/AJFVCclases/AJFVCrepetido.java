/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AJFVCclases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gweng
 */
public class AJFVCrepetido {
    //esta clase se encarga de que no existan claves repetidas
    
    public static int buscar(String clave){
        Connection con = null;
        con = AJFVCconexion.getConnection();
        PreparedStatement ps;
        ResultSet rs ;
        try{
            ps = con.prepareStatement("Select count(clave) from alumno where clave =?;");
            ps.setString(1, clave);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
        }catch(SQLException e){
            Logger.getLogger(AJFVCrepetido.class.getName()).log(Level.SEVERE, null, e);
            return 1;
        }
        
    }
public static int buscar2(String clave){
        Connection con = null;
        con = AJFVCconexion.getConnection();
        PreparedStatement ps;
        ResultSet rs ;
        try{
            ps = con.prepareStatement("Select count(clave) from alumno where clave =?;");
            ps.setString(1, clave);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
        }catch(SQLException e){
            Logger.getLogger(AJFVCrepetido.class.getName()).log(Level.SEVERE, null, e);
            return 1;
        }
        
    }
}


