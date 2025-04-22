/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1b;

/**
 *
 * @author matia
 */
public class Main {
    public static void main(String[] args) {

        Puente puente = new Puente();

        int autosNorte = 23;
        int autosSur = 11;

        for (int i = 0; i < Math.max(autosNorte, autosSur); i++) {

            if (i < autosNorte) {
                // Crea un auto del norte
                Auto autoNorte = new Auto("Norte-" + (i + 1), 'N', puente);
                new Thread(autoNorte).start();
            }

            if (i < autosSur) {
                // Crea un auto del sur
                Auto autoSur = new Auto("Sur-" + (i + 1), 'S', puente);
                new Thread(autoSur).start();
            }

            // Pequeña pausa entre la creación de autos para simular tiempo entre llegadas
            try {
                Thread.sleep(100);  // Pausa de 100 milisegundos (puedes ajustar el tiempo si lo deseas)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}