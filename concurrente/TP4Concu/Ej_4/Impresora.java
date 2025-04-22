/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_4;


/**
 *
 * @author matia
 */
import java.util.concurrent.Semaphore;

public class Impresora {

    private String modelo;
    private Semaphore sem = new Semaphore(1); // Cada impresora tiene su semáforo

    public Impresora(String mod) {
        modelo = mod;
    }
    
    public void imprimiendo() throws InterruptedException {
        // Adquirir la impresora (espera si está ocupada)
        sem.acquire();

        System.out.println(Thread.currentThread().getName() + " comienza a imprimir en impresora " + modelo + "\n");
        Thread.sleep(5000);  // Simulamos el tiempo de impresión
        System.out.println(Thread.currentThread().getName() + " termina de imprimir.\n");

        // Liberar la impresora
        sem.release();
    }
    
}

