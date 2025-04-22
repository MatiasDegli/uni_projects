/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas.dinamicas;

/**
 *
 * @author Zambon
 */
class NodoABB {
    
    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;
    
    
    public NodoABB(Comparable el, NodoABB izq, NodoABB der){
        elem=el;
        izquierdo=izq;
        derecho=der;
    }
    
    
    public Comparable getElem(){
        return elem;
    }
    
    
    public void setElem(Comparable el){
        this.elem=el;
    }
    
    
    public NodoABB getIzquierdo(){
        return izquierdo;
    }
    
    
    public NodoABB getDerecho(){
        return derecho;
    }
    
    
    public void setIzquierdo(NodoABB izq){
        izquierdo=izq;
    }
    
    
    public void setDerecho(NodoABB der){
        derecho=der;
    }
    
}

