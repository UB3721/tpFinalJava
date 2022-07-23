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

    int cedula;
    String nombre;
    String apellido;
    String fechaNacimiento;
    String telefono;
    String genero;
    int edad;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    public Persona(int cedula, String nombre, String apellido, String fechaNacimiento, String telefono, String genero, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.genero = genero;
        this.edad = edad;
    }
    
    
    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Hoteles.personas (cedula, nombre, apellido, fechaNacimiento, telefono, genero, edad) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna parámetros a la sentencia preparada
            cmd.setInt(1, this.cedula);
            cmd.setString(2, this.nombre);
            cmd.setString(3, this.apellido);
            cmd.setString(4, this.fechaNacimiento);
            cmd.setString(5, this.telefono);
            cmd.setString(6, this.genero);
            cmd.setInt(7, this.edad);

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
 
    public ArrayList<Persona> getPersonas () {
        ArrayList<Persona> contactos = new ArrayList();
        Statement cmd = null;
        ResultSet rs;
        String sql;

        try {
            establecerConexion();	//-- establece la conexión

            /**
            * Establecer un objeto tipo Statement (o PreparedStatement, o CallableStatement)
            * que es el encargado de gestionar todos los comandos contra la BD. Una tiene ventaja
            * sobre la otra y dependerá del tipo de aplicación y BD para usar uno u otro.
            **/
            cmd = cn.createStatement();

            /**
            * Construye la sentencia SLQ que desea ejecutar, pueden ser sentencias de selección
            * o de acción es decir Data Definition Language (DDL) o Data Manipulation Language(DML)
            * En este caso mostramos una sentencia de selección.
            **/
            sql = "SELECT * FROM Hoteles.Personas";

            /**
            * Si lo que se desea es hacer una consulta, se debe crear un objeto de tipo ResultSet
            * para contener el resultado devuelto por el comando.
            **/
            rs = cmd.executeQuery(sql);

            /**
            * Se puede acceder a los datos obtenidos de la BD a través de sus nombres de campos
            * o por el número de posición de la columna, comenzado por 1.
            **/
            while (rs.next()) {
                contactos.add(new Persona(rs.getInt("cedula"),
                                           rs.getString("nombre"),
                                           rs.getString("apellido"),
                                           rs.getString("fechaNacimiento"),
                                           rs.getString("telefono"), 
                                           rs.getString("genero"),
                                           rs.getInt("edad")
                ));
            }
                
            /**
            * Se cierran los objetos creados en este ámbito
            */
            rs.close();
            rs = null;
        }
        catch (SQLException e) {
            System.err.println("Error de SQL: " + e);
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
                catch (SQLException e) {}
            }
            cerrarConexion();
        }
        return contactos;
    }
    
}