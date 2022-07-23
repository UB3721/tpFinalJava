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
    String nombre;
    int direccion;
    String caracteristicas;


public Ciudad(String nombre, int dirección, String caracteristicas){
    this.nombre=nombre;
    this.direccion=dirección;
    this.caracteristicas=caracteristicas;
}
}
