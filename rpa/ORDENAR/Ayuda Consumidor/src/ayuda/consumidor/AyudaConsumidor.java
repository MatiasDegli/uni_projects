/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayuda.consumidor;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class AyudaConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double cantidad1, cantidad2, precio1, precio2, precioReal1, precioReal2;
        
        System.out.println("Ingrese la cantidad de lt o kg del primer producto");
        cantidad1 = sc.nextDouble();
        
        System.out.println("Ingrese el precio del primer producto");
        precio1 = sc.nextDouble();
        
        System.out.println("Ingrese la cantidad de lt o kg del segundo producto");
        cantidad2 = sc.nextDouble();
        
        System.out.println("Ingrese el precio del segundo producto");
        precio2 = sc.nextDouble();
        
        precioReal1 = precio1 / cantidad1;
        precioReal2 = precio2 / cantidad2;
        
        if (precioReal2 > precioReal1) System.out.println("El producto uno es más económico");
        
        else if (precioReal2 == precioReal1) System.out.println("Los dos productos son igual de económicos");
        
        else System.out.println ("El producto dos es más económico");
    }
    
}
