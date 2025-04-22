/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author matia
 */
public class Cocina {
    
    
    private Lock lock = new ReentrantLock();
    
    private Condition necesitaIngrediente = lock.newCondition();
    
    private Carne[] carne = new Carne[5];
    private Vegetales[] vegetales = new Vegetales[5];
    private Pasta[] pasta = new Pasta[5];
    
    
    public void tieneCarne(Vegetales[] vegetalesCocinero, int necesitaP) throws InterruptedException{
        
        lock.lock();
        
        int i = 0, j = 0;
        
        while(j<vegetalesCocinero.length){
            
            vegetalesCocinero[j] = vegetales[i];
            vegetales[i]=null;
            
            if(vegetales[i]==null){                
                
                necesitaIngrediente.await();
                
                
            }
             
            i++;
            j++;
        }
        
    }
    
    
    public void reponerV(){
        
        for(){
            
        }
        
    }
    
}
