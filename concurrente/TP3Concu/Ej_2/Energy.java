/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_2;

/**
 *
 * @author matia
 */
public class Energy {
    
    private int en = 10;
    
    
    public synchronized void cargar(int n){
        
        en+=n;
                
        System.out.println("La energy cambio en : "+n+" y ahora hay: "+en+"\n");
    }
    
    
    public int getEnergy(){
        return en;
    }
    
}
