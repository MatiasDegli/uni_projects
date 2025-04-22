/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

/**
 *
 * @author matia
 */
public class Persona implements Runnable {

    private boolean esJubilado;
    private String nombre;
    private GestorSala gestor;
    
    
    public Persona(boolean esJ, String nom, GestorSala g) {
        esJubilado=esJ;
        nombre=nom;
        gestor=g;
    }
    
    
    public void run() {
        try {
            if (esJubilado) {
                gestor.entrarSalaJubilado();
            } else {
                gestor.entrarSala();
            }
            
            miraCuadros();
            
            gestor.salirSala();
            
        }
        catch(InterruptedException Exc){
            
        }
    }

    
    public void miraCuadros() throws InterruptedException{
        
        System.out.println(nombre+ " esta mirando cuadros.");

        Thread.sleep(10000);
        
        System.out.println(nombre+" se va de la sala.");
    }
    
}
