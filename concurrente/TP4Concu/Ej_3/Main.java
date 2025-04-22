/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author matia
 */
public class Main {

    public static void main(String[] args) {
        
        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(0);
        Semaphore sem3 = new Semaphore(0);
        
        Procesos P1 = new Procesos(sem1, sem3);
        Procesos P2 = new Procesos(sem2, sem1);
        Procesos P3 = new Procesos(sem3, sem2);
        
        Thread hilo1 = new Thread(P1);
        Thread hilo2 = new Thread(P2);
        Thread hilo3 = new Thread(P3);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
    }

}
