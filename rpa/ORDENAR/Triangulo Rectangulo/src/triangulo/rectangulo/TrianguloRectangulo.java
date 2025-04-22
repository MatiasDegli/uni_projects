/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo.rectangulo;


import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TrianguloRectangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int grado1 = 0, grado2 = 0, grado3 = 0, sumaAngulos, triangulo;
       
        System.out.println("Ingrese el primer ángulo del triángulo");
       
        grado1 = sc.nextInt();
        
        System.out.println("Ingrese el segundo ángulo del triángulo");
        
        grado2 = sc.nextInt();
        
        System.out.println("Ingrese el tercer ángulo del triángulo");
        
        grado3 = sc.nextInt();
        
        sumaAngulos = grado1 + grado2 + grado3;
        
        triangulo = 180;
        
        if (sumaAngulos == triangulo && grado1 == 90 || grado2 == 90 || grado3 == 90) System.out.println("Se trata de un triangulo rectangulo");
        
        else System.out.println("No es un triangulo rectangulo");
        
    }
    
}
//&& grado1 + grado2 + grado3 = 180
//grado1 == 90 || grado2 == 90 || grado3 == 90