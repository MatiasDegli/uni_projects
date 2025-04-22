/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class TestLista {
    
    public static void main(String[] args) {
        
        Lista l1 = new Lista();
        
        l1.insertar(1, 10);
        l1.insertar(2, 9);
        l1.insertar(3, 8);
        l1.insertar(2, 7);
        
        l1.eliminar(20);
        
        System.out.println(l1.toString());
        
        System.out.println("Longitud de l1: "+l1.longitud());
        
        System.out.println("Posicion del elemento 8: "+l1.localizar(8));
        
        System.out.println("Posicion del elemento 15: "+l1.localizar(15));
        
        System.out.println("Lista invertida: "+l1.invertir().toString());
        
        Lista clon = l1.clone();

        System.out.println("Clon: "+clon.toString());
        
        l1.eliminar(1);
        l1.eliminar(0);
        
        System.out.println(l1.toString());
        
        l1.insertar(1, 3);
        l1.insertar(1, 2);
        l1.insertar(1, 1);
        
        System.out.println("l1: "+l1.toString());
        
        System.out.println("Lista multiplo de 2: "+l1.obtenerMultiplos(2).toString());
        
        Lista l2 = new Lista();
        
        l2.insertar(1, 2);
        l2.insertar(1, 1);
        l2.insertar(2, 1);
        l2.insertar(3, 1);
        l2.insertar(4, 2);
        l2.insertar(1, 2);
        
        System.out.println("l2: "+l2.toString());
        
        l2.eliminarApariciones(1);
        
        System.out.println("l2: "+l2.toString());
        
    }
    
}
