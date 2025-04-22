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
public class BinarioR {

    
    public static int pasarBinario (int n){
        int binario;
        if (n<2){
            binario=n;
        }
        else{
            
            binario=((n%2)+pasarBinario(n/2)*10);
        }
        return binario;
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n;
        
        System.out.println("Ingrese un número");
        n = sc.nextInt();
        
        System.out.println(pasarBinario(n));
        
    }
    
}
