/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.dinamicos.noetiquetados;

import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class GrafoNoEtiquetado {
    
    
    private NodoVert inicio;
    
    
    public GrafoNoEtiquetado(){
        inicio = null;
    }
    
    
    public boolean insertarVertice(Object nuevoVertice){
        boolean exito=false;
        
        NodoVert aux = ubicarVertice(nuevoVertice);
        
        if(aux==null){
            inicio = new NodoVert(nuevoVertice, inicio);
            exito = true;
        }
        
        return exito;
    }
    
    
    private NodoVert ubicarVertice(Object buscado){
        NodoVert aux = inicio;
        
        while(aux!=null && !aux.getElem().equals(buscado)){
            aux=aux.getSigVertice();
        }
        
        return aux;
    }
    
    
    public boolean eliminarVertice(Object vertice){        
        NodoVert buscado = ubicarVertice(vertice);
        
        if(buscado!=null){
            eliminarAdyacencias(inicio, buscado);
        }
        
        return buscado!=null;
    }
    
    
    private void eliminarAdyacencias(NodoVert recorre, NodoVert buscado){
        
        if(recorre!=null){
            
            NodoAdy adyacente = recorre.getPrimerAdy();
            NodoAdy anterior = null;
            
            while(adyacente!=null && adyacente.getVertice()!=buscado){                
                anterior = adyacente;             
                adyacente = adyacente.getSigAdyacente();                
            }
            
            if(adyacente!=null && adyacente==recorre.getPrimerAdy()){
                recorre.setPrimerAdy(adyacente.getSigAdyacente());
            }
            else if(adyacente!=null && adyacente.getVertice()==buscado){
                anterior.setSigAdyacente(adyacente.getSigAdyacente());
            }
            
            eliminarAdyacencias(recorre.getSigVertice(), buscado);
        }        
    }
    
    
    public boolean existeVertice(Object vertice){
        boolean exito=false;
        
        NodoVert recorre = inicio;
        
        while(recorre!=null && recorre.getElem().equals(vertice)){
                recorre=recorre.getSigVertice();             
        }
        
        if(recorre!=null){
            exito=true;
        }
        
        return exito;
    }
    
    
    public boolean insertarArco(Object elemOrigen, Object elemDestino){
        boolean exito=false;
        
        NodoVert recorre=inicio, origen=null, destino;        
        
        while(recorre!=null && !recorre.getElem().equals(elemDestino)){
            
            if(recorre.getElem().equals(elemOrigen)){
                origen=recorre;
            }
            
            recorre=recorre.getSigVertice();
        }
        
        destino = recorre;
        
        if(elemOrigen.equals(elemDestino)){
            origen=destino;
        }
        
        if(origen!=null && destino!=null){
            exito=arcoAux(origen, destino);
        }
        
        return exito;
    }
    
    
    private boolean arcoAux(NodoVert origen, NodoVert destino){
        boolean exito=true;
        
        if(origen.getPrimerAdy()==null){
            origen.setPrimerAdy(new NodoAdy(destino, null));
        }
        else{
            NodoAdy adyacente=origen.getPrimerAdy();
            
            while(adyacente.getSigAdyacente()!=null && exito==true){
                if(adyacente.getVertice()==destino){
                    exito=false;
                }
                
                adyacente=adyacente.getSigAdyacente();
            }
            
            if(exito==true){
                adyacente.setSigAdyacente(new NodoAdy(destino, null));
            }
        }
        
        return exito;
    }


    public boolean eliminarArco(Object elemOrigen, Object elemDestino){
        boolean exito = false;
        
        NodoVert recorre = inicio;
        NodoAdy adyacente = null;
        NodoAdy anterior = null;
        
        while(recorre!=null && recorre.getElem().equals(elemOrigen)){
            recorre=recorre.getSigVertice();
        }
        
        NodoVert origen = recorre;
        
        if(origen!=null){
            adyacente = origen.getPrimerAdy();
        
            while(adyacente!=null && adyacente.getVertice().getElem()!=elemDestino){
                anterior=adyacente;
                adyacente=adyacente.getSigAdyacente();
            }
        
            if(adyacente==origen.getPrimerAdy()){
                origen.setPrimerAdy(adyacente.getSigAdyacente());
            }
            else if(adyacente!=null){
                anterior.setSigAdyacente(adyacente.getSigAdyacente());
            }  
        }
        
        return exito;
    }
    
    
    public boolean existeArco(Object elemOrigen, Object elemDestino){
        boolean exito=false;
        
        NodoVert origen = ubicarVertice(elemOrigen);
        
        if(origen!=null){
            NodoAdy adyacente=origen.getPrimerAdy();
            
            while(adyacente!=null && !adyacente.getVertice().getElem().equals(elemDestino)){
                adyacente=adyacente.getSigAdyacente();
            }
            
            if(adyacente!=null){
                //recorrio la lista de adyacencia hasta que encontró el vertice destino
                exito=true;
            }
        }
        
        return exito;
    }
    
    
    public boolean existeCamino(Object elemOrigen, Object elemDestino){
        boolean exito = false;
        
        NodoVert origen = ubicarVertice(elemOrigen);
        
        if(origen!=null){
            
            NodoAdy adyacente = origen.getPrimerAdy();
            
            Lista recorridos = new Lista();
            
            recorridos.insertar(recorridos.longitud()+1, elemOrigen);
            
            exito=caminoAux(false, recorridos, elemDestino, adyacente);
            
        }
        
        return exito;
    }
    
    
    private boolean caminoAux(boolean exito, Lista recorridos, Object elemDestino, NodoAdy adyacente){
        
        if(adyacente!=null && exito==false){
            
            NodoVert proximo = adyacente.getVertice();
            
            if(proximo.getElem().equals(elemDestino)){
                exito=true;
            }
            else if(recorridos.localizar(proximo.getElem())==-1){
                recorridos.insertar(recorridos.longitud()+1, adyacente.getVertice().getElem());
                exito=caminoAux(exito, recorridos, elemDestino, proximo.getPrimerAdy());
            }
            
            if(exito==false){
                exito=caminoAux(exito, recorridos, elemDestino, adyacente.getSigAdyacente());
            }   
        }
        
        return exito;
    }
    
    
    
}
