/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lineales.estaticas;

/**
 *
 * @author Zambon
 */
public class Pila {
    
    private static final int TAMANIO=10;
    private int tope;
    private Object[] arreglo;
    
    
    public Pila(){
        this.tope = -1;
        this.arreglo = new Object[TAMANIO]; 
    }
    
    
    public boolean apilar(Object newElem){
        boolean exito=false;
        
        if(tope<TAMANIO-1){
            exito=true;
            tope++;
            arreglo[tope]=newElem;
        }
        
        return exito;
    }
    
    
    public boolean desapilar(){
        boolean exito=false;
        
        if(!esVacia()){
            arreglo[tope]=null;
            tope--;
        }
        
        return exito;
    }
    
    
    public boolean esVacia(){
        return tope==-1;
    }
    
    
    public void vaciar(){
        if(!esVacia()){
            while(arreglo!=null){
                arreglo[tope]=null;
            }
        }
    }
    
    
    public Object obtenerTope(){
        Object elem=null;
        if(!esVacia()) elem=arreglo[tope];
        return elem;
    }
    
    
    public Pila clone(){
        Pila clon = new Pila();
        Object[] aux = arreglo;
        int i=0;
        
        while(i<TAMANIO){
            clon.arreglo[i]=aux[i];
            i++;
        }
        
        return clon;
    }
    
    
    public String toString(){
        String mensaje="";
        int i=0;
        if(!esVacia()){
            while(i<=tope){
                mensaje+=arreglo[i].toString();
                i++;
            }
        }
        return mensaje;
    }
    
}

