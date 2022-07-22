/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uaa.modelo;

/**
 *
 * @author Gabriel
 */
public class Ciudad extends Hotel {
    String Nombre;
    int Dirección;
    

    public Ciudad(){
        super();
    }
    public Ciudad(String Nombre, int Dirección){
        this.Nombre=Nombre;
        this.Dirección=Dirección;
    }
}
