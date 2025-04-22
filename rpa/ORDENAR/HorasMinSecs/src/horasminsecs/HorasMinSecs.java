/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horasminsecs;

/**
 *
 * @author Zambon
 */

import java.util.Scanner;

public class HorasMinSecs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       int segs, min, minTotal, horas, segsTotal;
       
       
       Scanner sc = new Scanner(System.in);
       
       System.out.println("ingrese la cantidad de segundos");
       segsTotal = sc.nextInt();
       segs = segsTotal%60;
       minTotal = segsTotal / 60;
       horas = minTotal / 60;
       min = minTotal%60;
       
       System.out.println("");
       System.out.println("equivalen a:" + min);
       System.out.println("equivalen a:" + segs);
       
       
       
     
        
        
        
        
    }
    
}
