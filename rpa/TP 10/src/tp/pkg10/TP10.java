/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg10;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int i = 0;
        String oracion;
        char caracter;
        boolean existe = false;
        
        System.out.println("Ingrese una oración");
        oracion = sc.nextLine();
        
        System.out.println("Ingrese un caracter");
        caracter = sc.next().charAt(0);
        
        while (i < oracion.length() && (existe == false)){
        
            
            if (caracter == oracion.charAt(i)) existe = true;
            
            i +=1;
        }
        
        if (existe == true)System.out.println("El caracter "+caracter+" se encuentra en la oración ingresada");
        else System.out.println("El caracter "+caracter+" no se ha encontrado");
        
    }
    
}
