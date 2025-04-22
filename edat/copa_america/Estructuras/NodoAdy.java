package Estructuras;

public class NodoAdy {
    
    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    private Object etiqueta;
    
    
    public NodoAdy(NodoVert vert, NodoAdy ady, Object et){
        vertice=vert;
        sigAdyacente=ady;
        etiqueta = et;
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
    
    
    public Object getEtiqueta(){
        return etiqueta;
    }
    
    
    public void setEtiqueta(Object et){
        etiqueta=et;
    }    
    
}
