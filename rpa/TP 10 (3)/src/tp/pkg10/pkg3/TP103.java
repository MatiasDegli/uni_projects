/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg10.pkg3;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP103 {

    /**
     * @param args the command line arguments
     */
    
    //public static boolean isLetter (char caracter){
    
    //letra 
        
    //String frase = "";
     
        
    //return frase;}
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
       
        int letra=0, numero=0;
        String oracion;
        char caracter;
        
        System.out.println("Ingrese una oración");
        oracion = sc.nextLine();
        
        System.out.println("Ingrese un caracter");
        caracter = sc.next().charAt(0);
        
        for (int i = 0; i < oracion.length(); i++){
        
            if (Character.isLetter(caracter) == oracion.charAt(i));
            
        }
        
        
    }
    
}
