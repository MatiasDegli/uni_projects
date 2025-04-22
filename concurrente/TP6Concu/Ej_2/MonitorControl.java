/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_2;

/**
 *
 * @author matia
 */
public class MonitorControl {

    private final int mesas = 8;
    private int cantEstudiantes = 0;

    
    public synchronized void ingresaEstudiante() throws InterruptedException{
        
        while(cantEstudiantes==mesas){
            System.out.println("Hay un estudiante esperando");
            wait();
        }
        
        cantEstudiantes++;        
    }

    
    public synchronized void saleEstudiante(){
        
        cantEstudiantes--;
        
        notify();
        
    }
    
}
