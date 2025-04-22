/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.conjuntistas;
import conjuntistas.dinamicas.ArbolBB;
/**
 *
 * @author Zambon
 */
public class testArbolBB {
    public static void main(String[] args) {
        
        ArbolBB arbol = new ArbolBB();
        
        arbol.insertar(6);
        arbol.insertar(11);
        arbol.insertar(14);
        arbol.insertar(21);
        arbol.insertar(13);
        arbol.insertar(20);
        arbol.insertar(5);
        
        System.out.println(arbol.toString());
        
        arbol.eliminar(21);
        
        ArbolBB clon = arbol.clone();
        
        System.out.println(arbol.toString());
        
    }
}
