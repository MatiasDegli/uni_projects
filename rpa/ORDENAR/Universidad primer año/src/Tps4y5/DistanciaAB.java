/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tps4y5;

/**
 *
 * @author Zambon
 */

import java.util.Scanner;
public class DistanciaAB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double x1, y1, x2, y2, d, A, B; 
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el valor de la coordenada x1");
        x1 = sc.nextDouble();
        System.out.println("Ingrese el valor de la coordenada y1");
        y1 = sc.nextDouble();
        System.out.println("Ingrese el valor de la coordenada x2");
        x2 = sc.nextDouble();
        System.out.println("Ingrese el valor de la coordenada y2");
        y2 = sc.nextDouble();
        
        A = x1 - x2;
        B = y1 - y2;
        
        //A2 = Math.pow(A, 2);
        //B2 = Math.pow(B, 2);
        //d = Math.sqrt((A2 + B2));
        
        d = Math.sqrt(((Math.pow(A, 2)+ Math.pow(B, 2))));
       
        
        System.out.println("La distancia entre A y B es de: " +d);
                
        
    }
    
}
