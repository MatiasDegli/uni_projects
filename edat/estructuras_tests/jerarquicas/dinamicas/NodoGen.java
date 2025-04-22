/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas.dinamicas;

/**
 *
 * @author matia
 */
public class NodoGen {
    
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    
    public NodoGen(Object el, NodoGen hijoI, NodoGen hermanoD){
        elem=el;
        hijoIzquierdo=hijoI;
        hermanoDerecho=hermanoD;
    }
    
    
    public Object getElem(){
        return elem;
    }
    
    
    public NodoGen getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    
    
    public NodoGen getHermanoDerecho(){
        return hermanoDerecho;
    }
    
    
    public void setElem(Object el){
        elem=el;
    }
    
    
    public void setHijoIzquierdo(NodoGen hijoI){
        hijoIzquierdo=hijoI;
    }
    
    
    public void setHermanoDerecho(NodoGen hermanoD){
        hermanoDerecho=hermanoD;
    }
    
}
