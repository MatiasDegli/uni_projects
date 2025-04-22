/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpoconcu;

/**
 *
 * @author matia
 */
public class Filosofo implements Runnable {

    private final String nombre;
    private final int id;
    private final Cena cena;

    public Filosofo(String nombre, int id, Cena cena) {
        this.nombre = nombre;
        this.id = id;
        this.cena = cena;
    }

    public void pensando() {
        try {
            System.out.println(nombre + " estoy pensando.");
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void comiendo() {
        try {
            System.out.println(nombre + " estoy comiendo.");
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void run() {
        int i = 0;
        while (i < 10) {
            try {
                if (cena.agarrarCubiertos(id)) { // Intenta agarrar los dos cubiertos
                    cena.imprimirComer(id);  // Imprime en cena para evitar fallos de salida
                    // Simula comer
                    Thread.sleep(1500);
                    cena.soltarCubiertos(id);
                    // Luego de comer se pone a pensar
                    //pensando();
                    Thread.sleep(1500);
                } else {
                    // Si no puede comer, piensa
                    pensando();
                }
                // Cada acción de comer o pensar cuenta como una iteración
                //cena.imprimirLinea();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            i++;
        }
    }
}
