/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

/**
 *
 * @author matia
 */
public class Persona implements Runnable {
    private String nombre;
    private GestorPiscina gestor;

    public Persona(String nom, GestorPiscina g) {
        this.nombre = nom;
        this.gestor = g;
    }

    public String getNombre() {
        return nombre;
    }

    
    public void run() {
        try {
            gestor.entraPersona(this);
        } catch (InterruptedException ex) {
            
        }
    }

    
    public void entraPiscina() throws InterruptedException {
        System.out.println("\n"+nombre+" entra en la piscina.");
        
        Thread.sleep(7000); // Simular el tiempo en la piscina
    
        System.out.println("\n"+nombre+" sale de la piscina.");
    }
    
}
