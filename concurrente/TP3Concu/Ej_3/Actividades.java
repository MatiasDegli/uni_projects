/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author matia
 */
public class Actividades implements Runnable{
    
    
    // Semáforos para controlar el acceso a las actividades
    private static final Semaphore semaforoComer = new Semaphore(1);   // Un hamster a la vez puede comer
    private static final Semaphore semaforoCorrer = new Semaphore(1);  // Un hamster a la vez puede correr
    private static final Semaphore semaforoDescansar = new Semaphore(1); // Un hamster a la vez puede descansar

    @Override
    public void run() {
        try {
            comer();   // Cada hamster come en orden
            correr();  // Luego corre
            descansar();  // Luego descansa
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " termino todas las actividades");
    }

    public void comer() throws InterruptedException {
        while (!semaforoComer.tryAcquire()) {  // Intentar adquirir el semáforo para comer
            System.out.println("\n"+Thread.currentThread().getName() + " esperando...");
            Thread.sleep(3000);  // El hilo espera 3 segundos antes de intentar nuevamente
        }
        System.out.println("\nEl Hamster " + Thread.currentThread().getName() + " se pone a comer");
        for (int i = 0; i < 5; i++) {
            if(i==2){
                System.out.println("\n"+Thread.currentThread().getName() + " comiendo...\n");
            }
            Thread.sleep(1000);
        }
        System.out.println(Thread.currentThread().getName() + " termino de comer\n");
        semaforoComer.release();  // Liberar permiso para comer
    }

    public void correr() throws InterruptedException {
        while (!semaforoCorrer.tryAcquire()) {  // Intentar adquirir el semáforo para correr
            System.out.println("\n"+Thread.currentThread().getName() + " esperando...");
            Thread.sleep(3000);  // El hilo espera 3 segundo antes de intentar nuevamente
        }
        int time = (int) (1 + Math.random() * 10);  // Tiempo aleatorio para correr
        System.out.println("\nEl Hamster " + Thread.currentThread().getName() + " comienza a correr");
        for (int i = 0; i < time; i++) {
            if(i==3){
                System.out.println("\n"+Thread.currentThread().getName() + " corriendo...\n");
            }
            Thread.sleep(1000);
        }
        System.out.println(Thread.currentThread().getName() + " termino de correr luego de " + time + " segundos\n");
        semaforoCorrer.release();  // Liberar permiso para correr
    }

    public void descansar() throws InterruptedException {
        while (!semaforoDescansar.tryAcquire()) {  // Intentar adquirir el semáforo para descansar
            System.out.println("\n"+Thread.currentThread().getName() + " esperando...");
            Thread.sleep(3000);  // El hilo espera 3 segundo antes de intentar nuevamente
        }
        System.out.println("\nEl Hamster " + Thread.currentThread().getName() + " se acuesta a descansar");
        for (int i = 0; i < 10; i++) {
            if(i==4){
                System.out.println("\n"+Thread.currentThread().getName() + " descansando...\n");
            }
            Thread.sleep(1000);
        }
        System.out.println(Thread.currentThread().getName() + " se levanto de descansar.\n");
        semaforoDescansar.release();  // Liberar permiso para descansar
    }
    
}
