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
public class Auto implements Runnable{
    
    private GestorFerry gestor;
    private String patente;
    
    
    public Auto(String pat, GestorFerry g){
        patente=pat;
        gestor=g;
    }
    
    
    public void run(){
        
        try {
            gestor.subeAuto();
            
            subio();
            
            gestor.desembarcaAuto();
            
            desembarco();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void subio(){
        System.out.println("El auto "+patente+ " subio al ferry.");
    }
    
    
    public void desembarco(){
        System.out.println("El auto "+patente+ " desembarco del ferry.");
    }
    
}