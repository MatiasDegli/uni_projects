/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4.pkg3;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP43 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        double porcionPolenta, tazaAgua, cuboCaldo, tazaPolenta;
        
        System.out.println("Ingrese la cantidad de porciones de polenta que desee preparar");
        
        porcionPolenta = sc.nextDouble(); 
        
        tazaAgua = (porcionPolenta / 4) * 3 ;
        cuboCaldo = (porcionPolenta / 4) * 2 ;
        tazaPolenta = porcionPolenta / 4 ;
        
        System.out.println("Para preparar " +porcionPolenta+ " porciones de polenta, se lleva a hervir " +tazaAgua+ 
                " tazas de agua y se disuelve ahí " +cuboCaldo+ " cubitos de caldo. "
                        + "Se agregan " +tazaPolenta+ " tazas de polenta y se revuelve "
                                + "constantemente durante 1 minuto a fuego medio. ¡Listo!");
        
    }
    
}
