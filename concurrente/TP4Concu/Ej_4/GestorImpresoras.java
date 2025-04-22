/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_4;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;


/**
 *
 * @author matia
 */

public class GestorImpresoras implements Runnable {

    private Impresora[] impresoras;  // Array de impresoras
    private static int siguienteImpresora = 0; // Índice de la siguiente impresora a usar
    private static final Semaphore sem = new Semaphore(1); // Semáforo binario

    public GestorImpresoras(Impresora[] imp) {
        impresoras = imp;
    }

    public void run() {
        try {
            Impresora impresoraAsignada = null;
            
            // Adquirir el semáforo para acceder a la sección crítica
            sem.acquire();

            // Buscar la próxima impresora disponible de manera circular
            impresoraAsignada = impresoras[siguienteImpresora];
            siguienteImpresora = (siguienteImpresora + 1) % impresoras.length;

            // Liberar el semáforo después de seleccionar la impresora
            sem.release();

            // Imprimir en la impresora asignada
            impresoraAsignada.imprimiendo();

        } catch (InterruptedException ex) {
            Logger.getLogger(GestorImpresoras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
