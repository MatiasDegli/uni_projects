/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas.dinamicas;

/**
 *
 * @author Zambon
 */
class NodoGen {
    
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    
    public NodoGen(Object el, NodoGen izq, NodoGen der){
        elem=el;
        hijoIzquierdo=izq;
        hermanoDerecho=der;
    }
    
    
    public Object getElem(){
        return elem;
    }
    
    
    public void setElem(Object el){
        this.elem=el;
    }
    
    
    public NodoGen getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    
    
    public NodoGen getHermanoDerecho(){
        return hermanoDerecho;
    }
    
    
    public void setHijoIzquierdo(NodoGen izq){
        hijoIzquierdo=izq;
    }
    
    
    public void setHermanoDerecho(NodoGen der){
        hermanoDerecho=der;
    }
    
}

