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
    
    String nombre;
    int dirección;
    String caracteristicas;
    

    public Playa(){
        super();
    }
    
    public Playa(String nombre, int dirección, String caracteristicas){
        this.nombre=nombre;
        this.dirección=dirección;
        this.caracteristicas=caracteristicas;
    }

}
