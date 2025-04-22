/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

/**
 *
 * @author matia
 */
public class MostradorPostre {
    
    private int postre = 20;
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
    
    
    public boolean quedaPostre(){        
        return postre>0;        
    }
    
    
    public void seLlevaPostre(){
        postre--;
    }
    
}
