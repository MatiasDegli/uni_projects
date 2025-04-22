/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.caracter;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class BuscaCaracter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        String cadena;
        char caracter = ' ';
        int acumChar = 0, i=0;
        boolean prueba = true;
        
        
        System.out.println("Ingrese una cadena de caracteres");
        cadena = sc.nextLine();
        
        System.out.println("Ingrese el caracter que desea buscar");
        
        for ( i = 1; i < cadena.length(); i ++)  {
        
        if (cadena.charAt(i) == caracter) acumChar = acumChar + 1;
        }
        
        System.out.println("El caracter " +caracter+ "aparece " +acumChar+ "veces");
        
    }
    
}
