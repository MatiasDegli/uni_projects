/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg6.pkg4;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP64 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        char vocal;
        
        System.out.println("Ingrese un caracter");
        vocal = sc.next().charAt(0);
        
        if (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u'){
        
        System.out.println("Se ha ingresado una vocal");}
        
        else System.out.println("El carácter ingresado no es una vocal");
        
        
        //switch (vocal){
        
          //  case 'a': System.out.println("Se ha ingresado una vocal");
            //break;
            //case 'e': System.out.println("Se ha ingresado una vocal");
            //break;
            //case 'i': System.out.println("Se ha ingresado una vocal");
            //break;
            //case 'o': System.out.println("Se ha ingresado una vocal");a
            
            //break;
            //case 'u': System.out.println("Se ha ingresado una vocal");
            //break;
            //default : System.out.println("El carácter ingresado no es una vocal");
            //break; }
        
        
        
        
    }
    
}
