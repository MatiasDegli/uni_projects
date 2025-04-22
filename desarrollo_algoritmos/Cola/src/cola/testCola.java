/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cola;

import lineales.estaticas.Cola;

/**
 *
 * @author User
 */
public class testCola {
    
    public static void main(String[] args) {
        
        Cola cola = new Cola();
        
        for (int i = 0; i < 12; i++) {
            System.out.println(cola.poner(i));
        }
        
        System.out.println("Cola");
        System.out.println(cola.toString());
        cola.sacar();
        System.out.println("Cola sin 1 elemento: "+cola.toString());
        cola.poner(100);
        System.out.println("arreglo modificado "+cola.toString());
        
        System.out.println((cola.clone()).toString());
        
        
    }
}
