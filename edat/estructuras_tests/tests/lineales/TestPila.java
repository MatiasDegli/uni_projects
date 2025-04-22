/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

//import lineales.estaticas.Pila;
import lineales.dinamicas.Pila;

/**
 *
 * @author matia
 */
public class TestPila {

    public static void main(String[] arg) {
        Pila p1 = new Pila();

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);
        p1.apilar(4);
        p1.apilar(5);

        System.out.println(p1);
        Pila clon2=p1.clone();
        System.out.println("clon: " + clon2);


        p1.desapilar();
        p1.desapilar();
        System.out.println(p1);

        Pila clon=p1.clone();
        System.out.println("clon = " + clon);

        System.out.println("tope de pila = "+p1.obtenerTope());


        p1.desapilar();

        System.out.println("p1 = " + p1.toString());
        System.out.println("clon = " + clon.toString());

        System.out.println("tope de clon = "+clon.obtenerTope());
        clon.desapilar();
        System.out.println(clon);

        
        System.out.println(p1);
        System.out.println(p1.esVacia());

        p1.obtenerTope();
        p1.desapilar();
        p1.desapilar();
        System.out.println("P1 es: "+p1.toString());
        
        Pila cap = new Pila();
        
        cap.apilar(1);
        cap.apilar(2);
        cap.apilar(1);
        cap.apilar(3);
        cap.apilar(1);
        cap.apilar(2);
        cap.apilar(1);
        
        
        System.out.println("es capicua? " +cap.esCapicua());
        
        
    }

}