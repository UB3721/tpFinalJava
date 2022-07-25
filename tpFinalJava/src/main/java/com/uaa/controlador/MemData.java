/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * Prueba
 */
package com.uaa.controlador;

import com.uaa.modelo.Funcionario;
import com.uaa.modelo.Habitacion;
import com.uaa.modelo.Hotel;
import com.uaa.modelo.Pasajero;

/**
 *
 * @author ub3721
 */
public class MemData {
    public static String[] tipoHabitaciones = {"Suite Ejecutiva de Lujo", "Suite Ejecutiva Standard", "Ejecutiva Turista", "Ejecutiva Standard"};
    public static String[] lstPaises = {"Uruguay", "Paraguay", "Argentina", "Brasil", "Chile", "Bolivia"};
    public static String[] lstCiudad = {"Monteviedo", "Asunción", "Buenos Aires", "San Pablo", "Santiago", "Ciudad de Bolivia"};
    public static String[] tipoHoteles = {"Playa", "Ciudad", "Naturaleza"};
    public static String[] lstGeneros = {"Masculino", "Femenino"};
    public static String[] estados = {"En Espera", "Pagado"};
    
    
    public static void inicializarDatosEmpresa() {
        try{ 
            inicializarFuncionarios();   
            inicializarHabitaciones();   
        }
        catch (Exception e) {}
        
    }

    private static void inicializarFuncionarios() {   
        Funcionario f1 = new Funcionario(
                5674215,
                "Pedro",
                "Gomez", 
                "21/02/2001",
                "0971-822-122",
                0, 
                21               
        );
        f1.setIdFuncionario(1);
        
        Funcionario f2 = new Funcionario(
                3452112,
                "Carlos",
                "Sanchez", 
                "11/02/1995",
                "0962-457-632",
                0, 
                27               
        );
        f2.setIdFuncionario(2); 
        
        Funcionario f3 = new Funcionario(
                4552112,
                "Sandra",
                "Ortega", 
                "01/08/1998",
                "0961-324-111",
                1, 
                24              
        );
        f3.setIdFuncionario(3); 
        
        Funcionario f4 = new Funcionario(
                2658458,
                "Michelle",
                "Ramirez", 
                "14/07/1990",
                "0987-658-924",
                1, 
                32              
        );
        f4.setIdFuncionario(4);  
        
        Pasajero pasajero = new Pasajero(
                2658458,
                "Michelle",
                "Ramirez", 
                "14/07/1990",
                "0987-658-924",
                1, 
                32 );   
        pasajero.setIdPasajero(4); 
        pasajero.grabar();
        f1.grabar();
        f2.grabar();
        f3.grabar();
        f4.grabar(); 

        
        
    }

    private static void inicializarHabitaciones() {
        Hotel hotel = new Hotel(1, 210, 0, "Hotel Marcin", "Laurel y Ciruelo", 2, "Buenos Aires");
        
        Habitacion h1 = new Habitacion(
                1,
                500,
                0,
                hotel,
                1                
        );
        Habitacion h2 = new Habitacion(
                2,
                400,
                1,
                hotel,
                2                
        );    
        Habitacion h3 = new Habitacion(
                3, 
                300, 
                2,
                hotel,
                5
        );
        Habitacion h4 = new Habitacion (
                4, 
                200, 
                3, 
                hotel, 
                2
        );
        
        hotel.grabar();
        h1.grabar();
        h2.grabar();
        h3.grabar();
        h4.grabar();            

          
    }
}
