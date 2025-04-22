/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.nombre;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class ModuloNombre {

    /**
     * @param args the command line arguments
     */
    public static String saludo (String nombre){
    
    System.out.println("Hola, buenos días!, "+nombre);
    System.out.println("¿Cómo le va?");
    
    return nombre;
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        String nombre1, nombre2;
        
        System.out.println("Ingrese el nombre de la primera persona");
        nombre1 = sc.nextLine();
        
        System.out.println("Ingrese el nombre de la primera persona");
        nombre2 = sc.nextLine();
        
        saludo(nombre1);
        saludo(nombre2);
        
        
        
        
    }
    
}
