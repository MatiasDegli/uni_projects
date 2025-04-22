/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_4;

/**
 *
 * @author matia
 */
public class Area {
    
    
    private boolean disponibilidad = true;
            
    
    public void reservada(){
        disponibilidad=false;
    }
    
    public boolean getDisponibilidad(){
        return disponibilidad;
    }
    
    
}
