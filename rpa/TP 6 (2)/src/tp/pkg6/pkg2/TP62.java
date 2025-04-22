/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg6.pkg2;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP62 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        double dinero; 
        
        System.out.println("Ingrese la cantidad de dinero que quiera retirar.");
        dinero = sc.nextDouble();
        
        if (dinero%100 == 0) 
            System.out.println("Es posible entregar esa cantidad de dinero, por favor tome su dinero.");
        
        else 
            System.out.println("No es posible entregar esa cantidad de dinero, este cajero sólo entrega billetes de $1000, $500, $200 y $100");
               
        
        
    }
    
}
