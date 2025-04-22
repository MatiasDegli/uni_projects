/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class TestArbolGen {
    
    
    public static void main(String[] args) {
        ArbolGen a = new ArbolGen();
        
        a.insertar("A", "Z");
        
        a.insertar("B", "A");
        
        a.insertar("C", "A");
        
        a.insertar("D", "A");
        
        a.insertar("H", "D");
        
        a.insertar("J", "D");
        
        a.insertar("E", "C");
        
        a.insertar("E", "C");
        
        a.insertar("J", "E");
        
        a.insertar("F", "E");

        a.insertar("X", "F");

        a.insertar("J", "F");

        System.out.println(a.toString());
        
        System.out.println(a.descendienteMasLejano("J"));

        System.out.println(a.caminoAHojaMasLejana().toString());
    }
}
