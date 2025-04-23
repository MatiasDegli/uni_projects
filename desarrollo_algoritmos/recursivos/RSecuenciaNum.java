/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.recursivos;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class RSecuenciaNum {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static int leer(int acumMult){
        Scanner sc = new Scanner(System.in);
        int n;
    
        System.out.println("Ingrese un digito, si el digito es 0, se termina la secuencia");
        n = sc.nextInt();
        
        if (n != 0) {
            if (n%3==0){
                acumMult+=1;
            }
            acumMult = leer(acumMult);
        }    
        return acumMult;
    }
    
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nLa cantidad de numeros multiplos de 3 de la secuencia es de "+leer(0));
    }
    
}
