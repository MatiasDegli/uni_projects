/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_6;

/**
 *
 * @author matia
 */
public class Carrera {
    
    public static void main(String[] args) {
        
        Corredor c1 = new Corredor("Matias");
        Corredor c2 = new Corredor("Juan");
        Corredor c3 = new Corredor("Santiago");
        Corredor c4 = new Corredor("Federico");
        Corredor c5 = new Corredor("Marcos");
        
        Corredor[] arr = new Corredor[5];
        arr[0]=c1;
        arr[1]=c2;
        arr[2]=c3;
        arr[3]=c4;
        arr[4]=c5;
        
        
        Thread h1 = new Thread(arr[0]);
        Thread h2 = new Thread(arr[1]);
        Thread h3 = new Thread(arr[2]);
        Thread h4 = new Thread(arr[3]);
        Thread h5 = new Thread(arr[4]);
    
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        
        try{
            h1.join();           
            h2.join();
            h3.join();
            h4.join();
            h5.join();
            
        }
        catch(InterruptedException e){
            
        }
        
        
        // Encuentra el número más grande usando condicionales
        Corredor ganador = arr[0];  // Asume que el primer corredor es el ganador inicial

        for (Corredor corredor : arr) {
            if (corredor.getRecorrido() > ganador.getRecorrido()) {
                ganador = corredor;
            }
        }
        
        System.out.println("El ganador es " + ganador.getNombre() + "!");
    }
    
    
    
    
}
