/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class Soldado implements Runnable {

    private Comedor comedor;
    private int nroSoldado;

    // Memoria para recordar que decidio en cada mostrador de almuerzo que haya visitado
    private Map<Integer, Integer> memoriaA;

    // Memoria para recordar que decidio en cada mostrador de postre que haya visitado
    private Map<Integer, Integer> memoriaP;

    private int nroA; // Nro del mostrador de almuerzo que visitara

    // Preferencias del soldado
    private final boolean quierePostre;
    private final boolean tomaGaseosa;

    private boolean tieneComida = false;
    private boolean tienePostre = false;
    private boolean tieneGaseosa = false;

    public Soldado(Comedor c, boolean g, boolean p, int nro) {

        comedor = c;
        tomaGaseosa = g;
        quierePostre = p;
        nroSoldado = nro;
        int cantA = comedor.getCantMostradoresA();
        int cantP = comedor.getCantMostradoresP();
        memoriaA = new HashMap<>();
        memoriaP = new HashMap<>();

        for (int i = 0; i < cantA; i++) {
            // Asigno el valor -1 porque aun no visito tal comedor 
            memoriaA.put(i, -1);
        }

        for (int i = 0; i < cantP; i++) {
            // Asigno el valor -1 porque aun no visito tal comedor 
            memoriaP.put(i, -1);
        }
    }

    public void run() {

        try {
            
            buscaComida();
            
            if (quierePostre) {
                buscaPostre();
            }

            if (tieneGaseosa) {

                System.out.println("Soldado " + nroSoldado + " busca abridor.");

                comedor.agarrarAbridor();

                abreGaseosa();

                comedor.dejarAbridor();
            }
            
            comiendo();           
        } catch (InterruptedException ex) {
            Logger.getLogger(Soldado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agarraBandeja() throws InterruptedException {
        Thread.sleep(1000);
    }

    public void abreGaseosa() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Soldado " + nroSoldado + " abrio su gaseosa.");
    }

    public void comiendo() throws InterruptedException {

        Thread.sleep(5000);

        if (tienePostre) {
            Thread.sleep(2000);
        }

        review();
    }
    
    
    public void review(){
        String opinion;
                
        if(tomaGaseosa){
            if(tieneGaseosa){
                opinion="El soldado "+nroSoldado+" pudo tomar gaseosa.";
            }
            else{
                opinion="El soldado "+nroSoldado+" queria gaseosa pero tomo agua.";
            }
        }
        else{
            if(!tieneGaseosa){
                opinion="El soldado "+nroSoldado+" pudo tomar agua.";
            }
            else{
                opinion="El soldado "+nroSoldado+" queria agua pero tomo agua.";
            }
        }
        
        if(quierePostre){
            if (tienePostre) {
                opinion+=" Pudo comer postre.";
            }
            else{
                opinion+=" No pudo comer postre porque no quedo.";
            }
        }
        else{
            opinion+=" No quiso postre.";
        }
        
        System.out.println(opinion);
    }
    
    
    public void buscaComida() {
        
        System.out.println("El soldado " + nroSoldado + " busca comida.");
        
        boolean recorrioTodos = false;

        while (tieneComida == false) {

            try {

                nroA = comedor.menorColaA(memoriaA, recorrioTodos);

                /* Reemplazo por 4 (esta visitando), porque si solo le queda un mostrador por recorrer,
                debe tener recorrioTodos en true, y llevarse la comida con bebida aunque no sea su preferida*/
                memoriaA.replace(nroA, 4);

                if (!memoriaA.containsValue(-1)) {
                    recorrioTodos = true;
                }

                int decision = comedor.llegaMostradorAlmuerzo(nroA, tomaGaseosa);

                if (decision == 2) {
                    tieneComida = true;
                    tieneGaseosa = tomaGaseosa;
                    agarraBandeja();
                } else if (recorrioTodos && decision == 1) {
                    tieneComida = true;
                    tieneGaseosa = !tomaGaseosa;
                    agarraBandeja();                    
                } else {
                    memoriaA.replace(nroA, decision);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Soldado.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            comedor.saleMostradorAlmuerzo(nroA);
        }      
    }

    
    public void buscaPostre() throws InterruptedException {
        
        int nroP;
        boolean recorrioTodos = false;
        
        while (tienePostre == false && recorrioTodos == false) {

            try {
                nroP = comedor.menorColaP(memoriaP);

                int decision = comedor.llegaMostradorPostre(nroP);
                
                if (decision == 1) {
                    tienePostre = true;
                    Thread.sleep(1000);
                } else {
                    memoriaP.replace(nroP, decision);
                }
                
                comedor.saleMostradorPostre(nroP);
                
                if (!memoriaP.containsValue(-1)) {
                    recorrioTodos = true;
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Soldado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
