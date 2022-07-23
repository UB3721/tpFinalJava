/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uaa.modelo;

/**
 *
 * @author Gabriel
 */
public class Hotel {
    int idHotel;
    int codPostal;
    String tipoHotel;

    public int getidHotel() {
        return idHotel;
    }

    public void setidHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getcodPostal() {
        return codPostal;
    }

    public void setcodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String gettipoHotel() {
        return tipoHotel;
    }

    public void settipoHotel(String tipoHotel) {
        this.tipoHotel = tipoHotel;
    }
    
    public Hotel() {

    }

    public Hotel(int idHotel, int codPostal, String tipoHotel){
        this.idHotel=idHotel;
        this.codPostal=codPostal;
        this.tipoHotel=tipoHotel;
    }

}
