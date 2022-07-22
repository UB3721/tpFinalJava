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
    
 
    
public Hotel(int IdHotel, int CodPostal, String TipoHotel){
    this.IdHotel=IdHotel;
    this.CodPostal=CodPostal;
    this.TipoHotel=TipoHotel;
}
public int IdHotel(){
    return IdHotel;
}
public void IdHotel(int IdHotel){
    this.IdHotel=IdHotel;
}
}
