/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_2;

/**
 *
 * @author matia
 */
public class Sanador implements Runnable{
    
    private Energy en;
    
    public Sanador(Energy e){
        en=e;
    }
    
    public void run(){
        
        
        try{
            
            for (int i = 0; i < 10; i++) {
                en.cargar(3);        
                Thread.sleep(100);
                //System.out.println("El sanador curo 3 puntos de energia");
            }
            
        }
        catch(InterruptedException exc){
            
        }
        
    }
    
}
