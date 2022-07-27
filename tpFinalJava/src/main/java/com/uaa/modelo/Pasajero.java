/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uaa.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Pasajero extends Persona {
    int idPasajero;

    public Pasajero() {
    }
    
    public Pasajero(int cedula, String nombre, String apellido, String fechaNacimiento, String telefono, int genero, int edad){
        super(cedula, nombre, apellido, fechaNacimiento, telefono, genero, edad);
    }

    public Pasajero(int idPasajero){
        this.idPasajero=idPasajero;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }
    
    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Consorcio.Pasajeros (idPasajero, cedula, nombre, apellido, fechaNacimiento, telefono, genero, edad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna parámetros a la sentencia preparada
            cmd.setInt(1, this.idPasajero);
            cmd.setInt(2, this.cedula);
            cmd.setString(3, this.nombre);
            cmd.setString(4, this.apellido);
            cmd.setString(5, this.fechaNacimiento);
            cmd.setString(6, this.telefono);
            cmd.setInt(7, this.genero);
            cmd.setInt(8, this.edad);

            //-- Ejecuta la sentencia
            int result = cmd.executeUpdate();
            
            if (result > 0) {
                rs = cmd.getGeneratedKeys();
                if (rs.next())
                    throw new SQLException("No se pudo recuperar la Clave");
                    cn.commit();
                    resp = true;
                }
            else {
                cn.rollback();
            }
        }
        catch (Exception e) {}
        finally {

            if (cmd != null) {
                try {
                    cmd.close();
                    cmd = null;
                }
                catch (SQLException e) {System.err.println("Error de SQL: " + e);}
            }
            cerrarConexion();
        }
        
        return resp;
    }
 
    public ArrayList<Pasajero> getPasajeros () {
        ArrayList<Pasajero> pasajeros = new ArrayList();
        Statement cmd = null;
        ResultSet rs;
        String sql;

        try {
            establecerConexion();

            cmd = cn.createStatement();

            sql = "SELECT * FROM Consorcio.Pasajeros";

            rs = cmd.executeQuery(sql);
            

            while (rs.next()) {
                Pasajero pas = new Pasajero(rs.getInt("cedula"),
                                                    rs.getString("nombre"),
                                                    rs.getString("apellido"),
                                                    rs.getString("fechaNacimiento"),
                                                    rs.getString("telefono"),
                                                    rs.getInt("genero"),
                                                    rs.getInt("edad")
                );
                pas.setIdPasajero(rs.getInt("idPasajero"));
                pasajeros.add(pas);
                
            }
                
            rs.close();
            rs = null;
        }
        catch (SQLException e) {
            System.err.println("Error de SQL: " + e);
        }
        finally {
            if (cmd != null) {
                try {
                    cmd.close();
                    cmd = null;
                }
                catch (SQLException e) {}
            }
            cerrarConexion();
        }
        return pasajeros;
    }
     
}