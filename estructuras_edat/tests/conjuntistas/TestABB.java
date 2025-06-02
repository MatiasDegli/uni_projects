/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.conjuntistas;

import conjuntistas.ABB;
import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class TestABB {
    
    public static void main(String[] args) {
        
        ABB a = new ABB();
        
        a.insertar(15);
        a.insertar(4);
        a.insertar(2);
        a.insertar(7);
        a.insertar(30);
        a.insertar(5);
        a.insertar(10);
        a.insertar(20);
        a.insertar(14);
        
        System.out.println(a.toString());
        
        System.out.println("Elemento minimo: "+ a.minimoElem()+ "\nElemento maximo: "+a.maximoElem());
        
        Lista inorden = a.listar();
        System.out.println(inorden.toString());
        
        Lista porRango = a.listarRango(4, 15);
        System.out.println(porRango.toString());
        
        System.out.println(a.pertenece(14));
        System.out.println(a.pertenece(19));
        System.out.println(a.pertenece(30)+"\n\n");
        
        a.insertar(6);
        System.out.println(a.toString());
        
        System.out.println(a.eliminar(4));
        System.out.println(a.toString());
        
        
        
    }
    
}
