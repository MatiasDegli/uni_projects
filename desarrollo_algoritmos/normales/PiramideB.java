/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.normales;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class PiramideB {

    /**
     * @param args the command line arguments
     */
    
    public static String piramideA (int N){             
    
        String frase = "Esta es la piramide de tipo A de tamaño "+N;
        
    for (int fila = 1; fila <= N; fila++) {
            for (int colum = 1; colum <= fila; colum++) {
                System.out.print(fila);
            }
            System.out.println(" ");
    }
            return frase;}
            
    
    
    
    public static String piramideB (int N){
    
    String frase = "Esta es la piramide de tipo B de tamaño "+N;
        
    for (int fila = 1; fila <= N; fila++) {
            for (int colum = 1; colum <= fila; colum++) {
                System.out.print(colum);
            }
            System.out.println(" "); 
    }
    
    return frase;}
    
    
    
    
    
    
    public static String piramideC (int N) {
            
        String frase = "Esta es la piramide de tipo C de tamaño "+N;
            int mult = 0;
            
        for (int fila = 1; fila <= N; fila++) {
            for (int colum = 1; colum <= fila; colum++) {
                
                //if (colum == 1) suma = 0;
                mult = colum * fila;
                
                if (colum >= 2) System.out.print(mult);
                else System.out.print(fila);
            }
            System.out.println(" ");
        
    }
    
            return frase;}
        
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            
            int N;
            char tipo;
        
        System.out.println("Ingrese el tamaño de la pirámide.");
        N = sc.nextInt();
        
        System.out.println("Ingrese el tipo de pirámide (A, B o C).");
        tipo = sc.next().charAt(0);
        
        switch (tipo){
            
            case 'A': System.out.println(piramideA(N));
            break;
            
            case 'B': System.out.println(piramideB(N));
            break;
            
            case 'C': System.out.println(piramideC(N));
            break;
        
        }
        }
        
        
        
        
        
        
        
        
        
        
}