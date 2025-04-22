/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg6.pkg3;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP63 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        String codigo; 
        
        System.out.println("Ingrese el codigo del paquete");
        codigo = sc.nextLine();
        
        System.out.println("Región destino: "+codigo.charAt(3)+codigo.charAt(4)+" - Provincia Destino: "+codigo.charAt(5)+codigo.charAt(6)); 
        
        
        
        
    }
    
}
