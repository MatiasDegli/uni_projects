package Estructuras;

public class Cola {
    
    
    private Nodo frente;
    private Nodo fin;
    
    
    public Cola(){
        frente=null;
        fin=null;
    }
    
    
    public boolean poner(Object newElem){
        Nodo nuevo=new Nodo(newElem, null);
        
        if(frente==null){
            frente=nuevo;
            fin=nuevo;
        }
        else{
            fin.setEnlace(nuevo);
            fin=fin.getEnlace();
        }
        
        return true;
    }
    
    
    public boolean sacar(){
        boolean exito;
        
        if(frente==null){
            exito=false;
        }
        else{
            frente=frente.getEnlace();
            exito=true;
            if(frente==null){
                fin=null;
            }
        }
        
        return exito;
    }
    
    
    public Object obtenerFrente(){
        Object elem;
            
        if(frente==null){
            elem=null;
        }
        else{
            elem=frente.getElem();
        }
        
        return elem;
    }
    
    
    public boolean esVacia(){
        return frente==null;
    }
    
    
    public void vaciar(){
        frente=null;
        fin=null;
    }
    
    
    public Cola clone(){
        Cola clon=new Cola();
        Nodo recorre=frente;
        
        if(frente!=null){
            
            Nodo aux = new Nodo(recorre.getElem(), null);
            clon.frente=aux;
            recorre=recorre.getEnlace();
        
            while(recorre!=null){
                Nodo nuevo = new Nodo(recorre.getElem(), null);
                aux.setEnlace(nuevo);
                aux=aux.getEnlace();
                recorre=recorre.getEnlace();
            }
            fin=aux;
        }
        
        return clon;
    }
    
    
    public Cola generarOtraCola(Cola col){
        Cola mod = new Cola();
        Pila aux = new Pila();
        
        Nodo recorre = col.frente;
        
        while(recorre!=null){
            
            if(!recorre.getElem().equals('$')){
                aux.apilar(recorre.getElem());
                mod.poner(recorre.getElem());
            }
            else{
                while(aux.obtenerTope()!=null){
                    mod.poner(aux.obtenerTope());                  
                    aux.desapilar();
                }
                if(recorre.getEnlace()!=null){
                    mod.poner('$');
                }   
            }
            
            recorre=recorre.getEnlace();
            
            if(recorre==null){
                while(aux.obtenerTope()!=null){
                    mod.poner(aux.obtenerTope());
                    aux.desapilar();
                }
            }
        }
        
        return mod;
    }
    
    
    public String toString(){
        String mensaje="";
        Nodo aux=frente;
        
        while(aux!=null){
            mensaje+=" " + aux.getElem().toString();
            aux=aux.getEnlace();
        }
        
        return mensaje;
    }
    
}
