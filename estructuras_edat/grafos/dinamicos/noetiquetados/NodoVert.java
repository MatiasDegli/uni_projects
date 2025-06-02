/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.dinamicos.noetiquetados;

/**
 *
 * @author matia
 */
public class NodoVert {
    
    private Object elem;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;
    
    
    public NodoVert(Object el, NodoVert vert){
        elem=el;
        sigVertice = vert;
    }
    
    
    public Object getElem(){
        return elem;
    }
    
    
    public void setElem(Object el){
        elem = el;
    }
    
    
    public NodoVert getSigVertice(){
        return sigVertice;
    }
    
    
    public void setSigVertice(NodoVert vert){
        sigVertice = vert;
    }
    
    
    public NodoAdy getPrimerAdy(){
        return primerAdy;
    }
    
    
    public void setPrimerAdy(NodoAdy ady){
        primerAdy=ady;
    }
    
}
