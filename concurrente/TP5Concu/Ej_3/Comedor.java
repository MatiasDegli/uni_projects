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
public class Comedor {

    // Sem genericos
    private final Semaphore gatosComen;
    private final Semaphore perrosComen;
    
    // Mutex
    private final Semaphore mutexPrimero = new Semaphore(1);
    private final Semaphore mutexGatoCome = new Semaphore(1);    
    private final Semaphore mutexPerroCome = new Semaphore(1);    
    
    // Contadores
    private int gatosEsperando = 0;
    private int perrosEsperando = 0;
    private int gatosComiendo = 0;
    private int perrosComiendo = 0;
    
    
    private boolean inicioDia = false;
    
    private char razaActiva;
    
    private final int cantComederos;
    
    
    public Comedor(int cap) {
        gatosComen = new Semaphore(0);
        perrosComen = new Semaphore(0);        
        cantComederos = cap;
        
    }
    
    
    public void primeraRaza(char c) throws InterruptedException {
        
        // Inicia a comer la raza del primer hilo que llega
        
        mutexPrimero.acquire();
        
        if (inicioDia == false) {
            
            inicioDia = true;
            
            razaActiva = c;

            if (razaActiva == 'G') {
                gatosComen.release(cantComederos);
            } else {
                perrosComen.release(cantComederos);
            }
        }

        mutexPrimero.release();
    }

    
    public void cambiaRaza() {

        if (razaActiva == 'G') {
            razaActiva = 'P';
            perrosComen.release(cantComederos);
        } else {
            razaActiva = 'G';
            gatosComen.release(cantComederos);
        }
    }
    
    
    public void gatosComen() throws InterruptedException {
        
        mutexGatoCome.acquire();
        
        gatosEsperando++; // Contador de gatos en espera
        
        mutexGatoCome.release();
        
        gatosComen.acquire();            
        
        // Los perros liberaron los comederos
        
        mutexGatoCome.acquire(); // Sincronizamos a traves de un mutex        
        
        gatosEsperando--;
        
        gatosComiendo++; // Contador de gatos comiendo de manera concurrente        
        
        mutexGatoCome.release();
    }

    
    public void gatosTerminan() throws InterruptedException {

        mutexGatoCome.acquire();
        
        gatosComiendo--;
        
        //System.out.println("Gatos esperando: "+gatosEsperando +" y perros: "+perrosEsperando);
        
        if(perrosEsperando==0 && gatosEsperando>0){ // Si ya no quedan perros y hay gatos, siguen comiendo gatos
            gatosComen.release();
        }
        
        if (gatosComiendo == 0) {
            cambiaRaza();
        }

        mutexGatoCome.release();
    }
    
    
    public void perrosComen() throws InterruptedException {
        
        mutexPerroCome.acquire();
        
        perrosEsperando++; // Contador de perros en espera        
        
        mutexPerroCome.release();
        
        perrosComen.acquire();
        
        // Los gatos liberaron los comederos
        
        mutexPerroCome.acquire(); // Sincronizamos a traves de un mutex
        
        perrosEsperando--;
        
        perrosComiendo++; // Contador de perros comiendo de manera concurrente        
        
        mutexPerroCome.release();
    }

    
    public void perrosTerminan() throws InterruptedException {

        mutexPerroCome.acquire();

        perrosComiendo--;
        
        if(gatosEsperando==0 && perrosEsperando>0){ // Si ya no quedan gatos y hay perros, siguen comiendo perros
            perrosComen.release();
        }
        
        if (perrosComiendo == 0) {
            cambiaRaza();
        }
        
        mutexPerroCome.release();
    }
    
    
}
