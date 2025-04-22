/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7;

/**
 *
 * @author matia
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        GestorFerry gestor = new GestorFerry();
        Ferry ferry = new Ferry(gestor);
        
        // Crear un hilo para el ferry
        Thread ferryThread = new Thread(ferry);
        ferryThread.start();
        
        // Usar un ExecutorService para manejar múltiples pasajeros y autos
        ExecutorService executor = Executors.newFixedThreadPool(10); // Número de hilos para pasajeros y autos
        
        // Crear y enviar 10 pasajeros al ferry
        for (int i = 1; i <= 20; i++) {
            Persona persona = new Persona(i, gestor);
            executor.submit(persona);
            // Alternar la creación de autos y personas
            if (i % 2 == 0) {
                Auto auto = new Auto("AUTO-" + (i / 2), gestor);
                executor.submit(auto);
            }
        }

        // Cerrar el executor después de que se hayan enviado todas las tareas
        executor.shutdown();
    }
}

