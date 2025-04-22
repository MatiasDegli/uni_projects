/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvocal;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class EsVocal {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        char letra;
        
        System.out.println("Ingrese un caracter");
        letra = sc.next().charAt(0);
        
        if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U')
        
        System.out.println("Se ha ingresado una vocal");
                
                else System.out.println("El carácter ingresado no es una vocal");
        
        
        
}
    
}