/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpoconcu;


/**
 *
 * @author matia
 */
public class CenaFilosofosTest {

    public static void main(String[] args) {
        int cantFilos = 5;
        Cena cena = new Cena(cantFilos);
        
        Filosofo[] filo = new Filosofo[cantFilos];
        Thread[] filosofos = new Thread[cantFilos];

        // Crear filósofos e hilos
        for (int i = 0; i < cantFilos; i++) {
            filo[i] = new Filosofo("Filosofo " + (i+1), i+1, cena);
            filosofos[i] = new Thread(filo[i]);
        }
        
        // Iniciar los hilos
        for (int i = 0; i < cantFilos; i++) {
            filosofos[i].start();
        }
    }
}

