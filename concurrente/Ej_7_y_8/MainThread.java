/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7_y_8;

/**
 *
 * @author matia
 */
public class MainThread {
    
    public static void main(String[] args) {
    
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5,
        2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1,
        1 });
        
        CajeroThread cajero1 = new CajeroThread("Cajero 1", cliente1);
        CajeroThread cajero2 = new CajeroThread("Cajero 2", cliente2);
        
        cajero1.start();
        cajero2.start();        
    }
    
}