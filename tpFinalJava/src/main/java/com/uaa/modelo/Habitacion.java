/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uaa.modelo;

/**
 *
 * @author Gabriel
 */
public class Habitacion {
    int nroHabitacion;
    int precio;
    String tipoHabitacion;
    Hotel hotel;
    int capacidad;
    String descripcion;
    

public Habitacion(int nroHabitacion, int precio, String tipoHabitacion, 
                   Hotel hotel, int capacidad, String descripcion){
    this.nroHabitacion=nroHabitacion;
    this.precio=precio;
    this.tipoHabitacion=tipoHabitacion;
    this.hotel=hotel;
    this.capacidad=capacidad;
    this.descripcion=descripcion;
                 
}
}