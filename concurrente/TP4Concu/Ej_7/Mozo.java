/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7;

/**
 *
 * @author matia
 */
public class Mozo implements Runnable{
    
    private boolean disponible = false;
    
    
    public boolean getDisponible(){
        return disponible;
    }
    
    
    public void run(){
        
        if (disponible==true){
            inventando();
        }
        
    }
    
    
    public void libre(){
        disponible=true;
    }
    
    
    public void inventando(){
        
        System.out.println("\nEl mozo esta libre y se pone a inventar recetas");
        
    }
    
    
    public void tomarPedido() throws InterruptedException{
        
        Thread.sleep(1000);
        
        System.out.println("\nEl mozo tomara el pedido del empleado cuando decida su comida");
        
    }
    
    
    public void cocinando() throws InterruptedException{
        
        Thread.sleep(1000);
        
        System.out.println("\nEl mozo se pone a cocinar");
        
        Thread.sleep(5000);
        
        System.out.println("\nEl mozo termina de cocinar y sirve la comida");
        
    }
    
    
    
    
}
