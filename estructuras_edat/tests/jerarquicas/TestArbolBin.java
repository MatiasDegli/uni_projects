/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolBin;
import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class TestArbolBin {
    
    public static void main(String[] args) {
        
        ArbolBin a1 = new ArbolBin();
        
        a1.insertar(1, "A" , 'i');
        a1.insertar("A", "B" , 'i');
        a1.insertar("A", "C", 'd');
        a1.insertar("B", "D", 'i');
        a1.insertar("C", "E", 'i');
        a1.insertar("C", "F", 'd');
        a1.insertar("E", "G", 'i');
        a1.insertar("E", "H", 'd');
        
        System.out.println(a1.toString());
        
        
        ArbolBin clon;
        clon=a1.clone();
        
        System.out.println("El clon del arbol es: " + clon.toString()+ "\n"
                + "Hasta aqui llega el clon.\n");
        
        
        ArbolBin clonInv=a1.clonarInvertido();
        
        System.out.println("El clon invertido del arbol es: " + clonInv.toString()+ "\n"
                + "Hasta aqui llega el clon.\n");
        
        Lista preorden = a1.listarPreorden();
        System.out.println(preorden.toString());
        
        Lista inorden = a1.listarInorden();
        System.out.println(inorden.toString());
        
        Lista posorden = a1.listarPosorden();
        System.out.println(posorden.toString());
        
        Lista porNivel = a1.listarNiveles();
        System.out.println(porNivel.toString());
        
        Lista front = a1.frontera();
        System.out.println(front.toString());
        
        Lista ancestros = a1.obtenerAncestros("G");
        System.out.println("ancestros de G: "+ ancestros.toString());
    
        Lista descendientes = a1.obtenerDescendientes("C");
        System.out.println("descendientes de C: " +descendientes.toString());
        
        /*a1.insertarPorPosicion("J", 2, 'i');
        System.out.println(a1.toString());
    
        a1.insertarPorPosicion("Z", 6, 'd');
        System.out.println(a1.toString());*/
        
        Lista lis = new Lista();
        
        lis.insertar(lis.longitud()+1, "A");
        lis.insertar(lis.longitud()+1, "C");
        lis.insertar(lis.longitud()+1, "E");
        lis.insertar(lis.longitud()+1, "H");
        
        System.out.println("lis: "+lis.toString());
    
        System.out.println("arbol: "+a1.toString());
        
        System.out.println("Es lis parte de arbol? "+a1.verificarPatron(lis));
        
    }
    
}
