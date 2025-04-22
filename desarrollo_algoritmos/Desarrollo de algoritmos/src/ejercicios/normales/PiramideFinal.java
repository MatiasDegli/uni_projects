/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.normales;
import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class PiramideFinal {
    
    
    
    public static void piramide(int n){
        int fil, col;
        
        for (fil=1;fil <= n ;fil++){
            for (col=1; col <= fil; col++){
                System.out.print(numXLetra(col));
            }
            System.out.println();
        }
    }
    
    
    public static char numXLetra(int columna){
        String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", numeros="123456789";
    
        char letra=' ';
    
        if (columna%2==0) {
            letra=abecedario.charAt(columna-1);
        }
        else {
            letra=numeros.charAt(columna-1);
        }
    
        return letra;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n;
        
        System.out.println("Ingrese el tamaño de la piramide");
        n = sc.nextInt();
        
        piramide(n);
        
    }
    
}
