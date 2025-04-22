/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpoconcu;

/**
 *
 * @author matia
 */
import java.util.concurrent.Semaphore;

public class Cena {

    private final Semaphore[] cubiertos; // Array de semáforos que representan los cubiertos
    private final Semaphore mutexSalida = new Semaphore(1); // Semaforo para la salida    
    
        
    public Cena(int numFilosofos) {
        cubiertos = new Semaphore[numFilosofos];
        
        for (int i = 0; i < numFilosofos; i++) {
            cubiertos[i] = new Semaphore(1);
        }
    }
    
    
    public boolean agarrarCubiertos(int id) throws InterruptedException {
        
        int tenedorI = id - 1; // Convertir id a índice
        int tenedorD = id % cubiertos.length;

        // Intentar adquirir ambos tenedores
        boolean agarroIzquierdo = cubiertos[tenedorI].tryAcquire();
        boolean agarroDerecho = false;

        if (agarroIzquierdo) {
            // Solo intenta agarrar el derecho si logró el izquierdo
            agarroDerecho = cubiertos[tenedorD].tryAcquire();
            if (!agarroDerecho) {
                // Si no logró agarrar el derecho, suelta el izquierdo
                cubiertos[tenedorI].release();
            }
        }
        
        return agarroIzquierdo && agarroDerecho; // Retornar verdadero solo si ambos se adquirieron
    }
     
    
    // Libera los tenedores
    public void soltarCubiertos(int id) {
        int tenedorI = id - 1;
        int tenedorD = id % cubiertos.length;

        cubiertos[tenedorI].release();
        cubiertos[tenedorD].release();

        try {
            mutexSalida.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            mutexSalida.release();
        }
    }

    // Método para imprimir estado de comer
    public synchronized void imprimirComer(int id) {
        System.out.println("Filosofo " + id + " estoy comiendo!!!");
    }

    /*
    public synchronized void imprimirLinea(){
        contador++;
        if(contador==4){
            System.out.println("\nIteracion: ");
            contador=0;
        }
    }
     */
}
