/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1b;

/**
 *
 * @author matia
 */
public class Puente {

    // Contadores
    private int esperaNorte = 0;
    private int esperaSur = 0;
    private int pasandoNorte = 0;
    private int limitePaso = 10;
    private int pasandoSur = 0;

    // Otros 
    private boolean inicioBarrera = false;
    private char direccion;           

    
    public synchronized void inicio(char d) {

        if (!inicioBarrera) {
            // El primer hilo determina que direccion comienza
            inicioBarrera = true;
            direccion = d;
            
            System.out.println("Se abre la barrera "+ d);
            
            if (d == 'N') {
                esperaNorte++;
            } else {
                esperaSur++;
            }
        }
        else{
            // El resto de los hilos suman al contador de espera
            if (d == 'N') {
                esperaNorte++;
            } else {
                esperaSur++;
            }
        }
    }
    
    
    public synchronized void cambioDireccion(){
        
        System.out.println("Cambio de direccion !!!");
        
        if(direccion=='N'){
            direccion = 'S';
            limitePaso=10;
            notifyAll();
        }
        else{
            direccion = 'N';
            limitePaso=10;
            notifyAll();            
        }
    }
    

    public synchronized void pasaNorte() throws InterruptedException {
        
        // Si esta habilitado el pasa del lado Sur y no hay autos, cambia de direccion
        if(direccion=='S' && esperaSur==0 && pasandoSur==0){
            cambioDireccion();
        }
        
        while(direccion=='S' || limitePaso==0) {
            wait();
        }
        
        esperaNorte--;
        pasandoNorte++;
        limitePaso--;
    }

    
    public synchronized void pasoNorte() throws InterruptedException {
        
        pasandoNorte--;
        
        if(pasandoNorte==0){
            if(esperaNorte>0 && esperaSur==0){
                limitePaso=10;
                notifyAll();
            }
            else{
                cambioDireccion();
            }
        }
        
    }

    public synchronized void pasaSur() throws InterruptedException {        
        
        // Si esta habilitado el pasa del lado Norte y no hay autos, cambia de direccion
        if(direccion=='N' && esperaNorte==0 && pasandoNorte==0){
            cambioDireccion();
        }
        
        while(direccion=='N' || limitePaso==0) {
            wait();
        }
        
        esperaSur--;
        pasandoSur++;
        limitePaso--;        
    }

    public synchronized void pasoSur() throws InterruptedException {
        
        pasandoSur--;
        
        if(pasandoSur==0){
            if(esperaSur>0 && esperaNorte==0){
                limitePaso=10;
                notifyAll();
            }
            else{
                cambioDireccion();
            }
        }
    }

}
