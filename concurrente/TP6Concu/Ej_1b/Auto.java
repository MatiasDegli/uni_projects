/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1b;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class Auto implements Runnable {

    private Puente puente;
    private char direccion;
    private String patente;

    public Auto(String pat, char d, Puente p) {
        direccion = d;
        puente = p;
        patente = pat;
    }

    public void run() {

        puente.inicio(direccion);
        
        if (direccion == 'N') {

            try {
                puente.pasaNorte();
                
                autoPasando();
                
                puente.pasoNorte();

            } catch (InterruptedException ex) {
                Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (direccion == 'S') {

            try {
                puente.pasaSur();
                
                autoPasando();

                puente.pasoSur();

            } catch (InterruptedException ex) {
                Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void autoPasando() throws InterruptedException {
        System.out.println("El auto de patente: " + patente + " esta pasando !!!");
    
        Thread.sleep(5000);
        
        System.out.println("El auto de patente: " + patente + " paso.");
    }
    

}
