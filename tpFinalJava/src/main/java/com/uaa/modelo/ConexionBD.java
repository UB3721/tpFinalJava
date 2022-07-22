/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uaa.modelo;

/**
 *
 * @author ub3721
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 *
 */

public class ConexionBD {
    protected Connection cn = null;
    private final String url = "jdbc:mysql://";
    private final String serverName = "localhost";
    private final String portNumber = "3306";
    private final String databaseName = "hoteles";
    private final String userName = "root";
    private final String password = "Sendnukes3721";
    
    //-- Contructor sin Parámetros
    public ConexionBD() {
    }
    
    //-- Devuelve el URL de la Conexión
    private String getConnectionUrl() {
        return url + serverName + ":" + portNumber + "/" + databaseName
        + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    }

  
    public void establecerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.cn = DriverManager.getConnection(getConnectionUrl(), userName, password);
            if (this.cn != null) {
                cn.setAutoCommit(false);    // manejo transaccional
                System.out.println("Conexión OK!");
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            //Logger.getLogger(Contacto.class.getName()).log(Level.SEVERE, null, e);
        }
    } 
    
  
    public void cerrarConexion() {
        try {
            if (cn != null)
                cn.close();
                cn = null;
            }
        catch (SQLException e) {
        }
    } 
    
} // fin clase ConexionBD


