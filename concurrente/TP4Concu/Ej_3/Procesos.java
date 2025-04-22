/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class Procesos implements Runnable{
    
    Semaphore adquirido;
    Semaphore liberado;
    
    
    public Procesos(Semaphore a, Semaphore b){
        adquirido = a;
        liberado = b;
    }
    
    
    public synchronized void run(){
        
        try {
            
            P1();
            P2();
            P3();
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void P1() throws InterruptedException{
        adquirido.acquire();
        Thread.sleep(1000);
        System.out.println("Proceso P1...");
        liberado.release();
    }
    
    
    public void P2() throws InterruptedException{
        adquirido.acquire();
        Thread.sleep(1000);
        System.out.println("Proceso P2...");
        liberado.release();
    }
    
    
    public void P3() throws InterruptedException{
        adquirido.acquire();
        Thread.sleep(1000);
        System.out.println("Proceso P3...");
        liberado.release();
    }
    
    
}
