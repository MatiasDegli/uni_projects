/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_2;

/**
 *
 * @author matia
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        Energy en = new Energy();
        
        CriaturaOscura enemy = new CriaturaOscura(en);
        Sanador ally = new Sanador(en);
        
        Thread criatura = new Thread(enemy);
        Thread sanador = new Thread(ally);
        
        criatura.start();
        sanador.start();
        
        try{
            criatura.join();
            sanador.join();
        }
        catch(InterruptedException exc){
            
        }
        
        System.out.println("Energy termino en: "+en.getEnergy());
        
    }
}
