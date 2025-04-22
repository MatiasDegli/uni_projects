package Estructuras;

class Nodo {
    
    private Object elem;
    private Nodo enlace;
    
    
    public Nodo(Object el, Nodo nod){
        elem=el;
        enlace=nod;
    }
    
    public Object getElem(){
        return elem;
    }
    
    
    public void setElem(Object el){
        elem=el;
    }
    
    
    public Nodo getEnlace(){
        return enlace;
    }
    
    
    public void setEnlace(Nodo nod){
        enlace=nod;
    }
    
    
}

