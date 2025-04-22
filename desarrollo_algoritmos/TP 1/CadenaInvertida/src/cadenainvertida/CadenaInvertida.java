/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenainvertida;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class CadenaInvertida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        String cadena;
        int i = 0, j = 0, a = 0, x = 0;
        
        
        System.out.println("Escriba una cadena de caracteres");
        cadena = sc.nextLine();
        
        String [] invertir = new String [cadena.length()];
        
        for (i = 1; i < cadena.length(); i++ ){
        
            //if (cadena.charAt(i) == ' ' )
            
            
            while (i < cadena.length() && cadena.charAt(i) != ' ' && cadena.charAt(i) != ','
                && cadena.charAt(i) != ';' && cadena.charAt(i) != '.' ){
        
                i += 1;
            }
        
        
            
            invertir [a] = cadena.substring(j, i);
        
            a += 1;
        
            j = i + 1;
        }
        
        //System.out.print (" array " + invertir [1]);
        
        // System.out.print("ri " + a);
        
        
        x = a;
        
        
        System.out.print ("La frase invertida es ");
                
        while (x != 0){
        
            System.out.print (invertir [x - 1] + " ");
            
            x -= 1;
        }
        
    }
    
    
    
    //System.out.print(i);
        
        //System.out.print (" substring " +cadena.substring(j, (i)));
       
        //if (i < cadena.length() && cadena.substring(j, i) != " ") {
}
