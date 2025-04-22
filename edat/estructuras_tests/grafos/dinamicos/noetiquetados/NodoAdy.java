/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.dinamicos.noetiquetados;

/**
 *
 * @author matia
 */
public class NodoAdy {
    
    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    
    
    public NodoAdy(NodoVert vert, NodoAdy ady){
        vertice=vert;
        sigAdyacente=ady;
    }
    
    public NodoVert getVertice(){
        return vertice;
    }
    
    
    public void setVertice(NodoVert vert){
        vertice = vert;
    }
    
    
    public NodoAdy getSigAdyacente(){
        return sigAdyacente;
    }
    
    
    public void setSigAdyacente(NodoAdy ady){
        sigAdyacente=ady;
    }
    
    
}
