/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lineales.dinamicas;

/**
 *
 * @author User
 */
public class Pila {
    
    private Nodo tope;
    
    
    public Pila(){
        this.tope=null;
    }
    
    
    public boolean apilar(Object newElem){
        Nodo newNodo = new Nodo(newElem, this.tope);
        
        this.tope = newNodo;
        
        return true;
    }
    
    
    public boolean desapilar(){
        boolean exito=true;
        Nodo newNodo;
        
        if(tope!=null){
            newNodo = tope.getEnlace();
            tope = newNodo;
        }
        
        else{
            exito=false;
        }
        
        return exito;
    }
    
    
    public Object obtenerTope(){
        return tope.getElem();
    }
    
    
    public boolean esVacia(){
        boolean vacia=true;
        
        if(tope!=null) vacia=false;
        
        return vacia;
    }
    
    
    public void vaciar(){
        tope=null;
    }
    
    
    public Pila clone(){
        Pila clon = new Pila();
        Nodo aux=tope;
        
        while (aux!=null){
            clon.tope = new Nodo (tope.getElem(), (Nodo)tope.getEnlace());
            aux = (Nodo) aux.getEnlace();
            
        }
        
        return clon;
    }
    
    
    public String toString(){
        String s="";
        
        if(tope == null){
            s=null;
        }
        else{
            Nodo aux=tope;
            s+="[";
            while (aux != null){
                s+=aux.getElem().toString();
                aux=(tope.getEnlace());
                if(aux!=null){
                    s+=", ";
                    if(s!=null){
                        
                    }
                }
            }
            s+="]";
        }
        
        return s;
    }
    
}
