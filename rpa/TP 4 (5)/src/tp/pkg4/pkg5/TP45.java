/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4.pkg5;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP45 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        double tazaG, tazaC, cucharaG, cucharaC, grAzucar;
        
        System.out.println("Ingrese la cantidad de gramos de azúcar");
        grAzucar = sc.nextDouble();
        
        tazaG = grAzucar / 120;
        tazaC = grAzucar / 70;
        cucharaG = grAzucar / 18;
        cucharaC = grAzucar / 7;
        
        System.out.println(grAzucar+"gramos de azúcar equivalen a "
                +tazaG+" tazas grandes, "  +tazaC+" tazas chicas, "
                +cucharaG+" cucharas grandes y "+cucharaC+" cucharas chicas.");
        
    }
    
}
