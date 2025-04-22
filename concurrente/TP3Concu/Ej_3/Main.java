/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

/**
 *
 * @author matia
 */
public class Main {
    
    public static void main(String[] args) {
        
        Actividades actividades = new Actividades();
        
        Thread hamster1 = new Thread(actividades, "Alvin");
        Thread hamster2 = new Thread(actividades, "Copito");        
        Thread hamster3 = new Thread(actividades, "Lucky");
    
        hamster1.start();
        hamster2.start();
        hamster3.start();        
        
    }
    
}
