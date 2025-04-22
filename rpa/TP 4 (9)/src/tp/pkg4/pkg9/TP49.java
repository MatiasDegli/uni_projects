/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4.pkg9;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP49 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        
        int horas=0, minutos, segundos, segundos2;
        
        System.out.println("Ingrese la cantidad de segundos");
        segundos = sc.nextInt();
        
        segundos2 = segundos%60;
        minutos = segundos / 60;
        
        
        while (minutos >= 60) {
       
            minutos = minutos - 60;
            horas = horas + 1;
        
    }
        
        System.out.println(+segundos+" segundos equivalen a "+horas+" hs "
                +minutos+" mins "+segundos2+" segs");
        
    }
    
}
