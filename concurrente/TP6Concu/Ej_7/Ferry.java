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
public class Ferry implements Runnable{
    
    private GestorFerry gestor;
            
    
    public Ferry(GestorFerry g){
        gestor=g;
    }
    
    
    public void run(){
        
        int i=0;
        
        try {
            
            while(true){
                
                embarcando();
                
                gestor.ferryZarpa();

                navegando();
                
                gestor.ferryArriba();
                
                desembarcando();
                
                navegando();
                
                gestor.ferryVuelve();
                
                i++;
            }
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Ferry.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void navegando() throws InterruptedException{
        
        System.out.println("El ferry esta en alta mar.");
        
        Thread.sleep(5000);
    }
    
    
    public void desembarcando() throws InterruptedException{
        
        System.out.println("El ferry arriva a destino, comienzan a desembarcar.");
        
        Thread.sleep(2000);
        
        System.out.println("El ferry ha desembarcado, pega la vuelta.");
    }
    
    
    public void embarcando() throws InterruptedException{
        
        System.out.println("El ferry esta listo para embarcar.");
        
        Thread.sleep(5000);
        
    }
    
    
}
