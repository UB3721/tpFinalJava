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
public class Hotel extends ConexionBD{
    int idHotel;
    int codPostal;
    int tipoHotel;
    String pais;
    String ciudad;

    public Hotel() {
    }

    public Hotel(int idHotel, int codPostal, int tipoHotel, String pais, String ciudad) {
        this.idHotel = idHotel;
        this.codPostal = codPostal;
        this.tipoHotel = tipoHotel;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Consorcio.Hoteles (idHotel, codPostal, tipoHotel, pais, ciudad) VALUES (?, ?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna parámetros a la sentencia preparada
            cmd.setInt(1, this.idHotel);
            cmd.setInt(2, this.codPostal);
            cmd.setInt(3, this.tipoHotel);
            cmd.setString(4, this.pais);
            cmd.setString(5, this.ciudad);

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
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, "NO SE GRABO LA CONSULTA!");
                cn.rollback();
            }
        }
        catch (SQLException e) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, e);
        }
        finally {

            if (cmd != null) {
                try {
                    cmd.close();
                    cmd = null;
                }
                catch (Exception e) {}
            }
            cerrarConexion();
        }
        
        return resp;
    }
 
    public ArrayList<Hotel> getHoteles () {
        ArrayList<Hotel> hoteles = new ArrayList();
        Statement cmd = null;
        ResultSet rs;
        String sql;

        try {
            establecerConexion();

            cmd = cn.createStatement();

            sql = "SELECT * FROM Consorcio.Hoteles";

            rs = cmd.executeQuery(sql);

            while (rs.next()) {
                hoteles.add(new Hotel(rs.getInt("cedula"),
                                           rs.getInt("nombre"),
                                           rs.getInt("apellido"),
                                           rs.getString("fechaNacimiento"),
                                           rs.getString("telefono")

                ));
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
        return hoteles;
    }
   
}
