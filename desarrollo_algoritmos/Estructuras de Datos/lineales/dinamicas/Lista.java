/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.dinamicas;

/**
 *
 * @author Zambon
 */
public class Lista {
    
    
    Nodo cabecera;
    
    
    public Lista(){
        cabecera=null;
    }
    
    
    public boolean insertar(Object newElem, int pos){
        boolean exito = true;
                        
        if(pos < 1 || pos > longitud()+1){    
            exito=false;
        }
        else{
            if(pos==1){
                cabecera= new Nodo (newElem , this.cabecera);
            }
            else{
                Nodo aux = cabecera;
                int i=1; 
                while(i < pos-1){
                    aux=aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(newElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        
        return exito;
    }
    
    
    public boolean eliminar(int pos){
        boolean exito = true;
        
        if (pos < 1 || pos > longitud()){
            exito=false;
        }
        else{
            if (pos == 1) {
                cabecera = cabecera.getEnlace();
            } 
            else{
                Nodo aux = cabecera;
                
                for (int i = 1; i < pos - 1; i++) {
                    aux = aux.getEnlace();
                }
                
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        
        return exito;
    }
    
    
    public int longitud(){
        int longitud = 0;
        Nodo aux = cabecera;
        
        while (aux != null) {
            longitud++;
            aux = aux.getEnlace();
        }
        
        return longitud;
    }
    
    
    public Object recuperar(int pos){
        Object elem=null;
        int i;
        Nodo aux=cabecera;
        
        if(!esVacia()){
            for(i=1;i<=pos;i++){
                if(i==pos){
                    elem = aux.getElem();
                }
                aux=aux.getEnlace();
            }
        }
        
        return elem;
    }
    
    
    public int localizar(Object elem){
        int pos=0;
        int i=1;
        Nodo aux=cabecera;
        
        if(!esVacia()){
            while(aux!=null && pos==0){
                if(aux.getElem()==elem){
                    pos=i;
                }
                i++;
                aux=aux.getEnlace();
            }
        }
        
        return pos;
    }
    
    
    public boolean esVacia(){
        return cabecera==null;
    }
    
    
    public void vaciar(){
        cabecera=null;
    }
    
    
    public Lista clone(){
        Lista clon = new Lista();
        Nodo aux=cabecera;
        
        while(aux!=null){
            aux=aux.getEnlace();
            clon.cabecera=aux;
        }
        clon.cabecera=this.cabecera;
        
        return clon;
    }
    
    
    public String toString(){
        String mensaje = "";
        if (cabecera == null){
            mensaje = "lista vacia";
        } else {
            mensaje = "[";
            Nodo aux = cabecera;
            while (aux != null){
                mensaje += aux.getElem() + ", ";
                aux = aux.getEnlace();
            }
            mensaje += "]";
        }
        return mensaje;
    }
    
}
