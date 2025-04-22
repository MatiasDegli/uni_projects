/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglo.de.caracteres;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class ArregloDeCaracteres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int i = 0, j = 0;
        String cadena, eleccion = " ";
        char [] arreglo = new char [10];
        
        System.out.println("Ingrese una cadena de diez caracteres");
        cadena = sc.nextLine();
               
        while (i < cadena.length()) 
        {arreglo[j] = cadena.charAt(i); 
        
            i += 1;
            j += 1;
        }
        
        j = 0;
        
        System.out.println("¿Quiere ver la cadena en el orden ingresado o invertido?");
        eleccion = sc.nextLine();
        
        switch (eleccion)
            // permite seleccionar el orden en el que se quiere ver la cadena
        {
            case "ingresado": 
                while (j < cadena.length()){
        
                System.out.print (arreglo [j] + " ");
            
                j += 1;
                }
                break;
                
            case "invertido":
                while (i != 0){
        
                System.out.print (arreglo [i - 1] + " ");
            
                i -= 1;
            
                }
                break;
            }
            
            
        }
    
        }
    
    
    

//while (i != 0){
        
  //          System.out.print (arreglo [i - 1] + " ");
            
    //        i -= 1;
      //      }


//while (j < cadena.length()){
        
  //          System.out.print (arreglo [j] + " ");
            
    //        j += 1;
      //      }


//if (eleccion == "a") 
  //      {
    //        while (j < cadena.length()){
        
      //      System.out.print (arreglo [j] + " ");
            
        //    j += 1;
          //  }
            
            
        //}
        //else {
          //  while (i != 0){
        
            //System.out.print (arreglo [i - 1] + " ");
            
            //i -= 1;
        //    }
        //}
    //}