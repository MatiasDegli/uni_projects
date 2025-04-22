/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.conjuntistas;

import conjuntistas.HeapMin;

/**
 *
 * @author matia
 */
public class TestArbolHeap {
    public static void main(String[] args) {
        
        HeapMin a = new HeapMin();
        a.insertar(7);
        a.insertar(27);
        a.insertar(10);
        a.insertar(30);
        a.insertar(8);
        a.insertar(85);
        a.insertar(1);
        
        System.out.println(a.toString());
        
        //System.out.println(a.recuperarCima());
    
        a.eliminarCima();
        
        System.out.println(a.toString());
        
        System.out.println("La cima es: "+a.recuperarCima());
    }
    
}
