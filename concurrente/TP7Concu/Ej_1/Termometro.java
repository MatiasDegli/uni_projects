/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class Termometro implements Runnable {

    private int temp = 25;
    private GestorSala gestor;
    private boolean aumentando = true;

    public Termometro(GestorSala g) {
        gestor = g;
    }

    public void run() {
        while (true) {
            try {
                // Notifica el cambio de temperatura al gestor
                gestor.notificarTemp(temp);

                // Lógica para incrementar o decrementar la temperatura
                if (aumentando) {
                    temp++;
                    if (temp >= 35) { // Límite superior
                        aumentando = false; // Cambia la dirección
                    }
                } else {
                    temp--;
                    if (temp <= 25) { // Límite inferior
                        aumentando = true; // Cambia la dirección
                    }
                }

                // Pausa para simular el tiempo entre cambios de temperatura
                Thread.sleep(1000); // Puedes ajustar este valor según la velocidad deseada

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
                break; // Sale del ciclo si el hilo es interrumpido
            }
        }
    }

}
