/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4.pkg7;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP47 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int digito, ganador3, ganador2, ganador1;
        
        System.out.println("Ingrese el número sorteado");
        digito = sc.nextInt();
        
        ganador1 = digito%10;
        ganador2 = digito%100;
        ganador3 = digito%1000;
        
        System.out.println("Ganador a 1 dígito es "+ganador1);
        System.out.println("Ganador a 2 dígito es "+ganador2);
        System.out.println("Ganador a 3 dígito es "+ganador3);
        System.out.println("Ganador a 4 dígito es "+digito);
        
        //String digito;
        
        //System.out.println("Ingrese el número sorteado");
        //digito = sc.nextLine();
        
        //System.out.println("Ganador a 1 dígito es "+digito.charAt(3));
        //System.out.println("Ganador a 2 dígito es "+digito.charAt(2)+digito.charAt(3));
        //System.out.println("Ganador a 3 dígito es "+digito.charAt(1)+digito.charAt(2)+digito.charAt(3));
        //System.out.println("Ganador a 4 dígito es "+digito);
        
    }
    
}
