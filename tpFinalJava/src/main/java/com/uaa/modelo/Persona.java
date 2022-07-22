/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uaa.modelo;

/**
 *
 * @author Gabriel
 */
public class Persona {
    String NombreCompleto;
    String FechaNacimiento;
    int Cedula;
    String Genero;
    int Edad;
    int Telefono;
    
    public Persona(String NombreCompleto, String FechaNacimiento, int Cedula,
                    String Genero, int Edad, int Telefono){
    this.NombreCompleto=NombreCompleto;
    this.FechaNacimiento=FechaNacimiento;
    this.Cedula=Cedula;
    this.Genero=Genero;
    this.Edad=Edad;
    this.Telefono=Telefono;
    }
    
}
