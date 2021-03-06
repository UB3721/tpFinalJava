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

/**
 *
 * @author Gabriel
 */
public class Hotel extends ConexionBD{
    int idHotel;
    int codPostal;
    int tipoHotel;
    String nombre;
    String direccion;
    int pais;
    String ciudad;

    public Hotel() {
    }

    public Hotel(int idHotel, int codPostal, int tipoHotel, String nombre, String direccion, int pais, String ciudad) {
        this.idHotel = idHotel;
        this.codPostal = codPostal;
        this.tipoHotel = tipoHotel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public int getTipoHotel() {
        return tipoHotel;
    }

    public void setTipoHotel(int tipoHotel) {
        this.tipoHotel = tipoHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }



        
    public boolean grabar() {
        boolean resp = false;
        PreparedStatement cmd = null;   // Sentencia preparada
        ResultSet rs;                   // Para recuperar el Id generado
	String sql = "INSERT INTO Consorcio.Hoteles (idHotel, codPostal, tipoHotel, nombre, direccion, pais, ciudad) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            //-- Se conecta a la BD
            establecerConexion();
            
            //-- Carga la sentencia preparada con el script sql
            cmd = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //-- Asigna par??metros a la sentencia preparada
            cmd.setInt(1, this.idHotel);
            cmd.setInt(2, this.codPostal);
            cmd.setInt(3, this.tipoHotel);
            cmd.setString(4, this.nombre);
            cmd.setString(5, this.direccion);
            cmd.setInt(6, this.pais);
            cmd.setString(7, this.ciudad);

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
        catch (SQLException e) {}
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

            sql = "SELECT * FROM Consorcio.hoteles";

            rs = cmd.executeQuery(sql);

            while (rs.next()) {
                hoteles.add(new Hotel(rs.getInt("idHotel"),
                                           rs.getInt("codPostal"), 
                                           rs.getInt("tipoHotel"),
                                           rs.getString("nombre"),
                                           rs.getString("direccion"),                                           
                                           rs.getInt("pais"), 
                                           rs.getString("ciudad")
                ));
            }
                
            rs.close();
            rs = null;
        }
        catch (SQLException e) {}
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
