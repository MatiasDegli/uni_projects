/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lineales.estaticas;

/**
 *
 * @author User
 */
public class Cola {

    private static final int TAMANIO=10;
    private Object[] arreglo;
    private int frente;
    private int fin;
    
    
    public Cola(){
        
        arreglo = new Object[TAMANIO];
        frente = 0;
        fin = 0;
        
    }

    
    public boolean poner(Object newElem){
        
        boolean exito=false;
        if(!((fin+1)%TAMANIO==frente)){
            arreglo[fin]=newElem;
            fin = (fin+1)%TAMANIO;
            exito=true;
        }
        return exito;
        
    }
    
    
    public boolean esVacia(){
        boolean vacia = false;
        if (fin==frente) vacia=true;
        return vacia;
    }
    
    
    public boolean sacar(){
        boolean exito=false;
        if(!esVacia()){
            arreglo[frente]=null;
            frente = (frente+1)%TAMANIO;
            exito=true;
        }
        return exito;
    }
    
    
    public Object obtenerFrente(){
        return arreglo[frente];
    }
    
    
    public void vaciar(){
        int i=0;
        while(i<fin){
            arreglo[i]=null;
        }
    }
    
    
    public Cola clone(){
        
        Cola clon = new Cola();
        
        int aux=0;
        clon.frente=this.frente;
        clon.fin=this.fin;
        
        while(aux<TAMANIO){
            clon.arreglo=this.arreglo;
            aux++;
        }
        
        return clon;
        
    }
    
    
    public String toString(){
        int aux=0;
        String colita="";
        while (aux<TAMANIO){
            colita += arreglo[aux]+" ";
            aux++;
        }
        return colita;
    }
    
    
}
