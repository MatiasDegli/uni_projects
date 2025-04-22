/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_5;

/**
 *
 * @author matia
 */
class MiHilo implements Runnable {
    String nombreHilo;

    public MiHilo(String nombre){
        nombreHilo=nombre;
    }
    
    //Punto de entrada del hilo
    //Los hilos comienzan a ejecutarse aquí
    
    public void run(){
        
        System.out.println("Comenzando "+nombreHilo);
        
        try {
            
            for (int contar=0; contar<10; contar++){
                Thread.sleep(400);
                System.out.println("En "+nombreHilo+", el recuento "+contar);
            }
        }
        catch (InterruptedException exc){
            System.out.println(nombreHilo + "Interrumpido.");
        }
        
        System.out.println("Terminando "+nombreHilo);
    }
    
}
