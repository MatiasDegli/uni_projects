/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package número.binario;
import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class NúmeroBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int i=0; 
        String numero;
        boolean binario = true;
        
        System.out.println("Escriba un número entero");
        numero = sc.nextLine();
        
        
            
        while ( binario == true && i < numero.length()){
        
        if (numero.charAt(i) != '1' && numero.charAt(i) != '0'  ){
        binario = false;}
        
        i += 1;}
        
        
                    
        if (binario == true) {System.out.println("El número ingresado es un número binario");
        
        } else {System.out.println("El número ingresado no es binario");}
        
        
    }
    
    // binario = true && 
    // if (binario = false) 
    // && numero.charAt(i) != (0) 
    //else {binario = false;}
    
}
