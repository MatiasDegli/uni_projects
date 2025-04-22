/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class Gato implements Runnable{
    
    
    private final String nombre;
    private final Comedor comedor;
    
    
    public Gato(String nom, Comedor com) {
        nombre = nom;
        comedor = com;
    }
    
    
    public void run(){
        
        try {
            
            comedor.primeraRaza('G');
            
            comedor.gatosComen();
            
            gatoComiendo();
            
            comedor.gatosTerminan();
            
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    public void gatoComiendo() throws InterruptedException{
        
        int time = (int) (Math.random() * (2000));
        
        Thread.sleep(time); // Para que no lleguen todos los gatos de golpe
        
        System.out.println(nombre+ " esta comiendo.");
        
        time = (int) (Math.random() * (5000 - 1000 +1) + 1000);
        
        Thread.sleep(time);
        
        System.out.println(nombre+ " termino de comer.");                
        
    }
    
}
