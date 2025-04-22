/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10.multiplos;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class Multiplos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic hereç
        Scanner sc = new Scanner(System.in);
        
        int numero, multiplo1, multiplo2, multiplo3, multiplo4, multiplo5, multiplo6, multiplo7, multiplo8, multiplo9, multiplo10;
        
        
        System.out.print("Escriba un número");
        numero = sc.nextInt();
        multiplo1 = numero*1;
        multiplo2 = numero*2; 
        multiplo3 = numero*3; 
        multiplo4 = numero*4; 
        multiplo5 = numero*5; 
        multiplo6 = numero*6; 
        multiplo7 = numero*7; 
        multiplo8 = numero*8;
        multiplo9 = numero*9;
        multiplo10 = numero*10;
        
        
        
        
        
        // int [] multiplos = {(numero*1), (numero*2), (numero*3), (numero*4), (numero*5), (numero*6), (numero*7), (numero*8), (numero*9), (numero*10)};
                
        // for ( i =0; i < multiplos.length ; i ++);
        
        System.out.println("Los diez primeros múltiplos de ese número son " + multiplo1 + ", " + multiplo2 + ", " + multiplo3 + ", " + multiplo4 + ", " 
                + multiplo5 + ", " + multiplo6 + ", " + multiplo7 + ", " + multiplo8 + ", " + multiplo9 + ", " + multiplo10);
                
                
                
                
                
        
        
    }
    
}
