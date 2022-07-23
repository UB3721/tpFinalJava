/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uaa.modelo;

/**
 *
 * @author Gabriel
 */
public class Hospedaje {
    Funcionario funcionario;
    Pasajero pasajero;
    Habitacion habitacion;
    Hotel hotel;
    Lavanderia lavanderia;
    String fechaInicio;
    String fechaFin;
    int precio;
    
public Hospedaje(Funcionario funcionario, Pasajero pasajero, Habitacion habitacion, Hotel hotel, Lavanderia lavanderia, 
                 String fechaInicio, String fechaFin, int precio){
    this.funcionario=funcionario;
    this.pasajero=pasajero;
    this.habitacion=habitacion;
    this.hotel=hotel;
    this.lavanderia=lavanderia;
    this.fechaInicio=fechaInicio;
    this.fechaFin=fechaFin;
    this.precio=precio;
}
    
}

