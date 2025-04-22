/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

/**
 *
 * @author matia
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GestorPiscina gestor = new GestorPiscina();

        // Crear varias personas
        for (int i = 1; i <= 10; i++) {
            Persona persona = new Persona("Persona " + i, gestor);
            Thread thread = new Thread(persona); // Crear un hilo con la instancia de Persona
            thread.start(); // Iniciar el hilo
            Thread.sleep(1000);
        }
    }
}
