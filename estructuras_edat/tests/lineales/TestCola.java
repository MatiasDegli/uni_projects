/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

import lineales.dinamicas.Cola;
//import static tests.lineales.MixLineales.generarOtraCola;
/**
 *
 * @author matia
 */
public class TestCola {
    
    public static void main(String[] args) {
        
            Cola c1 = new Cola();
            
            c1.poner(1);
            c1.poner(2);
            c1.poner(3);
            c1.poner(4);
            
            System.out.println(c1.toString());
            
            Cola clon=c1.clone();
            
            System.out.println(clon.toString());
            
            c1.sacar();
            
            System.out.println(c1.toString() + " y "+ clon.toString());
            
            Cola c2 = new Cola();
            
            c2.poner('A');
            c2.poner('B');
            c2.poner('$');
            c2.poner('C');
            c2.poner('$');
            c2.poner('D');
            c2.poner('E');
            c2.poner('F');
            
            System.out.println(c2.generarOtraCola(c2).toString());
            
            
    }
}
