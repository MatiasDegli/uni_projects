/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

import java.util.concurrent.Semaphore;
/**
 *
 * @author matia
 */
public class GestorPiscina {
    
    private final Semaphore capacidad = new Semaphore(5); // Capacidad máxima de la piscina

    public void entraPersona(Persona persona) throws InterruptedException {
        
        if (!capacidad.tryAcquire()) {
            System.out.println("\n" + persona.getNombre() + " no puede entrar porque la piscina esta llena.");
        }
        else{
            capacidad.release();
        }
        
        capacidad.acquire();
        persona.entraPiscina();
        capacidad.release(); // Liberar un espacio en la piscina
        
    }
}
