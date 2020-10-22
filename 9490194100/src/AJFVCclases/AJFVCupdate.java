/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AJFVCclases;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gweng
 */
public class AJFVCupdate {
    public static void actualizar(String clave, String nombre, String telefono, String direccion, String fecha, String email, 
            String genero, String pagado, String mora) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = null;
        double total = 0;
        int pagos = Integer.parseInt(pagado);
        if(mora.equals("SI")){
            total = (pagos * 3500)+(pagos*35);
        }else{
            total = (pagos * 3500);
        }
        int faltas =10 - pagos;
        
        
        
        
        
        try {
            con = AJFVCconexion.getConnection();
            int rep = AJFVCrepetido.buscar(clave);

            if (rep == 0) {

                ps = con.prepareStatement("UPDATE alumno SET nombre =?,teléfono =?, dirección =?, email =?, "
                        + "fecha_de_nacimiento =?, genero =?,cuotas_pagadas  =?, cuotas_pendientes  =?, total  =?, mora =?  WHERE  clave=?;");
                ps.setString(11, clave);
                ps.setString(1, nombre);
                ps.setString(2, telefono);
                ps.setString(3, direccion);
                ps.setString(4, email);
                ps.setString(5, fecha);
                ps.setString(6, genero);
                ps.setString(7, pagado);
                ps.setString(8, String.valueOf(faltas));
                ps.setString(9, String.valueOf(total));
                ps.setString(10, mora);
                
                int Resultado = ps.executeUpdate();
                con.close();
                if (Resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Registro no se guardo");
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Clave de alumno ya existe");
            } con.close();
        } catch (HeadlessException | SQLException e) {
        }

    

    }
public static void borrar(String clave) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = null;
        try {
            con = AJFVCconexion.getConnection();
            

                ps = con.prepareStatement("DELETE  FROM alumno WHERE clave =?;");
                ps.setString(1, clave);
                
                int Resultado = ps.executeUpdate();
                if (Resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Registro borrado con Exito");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Registro no se guardo");
                    
                }
            
        } catch (HeadlessException | SQLException e) {
        }

    }
}
