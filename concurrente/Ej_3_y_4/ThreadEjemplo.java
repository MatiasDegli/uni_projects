package Ej_3_y_4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matia
 */
public class ThreadEjemplo extends Thread {
    
    
    public ThreadEjemplo(String str) {
        super(str);
    }
    
    
    public void run() {
        
        for (int i = 0; i < 10 ; i++){
            System.out.println(i + " " + getName());
        }
        
        System.out.println("Termina thread " + getName());
    }
    
    
    public static void main (String [] args) {
        
        new ThreadEjemplo("Maria Jose").start();
        new ThreadEjemplo("Jose Maria").start();
        
        System.out.println("Termina thread main");
    }
    
}

