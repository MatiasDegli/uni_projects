/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

/**
 *
 * @author matia
 */
public class Cocinero implements Runnable{
    
    
    private Cocina cocina;
    private String preparado;
    
    // Los ingredientes que tiene cada cocinero.
    private int carne = 5;
    private int vegetales = 5;
    private int pasta = 5;
    
    
    public Cocinero(String prep){
        preparado = prep;
    }
    
    
    public void run(){
            
        if(preparado == "carne"){
            cocina.tieneCarne();
        }
        else if(preparado == "vegetales"){
            
        }
        else if(preparado == "pasta"){
            
        }
        
        
    }
    
    
    
}
