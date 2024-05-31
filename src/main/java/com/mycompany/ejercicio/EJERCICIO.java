/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ejercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicole Parra
 */
public class EJERCICIO {

    public static void main(String[] args) throws SQLException{
      String usuario="root";
      String password="";
      String url= "jdbc:mysql://localhost:3307/ejercicio";
      
      Connection conexion;
      Statement statement;
      ResultSet rs;
      
        try {
            conexion= DriverManager.getConnection(url,usuario,password);
            statement=conexion.createStatement();
            rs=statement.executeQuery("SELECT * FROM `usuarios`");
            while (rs.next()) {
            System.out.println(rs.getString("Nombres"));
        }
            statement.execute("INSERT INTO `usuarios` (`id`, `Documento`, `Nombres`) VALUES (NULL, '79876780', 'Diego Parra');");
            System.out.println();
            rs=statement.executeQuery("SELECT * FROM `usuarios`");
            while (rs.next()) {
            System.out.println(rs.getString("Nombres"));
            }
            statement.execute("UPDATE `usuarios` SET `Documento` = '37271091', `Nombres` = 'Marlene Hueso' WHERE `usuarios`.`id` = 3;");
            System.out.println();
            rs=statement.executeQuery("SELECT * FROM `usuarios`");
            while (rs.next()) {
            System.out.println(rs.getString("Nombres"));
            }
            
            statement.execute("DELETE FROM `usuarios` WHERE `usuarios`.`id` = 5;");
            System.out.println();
            rs=statement.executeQuery("SELECT * FROM `usuarios`");
            while (rs.next()) {
            System.out.println(rs.getString("Nombres"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EJERCICIO.class.getName()).log(Level.SEVERE, null, ex);
        } 
      
    }
}
