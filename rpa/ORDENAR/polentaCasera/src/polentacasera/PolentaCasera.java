/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polentacasera;

/**
 *
 * @author Zambon
 */

import java.util.Scanner;

public class PolentaCasera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        double taza, cubitoCal, tazaPol, porcionPol;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de porciones de polenta");
        porcionPol = sc.nextInt();
        taza = porcionPol * 3/4;
        cubitoCal = porcionPol / 2;
        tazaPol = porcionPol / 4;
        
        if (porcionPol > 1) System.out.println("Para preparar"+porcionPol+ "porciones de polenta, en una olla se lleva a hervir" +taza+"tazas de agua y se disuelve ahí" 
                +cubitoCal+ "cubitos de caldo. Se agrega" +tazaPol+ "tazas de polenta y se revuelve constantemente durante 1 minuto a fuego medio");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
