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
public class Lavanderia extends ConexionBD{
    int nroServicio;
    int cantidad;
    Funcionario funcionario;
    Habitacion habitacion;
    
    public final int precioUnitario = 5;

    public Lavanderia() {
    }

    public Lavanderia(int nroServicio, int cantidad, Funcionario funcionario, Habitacion habitacion) {
        this.nroServicio = nroServicio;
        this.cantidad = cantidad;
        this.funcionario = funcionario;
        this.habitacion = habitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getNroServicio() {
        return nroServicio;
    }

    public void setNroServicio(int nroServicio) {
        this.nroServicio = nroServicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    

    
    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Consorcio.ServiciosLavanderia (nroServicio, cantidad, idFuncionario, nroHabitacion) VALUES (?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna parámetros a la sentencia preparada
            cmd.setInt(1, this.nroServicio);
            cmd.setInt(2, this.cantidad);
            cmd.setInt(3, this.funcionario.idFuncionario);
            cmd.setInt(4, this.habitacion.getNroHabitacion());

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
 
    public ArrayList<Lavanderia> getServicios () {
        ArrayList<Lavanderia> servicios = new ArrayList();
        Statement cmd = null;
        ResultSet rs;
        String sql;

        try {
            establecerConexion();

            cmd = cn.createStatement();

            sql = "SELECT * FROM Consorcio.ServiciosLavanderia";

            rs = cmd.executeQuery(sql);
            
            Funcionario fun = new Funcionario();
            Habitacion hab = new Habitacion();
            
            while (rs.next()) {
                Lavanderia lav = new Lavanderia();
                
                lav.setNroServicio(rs.getInt("nroServicio"));
                lav.setCantidad(rs.getInt("cantidad"));
                
                for (Funcionario f : fun.getFuncionarios()) {
                    if (f.getIdFuncionario()==rs.getInt("idFuncionario")) {
                        lav.setFuncionario(f);
                    }
                }
                for (Habitacion h : hab.getHabitaciones()) {
                    if (h.getNroHabitacion()==rs.getInt("nroHabitacion")) {
                        lav.setHabitacion(h);
                    }
                }
                servicios.add(lav);
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
        return servicios;
    }
     
}
