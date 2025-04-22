/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_5;

/**
 *
 * @author matia
 */
class UsoHilos{
    
    
    public static void main(String[] args) {
        
        System.out.println("Hilo principal iniciando.");
        
        //Primero, construye un objeto MiHilo.
        MiHilo mh=new MiHilo("#1");
        
        //Luego, construye un hilo de ese objeto.
        Thread nuevoHilo=new Thread(mh);
        
        MiHilo2 h2 = new MiHilo2();
        h2.setName("#2");
        MiHilo2 h3 = new MiHilo2();
        h3.setName("#3");
        
        //Finalmente, comienza la ejecución del hilo.
        nuevoHilo.start();
        h2.start();
        h3.start();
        
        for (int i=0; i<50;i++){
            System.out.print(" .");
        }
        
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        
        System.out.println("Hilo principal finalizado.");
    }
}
