/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1A;

import java.util.concurrent.Semaphore;

/**
 *
 * @author matia
 */
public class Puente {
    
    // Semaforos genericos
    private Semaphore barreraNorte = new Semaphore(10);
    private Semaphore barreraSur = new Semaphore(0);

    // Semaforos binarios
    private Semaphore mutexNorte;
    private Semaphore mutexSur;
    
    // Contadores
    private int autosPasando = 10;
    
    // Otros
    private char dirActual = 'N';
    
    
    public void cambiaDireccion(){
        
        if(dirActual=='N'){
            dirActual='S';
            barreraSur.release(10);
        }
        else{
            dirActual='N';
            barreraNorte.release(10);
        }
    }
    
    
    public void pasaNorte() throws InterruptedException{
        
        barreraNorte.acquire();
        
        mutexNorte.acquire();
        
        autosPasando++;
        
        mutexNorte.release();
    }
    
    
    public void pasoNorte() throws InterruptedException{
        
        mutexNorte.acquire();
        
        autosPasando--;
        
        if(autosPasando==0){            
            cambiaDireccion();            
        }
        
        mutexNorte.release();       
    }
    
    
    public void pasaSur() throws InterruptedException{
        
        barreraSur.acquire();
        
        mutexSur.acquire();
        
        autosPasando++;
        
        mutexSur.release();
    }
    
    
    public void pasoSur() throws InterruptedException{
        
        mutexSur.acquire();
        
        autosPasando--;
        
        if(autosPasando==0){            
            cambiaDireccion();            
        }
        
        mutexSur.release();       
    }
    
}
