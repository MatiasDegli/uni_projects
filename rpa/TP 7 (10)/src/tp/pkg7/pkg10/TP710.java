/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg7.pkg10;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP710 {

    /**
     * @param args the command line arguments
     */
    
    
    public static double distanciaNodos(double x1, double y1, double x2, double y2){
    
    
    double cuadrado1 = Math.pow(x2 - x1 , 2), 
            cuadrado2 = Math.pow(y2 - y1 , 2), 
            distancia = Math.sqrt(cuadrado1+cuadrado2);
    
    return distancia;}
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int cantNodos, i;
        double x1 = 0, y1 = 0, x2, y2, distanciaTotal = 0, distanciaParcial;
        
        System.out.println("Ingrese la cantidad de nodos");
        cantNodos = sc.nextInt();
        
        for (i = 1; i <= cantNodos; i++){
        
        if (i == 1) System.out.println("Ingrese la cordenada x del primer nodo");
        if (i == 1) x1 = sc.nextDouble();
        
        if (i == 1) System.out.println("Ingrese la cordenada y del primer nodo");
        if (i == 1) y1 = sc.nextDouble();
        
        if (i != 1) System.out.println("Vuelva a ingresar la cordenada x del nodo");
        if (i != 1) x1 = sc.nextDouble();
        
        if (i != 1) System.out.println("Vuelva a ingresar la cordenada y del nodo");
        if (i != 1) y1 = sc.nextDouble();
        
        System.out.println("Ingrese la cordenada x del siguiente nodo");
        x2 = sc.nextDouble();
        
        System.out.println("Ingrese la cordenada y del siguiente nodo");
        y2 = sc.nextDouble();
        
        
        distanciaParcial = distanciaNodos(x1, y1, x2, y2);
        
        System.out.println("La distancia entre los ultimos dos nodos ingresados es de "+distanciaParcial);
        
        distanciaTotal = distanciaTotal + distanciaParcial;
        
        
        }
        
        System.out.println("La distancia total de la figura es de "+distanciaTotal);
        
    }
    
}
