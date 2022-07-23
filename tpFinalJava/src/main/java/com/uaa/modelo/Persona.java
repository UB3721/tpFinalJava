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
public class Persona extends ConexionBD{


    int idPersona;
    int cedula;
    String nombreCompleto;
    String fechaNacimiento;
    String telefono;
    String genero;
    int edad;
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public Persona() {
        
    }
    
    public Persona(int idPersona, int cedula, String nombreCompleto, String fechaNacimiento, String telefono, String genero, int edad){
        this.idPersona=idPersona;
        this.cedula=cedula;
        this.nombreCompleto=nombreCompleto;
        this.fechaNacimiento=fechaNacimiento;
        this.telefono=telefono;
        this.genero=genero;
        this.edad=edad;
    }
    
    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Hoteles.personas (cedula, nombreCompleto, fechaNacimiento, telefono, genero, edad) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna parámetros a la sentencia preparada
            cmd.setInt(1, this.cedula);
            cmd.setString(2, this.nombreCompleto);
            cmd.setString(3, this.fechaNacimiento);
            cmd.setString(4, this.telefono);
            cmd.setString(5, this.genero);
            cmd.setInt(6, this.edad);

            //-- Ejecuta la sentencia
            int result = cmd.executeUpdate();
            
            if (result > 0) {
                rs = cmd.getGeneratedKeys();
                if (rs.next())
                    this.idPersona = rs.getInt(1);
                else
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
            /**
             * Se cierran los objetos abiertos en este ámbito.
             */
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
    
}