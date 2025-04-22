/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_8;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author matia
 */
public class Mecanico extends Thread{
    
    
    private final LineaMecanico lineaM;
    private final String direccion;
    private boolean ensamblado = false;
    

    public Mecanico(LineaMecanico linea) {
        this.lineaM = linea;
        direccion = "Oeste";
    }
    
    
    public void run() {
           
        try {
            lineaM.llegaMecanico(this);
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(Mecanico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void setEnsamblado(){
        ensamblado=true;
    }
    
    
    public void sale(){
        
        System.out.println("\nEl producto mecanico fue ensamblado correctamente");
        
    }
    
    
    public String getDireccion(){
        return direccion;
    }
    
}
