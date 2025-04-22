/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_4;

/**
 *
 * @author matia
 */
public class Main {
    
    public static void main(String[] args) {
        
        ParqueTematico parque = new ParqueTematico();
        
        Area area1 = new Area();
        Area area2 = new Area();
        Area area3 = new Area();
        
        
        parque.agregarArea(area1);
        parque.agregarArea(area2);
        parque.agregarArea(area3);
        
        
        Visitante v1 = new Visitante(parque);
        Visitante v2 = new Visitante(parque);
        Visitante v3 = new Visitante(parque);
        
        
        Thread c1 = new Thread(v1, "Juan");
        Thread c2 = new Thread(v2, "Rodrigo");
        Thread c3 = new Thread(v3, "Julian");
        
        c1.start();
        c2.start();
        c3.start();
        
        
    }
    
}
