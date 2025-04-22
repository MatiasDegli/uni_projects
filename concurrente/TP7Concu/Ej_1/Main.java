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

    public static void main(String[] args) {
        GestorSala gestorSala = new GestorSala();
        Termometro termometro = new Termometro(gestorSala);
        
        
        // Crear y ejecutar el hilo del termómetro
        Thread hiloTermometro = new Thread(termometro);
        hiloTermometro.start();

        // Crear hilos para personas, algunas de ellas jubiladas
        Thread[] personas = new Thread[50];
        
        for (int i = 0; i < 50; i++) {
            boolean esJubilado = (i % 5 == 0); // Cada 5 personas una es jubilada
            
            Persona persona;
            
            if(!esJubilado){
                persona = new Persona(esJubilado, "Persona " + (i + 1), gestorSala);
            }
            else{
                persona = new Persona(esJubilado, "Persona jubilada " + (i + 1), gestorSala);
            }
            personas[i] = new Thread(persona);
            personas[i].start();
            
//            try {
//                // Simulamos tiempos de llegada para que no entren todas al mismo tiempo
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        
        // Espera a que todos los hilos de personas terminen
        for (Thread persona : personas) {
            try {
                persona.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Finalizar el hilo del termómetro después de cerrar la simulación
        hiloTermometro.interrupt();
    }
}
