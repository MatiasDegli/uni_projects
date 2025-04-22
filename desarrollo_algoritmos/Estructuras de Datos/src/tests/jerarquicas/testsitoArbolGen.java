/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author Zambon
 */
public class testsitoArbolGen {
    
    public static void main(String[] args) {
        ArbolGen arbol1 = new ArbolGen();
        
         
          arbol1.insertar('A',null);
          arbol1.insertar('B','A');
          arbol1.insertar('C','A');
          arbol1.insertar('D','A');
          arbol1.insertar('E','B');
          arbol1.insertar('F','B');
          arbol1.insertar('G','B');
          arbol1.insertar('H','D');
          arbol1.insertar('I','G');
          arbol1.insertar('J','I');
          arbol1.insertar('K','E');
          arbol1.insertar('L','E');
          arbol1.insertar('M','L');
          
          
        
        
        
        System.out.println(arbol1.toString());
        Lista l= new Lista();

        l.insertar(15, 1);
        l.insertar(47, 2);
        l.insertar(9, 3);
        l.insertar(63, 4);
        l.insertar(54, 5);
        l.insertar(19, 6);
        System.out.println(l.toString());
        //System.out.println("Son frontera debe retornar true: "+ arbol1.sonFrontera(l));
        
        ArbolGen clon = arbol1.clone();
        
        
        
        System.out.println(arbol1.equals(arbol1));
        System.out.println(arbol1.equals(clon));
        
        clon.insertar('P','B');
        
        ArbolGen arbol2 = new ArbolGen();
        
         
          arbol1.insertar('A',null);
          arbol1.insertar('B','A');
          arbol1.insertar('C','A');
          arbol1.insertar('D','A');
          arbol1.insertar('Q','A');
          arbol1.insertar('F','B');
          arbol1.insertar('X','B');
          arbol1.insertar('H','D');
          arbol1.insertar('I','G');
          arbol1.insertar('J','I');
          arbol1.insertar('K','E');
          arbol1.insertar('L','E');
          arbol1.insertar('M','L');
        
        System.out.println(arbol1.equals(clon));
        System.out.println(arbol1.equals(arbol2));
    }
    
}
