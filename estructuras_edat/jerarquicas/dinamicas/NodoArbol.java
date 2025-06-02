/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas.dinamicas;

/**
 *
 * @author matia
 */
public class NodoArbol {
    
    
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    
    public NodoArbol(Object el, NodoArbol izq, NodoArbol der){
        elem = el;
        izquierdo = izq;
        derecho = der;
    }
    
    
    public Object getElem(){
        return elem;
    }
    
    
    public NodoArbol getIzquierdo(){
        return izquierdo;
    }
    
    
    public NodoArbol getDerecho(){
        return derecho;
    }
    
    
    public void setElem(Object el){
        elem=el;
    }
    
    
    public void setIzquierdo(NodoArbol izq){
        izquierdo=izq;
    }
    
    
    public void setDerecho(NodoArbol der){
        derecho=der;
    }
    
}
