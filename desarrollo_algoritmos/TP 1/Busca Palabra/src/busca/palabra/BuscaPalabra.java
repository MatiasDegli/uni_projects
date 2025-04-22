/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.palabra;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class BuscaPalabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        String frase, palabra;
        int i = 0, j = 0, acumPalabra = 0;
        
        System.out.println("Escriba una frase");
        frase = sc.nextLine();
        
        System.out.println("Escriba una palabra");
        palabra = sc.nextLine();
        
        for (i = 1; i < frase.length(); i++ ) {
                // aumenta el valor de i hasta la longitud de la frase
                
                //System.out.println(palabra.length());
                
            while (j < palabra.length() && frase.charAt(i) == palabra.charAt(j)){
                // compruebo cada caracter de la frase con el caracter de la palabra
                
                j += 1;
                
                i += 1;
                
        }
            
            //System.out.println("el valor de j es " +j);
            
            //System.out.println("el valor de length es " +palabra.length());
            
            if (j == (palabra.length())) acumPalabra += 1;
            
            j = 0;
            
                ;}
        
        System.out.println("La palabra ingresada aparece " +acumPalabra+ " veces");
        
        
    }
    
    
    
    // && j < palabra.length()
    // if (palabra.charAt(j) == frase.charAt(i))
    
}
