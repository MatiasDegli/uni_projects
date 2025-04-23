/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas.dinamicas;
import lineales.dinamicas.Lista;

/**
 *
 * @author User
 */
public class ArbolBin {
    
    
    private NodoArbol raiz;
    
    
    public ArbolBin(){
        raiz=null;
    }
    
    
    public boolean insertar(Object newElem, Object elemPadre, char lugar){
        boolean exito=true;
                        
        if(esVacio()==true){
            raiz = new NodoArbol(newElem, null, null);
        }
        else{
            NodoArbol nPadre=obtenerNodo(raiz, elemPadre);
            if(nPadre!=null){
                if(lugar=='I' && nPadre.getIzquierdo()==null){
                    nPadre.setIzquierdo(new NodoArbol(newElem, null, null));
                }
                else if(lugar=='D' && nPadre.getDerecho()==null){
                    nPadre.setDerecho(new NodoArbol(newElem, null, null));
                }
                else exito=false;
            }
        }
        
        return exito;
    }
    
    
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        NodoArbol resultado=null;
        
        if(n!=null){
            if(n.getElem().equals(buscado)){
                resultado=n;
            }
            else{
                resultado=obtenerNodo(n.getIzquierdo(), buscado);
                if(resultado==null){
                    resultado=obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        
        return resultado;
    }
    
    
    public boolean esVacio(){
        return (raiz==null);
    }
    
    
    public int nivel(Object elem){
        int n=-1;
        NodoArbol aux=raiz;

        while(obtenerNodo(aux, elem)!=null){
            if(obtenerNodo(aux.getIzquierdo(), elem)!=null){
                aux=aux.getIzquierdo();
            }
            else aux=aux.getDerecho();
            n++;
        }
        
        return n;
    }
    
    
    public int altura(){
        int n=-1;
        
        
        
        return n;
    }
    
    
    public Object padre(Object buscado){
        Object elemPadre = null;
        NodoArbol aux=raiz;

        while(obtenerNodo(aux, buscado)!=null && elemPadre==null){
            if(obtenerNodo(aux.getIzquierdo(), buscado)!=null){
                if (aux.getIzquierdo().getElem().equals(buscado) || 
                        aux.getDerecho().getElem().equals(buscado)){
                    elemPadre=aux.getElem();
                }
                aux=aux.getIzquierdo();
            }
            else{
                if (aux.getIzquierdo().getElem().equals(buscado) || 
                        aux.getDerecho().getElem().equals(buscado)){
                    elemPadre=aux.getElem();
                }
                aux=aux.getDerecho();
            }
        }
        
        return elemPadre;
    }
    
    
    /*private NodoArbol obtenerPadre(NodoArbol n, Object buscado){
        NodoArbol resultado=null;
        
        if(n!=null){
            if(n.getElem().equals(buscado)){
                resultado=n;
            }
            else{
                resultado=obtenerNodo(n.getIzquierdo(), buscado);
                if(resultado==null){
                    resultado=obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        
        return resultado;
    }*/
    
    
    public Lista listarPreorden(){
        Lista lis = new Lista();
        listarPreordenAux(raiz, lis);
        return lis;
    }
    
    
    private void listarPreordenAux(NodoArbol nodo, Lista lis){
        if(nodo!=null){
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }
    
    
    public Lista listarInorden(){
        Lista lis = new Lista();
        //NodoArbol nodo = raiz;
        //while(nodo.getIzquierdo() != null) nodo = nodo.getIzquierdo();
        listarInordenAux(raiz, lis);
        return lis;
    }
    
    
    private void listarInordenAux(NodoArbol nodo, Lista lis){
        if(nodo!=null){
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
            if(nodo.getIzquierdo()==null || 
                    lis.localizar(nodo.getIzquierdo().getElem()) != 0){
                lis.insertar(nodo.getElem(), lis.longitud()+1);
            }
        }
    }
    
    
    public Lista listarPosorden(){
        Lista lis = new Lista();
        listarPreordenAux(raiz, lis);
        return lis;
    }
    
    
    private void listarPosordenAux(NodoArbol nodo, Lista lis){
        if(nodo!=null){
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }
    
    
    public Lista listarPorNiveles(){
        Lista lis = new Lista();
        listarPreordenAux(raiz, lis);
        return lis;
    }
    
    
    private void listarPorNivelesAux(NodoArbol nodo, Lista lis){
        if(nodo!=null){
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }
    
    
    public void vaciar(){
        raiz=null;
    }
    
    
    public ArbolBin clone(){
        ArbolBin clon = new ArbolBin();  
        NodoArbol aux=raiz;
        
        clonAux(aux, clon.raiz);
        
        return clon;
    }
    
    
    private void clonAux(NodoArbol aux, NodoArbol raizClon){
        if(aux.getIzquierdo()!=null){
            raizClon.setIzquierdo(aux.getIzquierdo());
            clonAux(aux.getIzquierdo(), raizClon.getIzquierdo());
        }
        if(aux.getDerecho()!=null){
            raizClon.setDerecho(aux.getDerecho());
            clonAux(aux.getDerecho(), raizClon.getDerecho());
        }
    }
    
    
    public Lista frontera(){
        Lista l=null;
        
        return l;
    }
    
    
    public String toString(){
        String mensaje="";
        NodoArbol aux=raiz;
        
        mensaje = toStringAux(aux);
                
        return mensaje;
    }
    
    
    private String toStringAux(NodoArbol nodo){
        String mensaje = "";
        if (nodo != null) {
            mensaje =  " \n "+" Nodo:  "+ nodo.getElem() +mensaje + " \n " ;
            if (nodo.getIzquierdo() != null) {
                mensaje = mensaje + (" HI: "+nodo.getIzquierdo().getElem());
            } else {
                mensaje = mensaje +" HI: - " ;
            }
            if (nodo.getDerecho() != null) {
                mensaje = mensaje + (" HD: "+nodo.getDerecho().getElem());
            } else {
                mensaje = mensaje+" HD: - ";
            }
        }
        if(nodo.getIzquierdo()!=null){
            mensaje= mensaje+ toStringAux(nodo.getIzquierdo());
        }
        if(nodo.getDerecho()!=null){
            mensaje= mensaje+ toStringAux(nodo.getDerecho());
        }
        
        return mensaje;
    }
    
}


