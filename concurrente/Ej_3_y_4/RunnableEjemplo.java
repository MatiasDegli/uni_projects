/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3_y_4;

/**
 *
 * @author matia
 */
public class RunnableEjemplo implements Runnable {
    
    private String name;

    public RunnableEjemplo(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + name);
        }
        System.out.println("Termina thread " + name);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableEjemplo("Maria Jose"));
        Thread t2 = new Thread(new RunnableEjemplo("Jose Maria"));

        t1.start();
        t2.start();
        
        System.out.println("Termina thread main");
    }
}
