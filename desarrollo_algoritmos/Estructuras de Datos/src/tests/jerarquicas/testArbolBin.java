/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolBin;

/**
 *
 * @author Zambon
 */
public class testArbolBin {
    
    public static void main(String[] args) {
        ArbolBin arbol = new ArbolBin();
        
        arbol.insertar("A", "", 'I');
        arbol.insertar("B", "A", 'I');
        arbol.insertar("C", "A", 'D');
        arbol.insertar("D", "B", 'I');
        arbol.insertar("E", "C", 'I');
        arbol.insertar("F", "C", 'D');
        arbol.insertar("G", "E", 'I');
        arbol.insertar("H", "E", 'D');
        
        System.out.println(arbol.toString());
        
        System.out.println(arbol.listarPreorden());
        
        System.out.println(arbol.listarInorden());
    
    }
    
}
