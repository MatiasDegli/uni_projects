/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

/**
 *
 * @author matia
 */
public class MostradorAlmuerzo {
    
    private int comidaConGaseosa = 10;
    private int comidaConAgua = 10;
    private int cola = 0;
            
    
    public void llegaSoldado(){
        cola++;
    }
    
    
    public void saleSoldado(){
        cola--;
    }
    
    
    public int cantSoldados(){
        return cola;
    }
    
    
    public boolean quedaComida(){        
        return comidaConAgua+comidaConGaseosa>0;        
    }
    
    
    public boolean quedaGaseosa(){
        return comidaConGaseosa>0;
    }
    
    
    public boolean quedaAgua(){
        return comidaConAgua>0;
    }
    
    
    public void eligeGaseosa(){
        comidaConGaseosa--;
    }
    
    
    public void eligeAgua(){
        comidaConAgua--;
    }
    
}
