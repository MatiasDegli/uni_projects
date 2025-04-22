/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package número.inversa;
import java.util.Scanner;
/**
 *
 * @author Zambon
 */
public class NúmeroInversa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int valor; //cifra1, cifra2, cifra3;
        String acumNum = "";
        
        System.out.println("Escriba un número entero");
        valor = sc.nextInt();
        
        while (valor>0){
        acumNum = acumNum + valor%10;
        valor = valor/10;}    
        
        
        System.out.println("El número entero invertido es " +acumNum);
        
        
    }
    
    //cifra1 = valor%10;
    //cifra2 = (valor/10)%10; 
    //cifra3 = (valor/100)%10;
    
}
