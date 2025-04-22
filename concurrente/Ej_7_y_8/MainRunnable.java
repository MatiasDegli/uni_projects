/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7_y_8;

/**
 *
 * @author matia
 */
public class MainRunnable {
    
    public static void main(String[] args) {
    
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5,
        2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1,
        1 });
        
        CajeroRunnable cajero1 = new CajeroRunnable("Cajero 1", cliente1);
        CajeroRunnable cajero2 = new CajeroRunnable("Cajero 2", cliente2);
        
        Thread h1 = new Thread(cajero1);
        Thread h2 = new Thread(cajero2);
        
        h1.start();
        h2.start();        
    }
    
}
