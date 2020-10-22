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
public class AJFVCingresardatos {

    public static void ingresarpago(String clave, String nombre, String telefono, String direccion, String fecha, String email, 
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

                ps = con.prepareStatement("INSERT INTO  alumno (clave,nombre,teléfono, dirección, email, "
                        + "fecha_de_nacimiento, genero,cuotas_pagadas , cuotas_pendientes , total , mora) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
                ps.setString(1, clave);
                ps.setString(2, nombre);
                ps.setString(3, telefono);
                ps.setString(4, direccion);
                ps.setString(5, email);
                ps.setString(6, fecha);
                ps.setString(7, genero);
                ps.setString(8, pagado);
                ps.setString(9, String.valueOf(faltas));
                ps.setString(10, String.valueOf(total));
                ps.setString(11, mora);
                
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
 
}

    
