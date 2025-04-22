/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
class TesteoHilos{
    
    public static void main (String[] args){
        Thread miHilo = new MiEjecucion();
        
        miHilo.start();
        
        try {
            miHilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TesteoHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("En el main");
    }
        
}