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

public class QuinielaNacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int numSorteado, gana1Digito, gana2Digitos, gana3Digitos, gana4Digitos; 
        Scanner sc = new Scanner(System.in);
                
        System.out.print("Ingrese el valor del numero sorteado");
        
        numSorteado = sc.nextInt();
        
        gana1Digito = numSorteado%10;
        
        gana2Digitos = numSorteado%100;
        
        gana3Digitos = numSorteado%1000;
        
        gana4Digitos = numSorteado%10000;
       
        
         System.out.print("El número ganador de 1 digito es: " + gana1Digito );
         
         System.out.print("El número ganador de 2 digitos es: " + gana2Digitos );
         
         System.out.print("El número ganador de 3 digitos es: " + gana3Digitos );
         
         System.out.print("El número ganador de 4 digitos es: " + gana4Digitos );
        
        
        
        
        
        
        
        
    }
    
}
