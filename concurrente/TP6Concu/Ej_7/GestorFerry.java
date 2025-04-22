/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7;

/**
 *
 * @author matia
 */
public class GestorFerry {

    private final int capacidad = 20;
    private int espacioOcupado = 0;
    private boolean zarpo = false;
    private boolean desembarcar = false;

    
    public synchronized void ferryZarpa() {
        zarpo = true;
        System.out.println("El ferry zarpa con una capacidad de "+espacioOcupado+"/"+capacidad);
    }
    
    
    public synchronized void ferryArriba(){
        desembarcar=true;
        notifyAll();
    }
    
    
    public synchronized void ferryVuelve() {
        zarpo = false;
        desembarcar=false;
        notifyAll();
    }
    
    
    public synchronized void subePersona() throws InterruptedException {

        while (zarpo || espacioOcupado >= capacidad) {
            wait();
        }
        
        espacioOcupado++;
    }
    
    
    public synchronized void desembarcaPersona() throws InterruptedException{
        
        while(desembarcar==false){
            wait();
        }
        
        espacioOcupado--;
        
    }
    
    
    public synchronized void subeAuto() throws InterruptedException {

        while (zarpo || espacioOcupado >= capacidad-4) {
            wait();
        }
        
        espacioOcupado+=5;
    }
    
    
    public synchronized void desembarcaAuto() throws InterruptedException{
        
        while(desembarcar==false){
            wait();
        }
        
        espacioOcupado-=5;
        
    }

}
