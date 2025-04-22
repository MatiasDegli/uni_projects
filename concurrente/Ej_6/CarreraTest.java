/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_6;

/**
 *
 * @author matia
 */
public class CarreraTest {
    
    public static void main(String[] args) {
        
        CorredorTest c1 = new CorredorTest("Matias");
        CorredorTest c2 = new CorredorTest("Juan");
        CorredorTest c3 = new CorredorTest("Santiago");
        CorredorTest c4 = new CorredorTest("Federico");
        CorredorTest c5 = new CorredorTest("Marcos");

        Thread h1 = new Thread(c1);
        Thread h2 = new Thread(c2);
        Thread h3 = new Thread(c3);
        Thread h4 = new Thread(c4);
        Thread h5 = new Thread(c5);
    
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
                
    }
    
    
    
    
}
