/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

/**
 *
 * @author matia
 */
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
    public class Perro implements Runnable{


        private final String nombre;
        private final Comedor comedor;


        public Perro(String nom, Comedor com) {
            nombre = nom;
            comedor = com;
        }


        public void run(){

            try {

                comedor.primeraRaza('P');

                comedor.perrosComen();

                perroComiendo();

                comedor.perrosTerminan();

            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


        public void perroComiendo() throws InterruptedException{

            int time = (int) (Math.random() * (2000));

            Thread.sleep(time); // Para que no lleguen todos los perros de golpe

            System.out.println(nombre+ " esta comiendo.");

            time = (int) (Math.random() * (5000 - 1000 +1) + 1000);

            Thread.sleep(time);

            System.out.println(nombre+ " termino de comer.");               

        }

    }
