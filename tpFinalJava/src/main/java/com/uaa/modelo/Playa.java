/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uaa.modelo;

/**
 *
 * @author Gabriel
 */
public class Playa extends Hotel {
    
    String Nombre;
    int Dirección;
    String Descripcion;
    

    public Playa(){
        super();
    }
    
    public Playa(String Nombre, int Dirección, String Descripcion){
        this.Nombre=Nombre;
        this.Dirección=Dirección;
        this.Descripcion=Descripcion;
    }
}
