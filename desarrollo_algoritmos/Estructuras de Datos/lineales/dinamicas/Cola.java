package lineales.dinamicas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Cola {
    
    
    private Nodo frente;
    private Nodo fin;
    
    
    public Cola(){
        frente=null;
        fin=null;
    }
    
    
    public boolean poner(Object newElem){
        boolean exito = true;
        
        Nodo nuevo = new Nodo(newElem, null);
        
        
        if(esVacia()){
            frente = nuevo;
            fin = nuevo;
        }
        else{
            this.fin.setEnlace(nuevo);
            this.fin=nuevo;
        }
        
        return exito;
    }
    
    
    public boolean sacar(){
        boolean exito = false;
        
        if(!esVacia()){
            exito=true;
            frente=frente.getEnlace();
            if(esVacia()){
                fin=frente;
            }
        }
        
        return exito;
    }
    
    
    public boolean esVacia(){
        boolean es=false;
        if(frente==null) es=true;
        return es;
    }
    
    
    public void vaciar(){
        frente=null;
        fin=null;
    }
    
    
    public Object obtenerFrente(){
        Object fr=null;
        if(frente!=null)fr=frente.getElem();
        return fr;
    }
    
    
    public Cola clone(){
        Cola clon = new Cola();
        
        if(!esVacia()){
            
            Nodo aux1 = this.frente;
            Nodo aux2 = new Nodo(frente.getElem(),null);

            clon.frente=aux2;

            while(aux1.getEnlace()!=null){
                aux1=aux1.getEnlace();

                Nodo nuevo = new Nodo(aux1.getElem(), null);

                aux2.setEnlace(nuevo);
                aux2=aux2.getEnlace();
            }

            clon.fin = aux2;
            
        }
        
        return clon;
    }
    
    
    public String toString() {
        String cadena = "[";
        Nodo temp = this.frente;
        while (temp != null) {
            cadena = cadena + temp.getElem() + " ";
            temp = temp.getEnlace();
        }
        cadena = cadena + "]";
        return cadena;
    }
    
}

