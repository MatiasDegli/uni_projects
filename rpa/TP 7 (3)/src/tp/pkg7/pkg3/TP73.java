/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg7.pkg3;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP73 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int codigo = 690105, codigoIngresado = 0, i = 0, j = 0;
        
        
        
        while (codigoIngresado != codigo){
            
        if (i == 6) break;
            
        System.out.println("Ingrese el código de alarma");
        codigoIngresado = sc.nextInt();
        
        if (i != 5) System.out.println("Código erroneo");
        
        i = i+1;
        
        
        }
        
        if (codigoIngresado != codigo){
        
        System.out.println("Usted a tenido "+i+" intentos erroneos, tendrá que esperar 01:00 hora para volver a intentarlo");
        
        }
        
        if (codigoIngresado == codigo){
            System.out.println("Alarma desactivada");
            
            System.out.println("Usted ha hecho "+i+" intentos para desactivar la alarma, le recomendamos anotar el código");
            
        }
        
        
    }
    
}
