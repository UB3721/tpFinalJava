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
public class Habitacion extends ConexionBD {
    int nroHabitacion;
    int precio;
    int tipoHabitacion;
    Hotel hotel;
    int capacidad;

    public Habitacion() {
    }

    public Habitacion(int nroHabitacion, int precio, int tipoHabitacion, Hotel hotel, int capacidad) {
        this.nroHabitacion = nroHabitacion;
        this.precio = precio;
        this.tipoHabitacion = tipoHabitacion;
        this.hotel = hotel;
        this.capacidad = capacidad;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(int tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Consorcio.Habitaciones (nroHabitacion, precio, tipoHabitacion, idHotel, capacidad) VALUES (?, ?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna parámetros a la sentencia preparada
            cmd.setInt(1, this.nroHabitacion);
            cmd.setInt(2, this.precio);
            cmd.setInt(3, this.tipoHabitacion);
            cmd.setInt(4, this.hotel.idHotel);
            cmd.setInt(5, this.capacidad);


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
 
    public ArrayList<Habitacion> getHabitaciones () {
        ArrayList<Habitacion> habitaciones = new ArrayList();
        Statement cmd = null;
        ResultSet rs;
        String sql;

        try {
            establecerConexion();

            cmd = cn.createStatement();

            sql = "SELECT * FROM Consorcio.Habitaciones";

            rs = cmd.executeQuery(sql);


            Hotel h = new Hotel();
            
            while (rs.next()) {
                habitaciones.add(new Habitacion(rs.getInt("nroHabitacion"),
                                           rs.getInt("precio"),
                                           rs.getInt("tipoHabitacion"),
                                           h.getHoteles().get(rs.getInt("idHotel")),
                                           rs.getInt("capacidad")
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
        return habitaciones;
    }
  
}

