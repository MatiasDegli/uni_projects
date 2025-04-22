/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class ControladorProduccion implements Runnable{
    
    
    private LineaElectrico lineaE;
    private LineaMecanico lineaM;
    private String lineaActual;
    private static boolean comienzo = false;
    private int cantEnsamblados;
    private int cantEnsamblar;
    
    
    public void setLineas(LineaElectrico e, LineaMecanico m){
        lineaE = e;
        lineaM = m;
    }
    
    
    public void run(){
        
        try {

            while (cantEnsamblados < 100){
                
                while(lineaActual==null){
                    System.out.println("...");
                }
                
                while(lineaActual.equals("Electrico")){
                    lineaE.prepararProducto();
                    Thread.sleep(1000);
                }

                while(lineaActual.equals("Mecanico")){
                    lineaM.prepararProducto();
                    Thread.sleep(1000);
                }
            }
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorProduccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void establecerLimite(){
        cantEnsamblar = (int) (Math.random() * 8) + 3; // Multiplica por 8 para obtener un rango de 0 a 7        
    }
    
    
    public void empiezaEnsamble(){
        comienzo=true;
    }
    
    
    public boolean getComienzo(){
        return comienzo;
    }
    
    
    public void actualizar() throws InterruptedException{
        
        cantEnsamblados++;
        cantEnsamblar--;
        
        if(cantEnsamblar==0){
            
            cambiaLinea();
        }
        
        System.out.println("\nFalta ensamblar "+cantEnsamblar+" productos antes de cambiar de linea.");
        
    }
    
    
    public void primeraLinea(String linea){
        
        System.out.println("\nLa primera linea es: "+linea);
        
        lineaActual = linea;
        
        establecerLimite();
    }
    
    
    public void cambiaLinea() throws InterruptedException{
        
        if(lineaActual.equals("Electrico")){
            lineaActual="Mecanico";
            System.out.println("\nLa linea Electrica se va a pausar y continuara la linea Mecanica.");
        }
        else{
            lineaActual="Electrico";
            System.out.println("\nLa linea Mecanica se va a pausar y continuara la linea Electrica.");
        }
        
        Thread.sleep(4000);
        
        establecerLimite();
        
    }
    
    
}
