/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_4;
import java.util.Random;


/**
 *
 * @author matia
 */
public class Visitante implements Runnable{
    
    private ParqueTematico parque;
    
    
    public Visitante(ParqueTematico p){
        parque = p;
    }
    
    
    public void run(){
        
        int numArea = seleccionDeArea();
        
        if(numArea!=0){
            System.out.println("El visitante "+Thread.currentThread().getName()
                    +" reservo el area "+numArea);
        }
        else{
            System.out.println("El visitante "+Thread.currentThread().getName()
                    +" no pudo reservar.");
        }        
        
    }
    
    
    public int seleccionDeArea(){
        int seleccionada = 0;
        
        Random random = new Random();   
        
        int num=parque.getCantAreas();
        int numArea = random.nextInt(num)+1;
        
        boolean exito = parque.reservar(numArea);
        
        if(exito){
            seleccionada = numArea;
        }
        
        return seleccionada;
    }
    
}
