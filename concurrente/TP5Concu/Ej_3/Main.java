/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

/**
 *
 * @author matia
 */
public class Main {
    
    public static void main(String[] args) {
        
        int cantGatos = 20;
        int cantPerros = 8;
        int comederos = 5;
        
        int cantAnimales;
        
        if(cantGatos > cantPerros){
            cantAnimales = cantGatos;
        }
        else{
            cantAnimales = cantPerros;
        }
        
        Gato[] gatos = new Gato[cantGatos];
        Perro[] perros = new Perro[cantPerros];
        Thread[] hilosG = new Thread[cantGatos];
        Thread[] hilosP = new Thread[cantPerros];
        
        Comedor comedor = new Comedor(comederos);
        
        for (int i = 0; i < cantAnimales; i++) {
            
            if(i<cantGatos){
                gatos[i] = new Gato("Gato "+i, comedor);
            }
            
            if(i<cantPerros){
                perros[i] = new Perro("Perro "+i, comedor);
            }
            
        }
        
        for (int i = 0; i < cantAnimales; i++) {
            
            if(i<cantGatos){
                hilosG[i] = new Thread(gatos[i]);
            }
            
            if(i<cantPerros){
                hilosP[i] = new Thread(perros[i]);
            }
            
            if(cantGatos == cantPerros){
                hilosG[i].start();            
                hilosP[i].start();
            }
            else if(cantGatos > cantPerros){
                
                if(i < cantPerros){
                    hilosG[i].start();
                    hilosP[i].start();
                }
                else{
                    hilosG[i].start();
                }
            }
            else{                
                
                if(i < cantGatos){
                    hilosP[i].start();
                    hilosG[i].start();
                }
                else{
                    hilosP[i].start();
                }
            }
        }
        
    }
    
}
