/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4.pkg10;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP410 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        double largo, alto, ancho, frigoriaM3, metros3;
        
        frigoriaM3 = 2500/50;
        
        System.out.println("Ingrese el largo de la habitación");
        largo = sc.nextDouble();
        System.out.println("Ingrese el ancho de la habitación");
        ancho = sc.nextDouble();
        System.out.println("Ingrese la altura de la habitación");
        alto = sc.nextDouble();
        
        metros3 = largo * alto * ancho;
        
        frigoriaM3 = frigoriaM3 * metros3;
        
        System.out.println(+frigoriaM3);
        
        
        
        
    }
    
}
