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

    public Hospedaje() {
    }

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

    public int getNroHospedaje() {
        return nroHospedaje;
    }

    public void setNroHospedaje(int nroHospedaje) {
        this.nroHospedaje = nroHospedaje;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Lavanderia getLavanderia() {
        return lavanderia;
    }

    public void setLavanderia(Lavanderia lavanderia) {
        this.lavanderia = lavanderia;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    
    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Consorcio.hospedajes (nroHospedaje, idFuncionario, idPasajero, nroHabitacion, idHotel, nroServicio, fechaInicio, fechaFin, precio, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna parámetros a la sentencia preparada
            cmd.setInt(1, this.nroHospedaje);
            cmd.setInt(2, this.funcionario.getIdFuncionario());
            cmd.setInt(3, this.pasajero.getIdPasajero());
            cmd.setInt(4, this.habitacion.getNroHabitacion());
            cmd.setInt(5, this.hotel.getIdHotel());
            cmd.setInt(6, this.lavanderia.getNroServicio());
            cmd.setString(7, this.fechaInicio);
            cmd.setString(8, this.fechaFin);
            cmd.setInt(9, this.precio);
            cmd.setInt(10, this.estado);

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
                    
            
            Funcionario fun = new Funcionario();
            Pasajero pas = new Pasajero();
            Habitacion hab = new Habitacion();
            Hotel hot = new Hotel();
            Lavanderia lav= new Lavanderia();
            
            while (rs.next()) {
                Hospedaje hos = new Hospedaje();
                
                hos.setNroHospedaje(rs.getInt("nroHospedaje"));
                hos.setFechaInicio(rs.getString("fechaInicio"));
                hos.setFechaFin(rs.getString("fechaFin"));
                hos.setPrecio(rs.getInt("precio"));
                hos.setEstado(rs.getInt("estado"));
                        
                
                for (Funcionario f : fun.getFuncionarios()) {
                    if (f.getIdFuncionario()==rs.getInt("idFuncionario")) {
                        hos.setFuncionario(f);
                    }
                }
                for (Pasajero p : pas.getPasajeros()) {
                    if (p.getIdPasajero()==rs.getInt("idPasajero")) {
                        hos.setPasajero(p);
                    }
                }
                for (Habitacion h : hab.getHabitaciones()) {
                    if (h.getNroHabitacion()==rs.getInt("nrohabitacion")) {
                        hos.setHabitacion(h);
                    }
                }
                for (Lavanderia l : lav.getServicios()) {
                    if (l.getNroServicio()==rs.getInt("nroServicio")) {
                        hos.setLavanderia(l);
                    }
                }
                
                hospedajes.add(hos);
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

