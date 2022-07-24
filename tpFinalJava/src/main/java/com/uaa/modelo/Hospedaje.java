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
    public class Hospedaje extends ConexionBD{
        int nroHospedaje;
        Funcionario funcionario;
        Pasajero pasajero;
        Habitacion habitacion;
        Hotel hotel;
        Lavanderia lavanderia;
        String fechaInicio;
        String fechaFin;
        int precio;
        int estado;

    public Hospedaje(int nroHospedaje, Funcionario funcionario, Pasajero pasajero, Habitacion habitacion, Hotel hotel, Lavanderia lavanderia, String fechaInicio, String fechaFin, int precio, int estado) {
        this.nroHospedaje = nroHospedaje;
        this.funcionario = funcionario;
        this.pasajero = pasajero;
        this.habitacion = habitacion;
        this.hotel = hotel;
        this.lavanderia = lavanderia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.estado = estado;
    }


    
    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Consorcio.hospedajes (nroHospedaje, idFuncionario, nroHabitacion, idHotel, nroServicio, fechaInicio, fechaFin, precio, estado) VALUES (?, ?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna parámetros a la sentencia preparada
            cmd.setInt(1, this.nroHospedaje);
            cmd.setInt(2, this.funcionario.getIdFuncionario());
            cmd.setInt(3, this.habitacion.getNroHabitacion());
            cmd.setInt(4, this.hotel.getIdHotel());
            cmd.setInt(5, this.lavanderia.getNroServicio());
            cmd.setString(6, this.fechaInicio);
            cmd.setString(7, this.fechaFin);
            cmd.setInt(8, this.precio);
            cmd.setInt(9, this.estado);

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
 
    public ArrayList<Hospedaje> getHospedajes () {
        ArrayList<Hospedaje> hospedajes = new ArrayList();
        Statement cmd = null;
        ResultSet rs;
        String sql;

        try {
            establecerConexion();

            cmd = cn.createStatement();

            sql = "SELECT * FROM Consorcio.hospedajes";

            rs = cmd.executeQuery(sql);

            
            Funcionario f = new Funcionario();
            Pasajero p = new Pasajero();
            Habitacion hab = new Habitacion();
            Lavanderia l = new Lavanderia();
            Hotel h = new Hotel();
            
            
                        
            while (rs.next()) {
               
                hospedajes.add(new Hospedaje(rs.getInt("nroHospedaje"),
                                                f.getFuncionarios().get(rs.getInt("idFuncionario")),
                                                p.getPasajeros().get(rs.getInt("idPasajero")), 
                                                hab.getHabitaciones().get(rs.getInt("nroHabitacion")),
                                                h.getHoteles().get(rs.getInt("idHotel")), 
                                                l.getServicios().get(rs.getInt("nroServicio")), 
                                                rs.getString("fechaInicio"),
                                                rs.getString("fechaFin"), 
                                                rs.getInt("precio"),
                                                rs.getInt("estado")
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
        return hospedajes;
    }

}

