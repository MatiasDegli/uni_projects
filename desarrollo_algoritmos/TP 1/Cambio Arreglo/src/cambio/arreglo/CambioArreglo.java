/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambio.arreglo;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class CambioArreglo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int numero, i = 0, longitud = 0;
        
        
        System.out.println("Ingrese la longitud del arreglo");
        longitud = sc.nextInt();
        
        int [] arreglo = new int [longitud];
        
        System.out.println("Ingrese un número entero");
        numero = sc.nextInt();
        
        while (i < longitud){
            
            if (i % 2 == 0) arreglo [i] = numero;
        
            i +=1;
            
        }
            
        i = 0;
        
        System.out.println("El arreglo es ");
        while (i < longitud){
        
                System.out.print (arreglo [i] + " ");
            
                i += 1;
                }
        
    }
    
}
