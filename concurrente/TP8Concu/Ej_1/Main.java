/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

/**
 *
 * @author matia
 */


public class Main {

    public static void main(String[] args) {
        
        // Configuración de mostradores de almuerzo y postre
        int mostradoresA = 3; // Número de mostradores de almuerzo
        int mostradoresP = 2;   // Número de mostradores de postre
        
        // Creación del comedor
        Comedor comedor = new Comedor(mostradoresA, mostradoresP);
        
        // Número de soldados
        int cantSoldados = 100;
        
        // Creación y ejecución de hilos para cada soldado
        Thread[] soldados = new Thread[cantSoldados];
        
        for (int i = 0; i < cantSoldados; i++) {
            
            boolean quiereGaseosa=false; 
            boolean quierePostre=false;   
            
            if(Math.random()>0.25){
                // Alternar preferencia de bebida
               quiereGaseosa=true;
            }
            
            if(Math.random()>0.39){
                // Alternar preferencia de postre
                quierePostre=true;
            }
            
            Soldado soldado = new Soldado(comedor, quiereGaseosa, quierePostre, i);
            soldados[i] = new Thread(soldado);
            soldados[i].start();
        }

        // Espera a que todos los hilos de soldados terminen su ejecución
        for (int i = 0; i < cantSoldados; i++) {
            try {
                soldados[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Todos los soldados han terminado de comer.");
    }
}
