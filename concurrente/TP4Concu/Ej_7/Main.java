/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7;

/**
 *
 * @author matia
 */
public class Main {

    public static void main(String[] args) {
        Mozo mozo = new Mozo();

        Cafeteria cafeteria = new Cafeteria(mozo);

        Thread hiloMozo = new Thread(mozo);
        Thread e1 = new Thread(cafeteria, "Marcos");
        Thread e2 = new Thread(cafeteria, "Santiago");
        Thread e3 = new Thread(cafeteria, "Sebastian");
        
        hiloMozo.start();
        e1.start();
        e2.start();
        e3.start();
    }

}
