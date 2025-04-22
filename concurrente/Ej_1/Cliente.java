/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ej_1;

/**
 *
 * @author matia
 */
public class Cliente extends Thread {
    public void run(){
        System.out.println("soy"+Thread.currentThread().getName());
        Recurso.uso();
        
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
        }
    }
}
