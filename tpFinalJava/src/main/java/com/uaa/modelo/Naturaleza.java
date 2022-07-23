/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uaa.modelo;

/**
 *
 * @author Gabriel
 */
public class Naturaleza extends Hotel {
    
    String nombre;
    int dirección;
    String descripcion;

public Naturaleza (){
super();
}
public Naturaleza (String nombre, int dirección, String descripcion){
    this.nombre=nombre;
    this.dirección=dirección;
    this.descripcion=descripcion;
}
}
