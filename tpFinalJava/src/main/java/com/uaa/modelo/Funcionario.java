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
public class Funcionario extends Persona {
    int idFuncionario;

    public Funcionario() {
    }
    
    public Funcionario(int cedula, String nombre, String apellido, String fechaNacimiento, String telefono, int genero, int edad){
        super(cedula, nombre, apellido, fechaNacimiento, telefono, genero, edad);
    }
    public Funcionario(int idFuncionario){
        this.idFuncionario=idFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
 
    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Consorcio.Funcionarios (idFuncionario, cedula, nombre, apellido, fechaNacimiento, telefono, genero, edad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna parámetros a la sentencia preparada
            cmd.setInt(1, this.idFuncionario);
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
 
    public ArrayList<Funcionario> getFuncionarios () {
        ArrayList<Funcionario> funcionarios = new ArrayList();
        Statement cmd = null;
        ResultSet rs;
        String sql;

        try {
            establecerConexion();

            cmd = cn.createStatement();

            sql = "SELECT * FROM Consorcio.Funcionarios";

            rs = cmd.executeQuery(sql);
            
            while (rs.next()) {
                Funcionario fun = new Funcionario(rs.getInt("cedula"),
                                                    rs.getString("nombre"),
                                                    rs.getString("apellido"),
                                                    rs.getString("fechaNacimiento"),
                                                    rs.getString("telefono"),
                                                    rs.getInt("genero"),
                                                    rs.getInt("edad")
                );
                fun.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionarios.add(fun);
                
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
        return funcionarios;
    }
     
}