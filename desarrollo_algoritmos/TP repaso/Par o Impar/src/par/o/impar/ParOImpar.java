/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.o.impar;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class ParOImpar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int i=0, j=0, acumPares = 0, acumImpares = 0; 
        String numero;
        
        System.out.println("Escriba un número entero");
        numero = sc.nextLine();
        
        while (i < numero.length()){
            
        if (numero.charAt(i) % 2 == 0) acumPares += 1;
        else acumImpares += 1;
        
        
        i += 1;
        ;} 
        
        System.out.print ("La cantidad de números pares es de " +acumPares+ 
                " y de impares es de " +acumImpares);
        
        
        
    }
    
    
}
