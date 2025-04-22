/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class Cafeteria implements Runnable{
    
    
    private Semaphore sem = new Semaphore(1);
    private Mozo mozo = new Mozo();
    
    
    public Cafeteria(Mozo m){
        mozo=m;
    }
    
    
    public void run(){
        
        try {
            sem.acquire();
            
            aviso();
            
            mozo.tomarPedido();
            
            Thread.sleep(eleccionComida());
            
            System.out.println("\n"+Thread.currentThread().getName()+" eligio su comida");
            
            mozo.cocinando();
            
            Thread.sleep(comerComida());
            
            System.out.println("\n"+Thread.currentThread().getName()+" termino de comer");
            
            mozo.inventando();
            
            Thread.sleep(2000 + (int)(Math.random() * (6000 - 1000 + 1)));
            
            sem.release();                        
        
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Cafeteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void aviso(){
        
        System.out.println("\nEl empleado "+Thread.currentThread().getName()
                +" entra a la cafeteria y avisa al mozo.");
        
    }
    
    public int eleccionComida(){
        
        int time = 1000 + (int)(Math.random() * (3000 - 1000 + 1));
        
        return time;
    }
    
    
    public int comerComida(){
        
        int time = 2000 + (int)(Math.random() * (6000 - 1000 + 1));
        
        return time;
    }
    
    
}
