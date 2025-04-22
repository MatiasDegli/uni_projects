package Estructuras;

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
    
    @Override
    public boolean equals(Object obj) {
        NodoVert otro = (NodoVert) obj;  
        return this.elem == otro.elem;
    }

}
