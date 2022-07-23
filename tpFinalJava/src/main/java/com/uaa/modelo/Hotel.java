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
    int IdHotel;
    int CodPostal;
    String TipoHotel;

    public int getIdHotel() {
        return IdHotel;
    }

    public void setIdHotel(int IdHotel) {
        this.IdHotel = IdHotel;
    }

    public int getCodPostal() {
        return CodPostal;
    }

    public void setCodPostal(int CodPostal) {
        this.CodPostal = CodPostal;
    }

    public String getTipoHotel() {
        return TipoHotel;
    }

    public void setTipoHotel(String TipoHotel) {
        this.TipoHotel = TipoHotel;
    }
    
    public Hotel() {

    }

    public Hotel(int IdHotel, int CodPostal, String TipoHotel){
        this.IdHotel=IdHotel;
        this.CodPostal=CodPostal;
        this.TipoHotel=TipoHotel;
    }

}
