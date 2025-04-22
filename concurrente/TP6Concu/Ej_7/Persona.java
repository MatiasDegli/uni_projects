/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class Persona implements Runnable{
    
    private GestorFerry gestor;
    private int nroPasajero;
    
    
    public Persona(int nro, GestorFerry g){
        nroPasajero=nro;
        gestor=g;
    }
    
    
    public void run(){
        
        try {
            gestor.subePersona();
            
            subio();
            
            gestor.desembarcaPersona();
            
            desembarco();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void subio(){
        System.out.println("El pasajero "+nroPasajero+ " subio al ferry.");
    }
    
    
    public void desembarco(){
        System.out.println("El pasajero "+nroPasajero+ " desembarco del ferry.");
    }
    
}
