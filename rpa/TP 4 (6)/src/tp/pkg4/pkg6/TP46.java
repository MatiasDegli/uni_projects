/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4.pkg6;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP46 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        double x1, y1, x2, y2, distancia, xCuadrado, yCuadrado;
        
        System.out.println("Ingrese la cordenada x de A");
        x1 = sc.nextDouble();
        
        System.out.println("Ingrese la cordenada y de A");
        y1 = sc.nextDouble();
        
        System.out.println("Ingrese la cordenada x de B");
        x2 = sc.nextDouble();
        
        System.out.println("Ingrese la cordenada y de B");
        y2 = sc.nextDouble();
        
        xCuadrado = (x1 - x2) * (x1 - x2);
        
        yCuadrado = (y1 - y2) * (y1 - y2);
        
        distancia = Math.sqrt(xCuadrado + yCuadrado);
        
        
        System.out.println("La distancia entre el punto A y el punto B es de " +distancia);
        System.out.println("");
        
        
        
    }
    
}
