/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg7.pkg2;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP72 {

    /**
     * @param args the command line arguments
     */
    
    
    public static double transporte (double kg, int distancia){
        
        double costoEnvio;
        
        costoEnvio = (kg * distancia) + 50;
        
    return costoEnvio;}
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        double kg = 1, costoTotal = 0, costoEnvio;  
        int costoDistancia = 0, i = 0;
        char tipoDistancia;
        
        while (kg != 0){
            
        System.out.println("Ingrese el peso de su envío (kg).");
        kg = sc.nextDouble();
        
        if (kg == 0) break;
                
        System.out.println("Ingrese el tipo de envío, 'C' para envíos de corta distancia, 'M' para envíos de media distancia y 'L' para envíos de larga distancia.");
            tipoDistancia = sc.next().charAt(0);
            
            
        switch (tipoDistancia){
            
            case 'C': System.out.println("Corta distancia: 50 pesos por Kg más un seguro de 50 pesos.");
             costoDistancia = 50;
            break;
            
            case 'M': System.out.println(" Media distancia: 75 pesos por Kg más un seguro de 50 pesos.");
             costoDistancia = 75;
            break;
            
            case 'L': System.out.println("Larga distancia: 100 pesos por Kg más un seguro de 50 pesos.");
             costoDistancia = 100;
            break;}
        
        
        costoEnvio = transporte(kg, costoDistancia);
        costoTotal = costoTotal + costoEnvio;
        
        System.out.println("El costo de su envío es de "+costoEnvio+" pesos");
        
        i = i+1;
        
            System.out.println("Para finalizar la carga de datos debe ingresar 0 como peso del envío");
        
            
            
        }
            
        System.out.println("Se procesaron "+i+" envíos y el monto total cobrado fue de "+costoTotal);
        
        
        
    }
    
}
