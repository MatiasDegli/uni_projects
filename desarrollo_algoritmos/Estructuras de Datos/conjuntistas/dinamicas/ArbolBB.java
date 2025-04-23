/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas.dinamicas;

import lineales.dinamicas.Lista;

/**
 *
 * @author Zambon
 */
public class ArbolBB {
    
    private NodoABB raiz;
    
    
    public ArbolBB(){
        raiz=null;
    }
    
    
    public boolean pertenece(Comparable elem){
        
        NodoABB nodo = obtenerNodo(raiz, elem);
        
        return nodo!=null;
    }
    
    
    private NodoABB obtenerNodo(NodoABB nodo, Comparable elem){
        
        NodoABB resultado = null;
        
        if(nodo!=null){
            if(nodo.getElem().equals(elem)){
                resultado = nodo;
            }
            else{
                resultado=obtenerNodo(nodo.getIzquierdo(), elem);
                if(resultado==null){
                    resultado=obtenerNodo(nodo.getDerecho(),elem);
                }
            }
        }
        
        return resultado;
    }
    
    
    public boolean insertar(Comparable elem){
        boolean exito=true;
        
        if(raiz==null){
           raiz = new NodoABB(elem, null, null);
        }
        else{
            exito = insertarAux(raiz, elem);
        }
        
        return exito;
    }
    
    
    private boolean insertarAux(NodoABB nodo, Comparable elem){
        boolean exito=true;
        
        if(elem.compareTo(nodo.getElem())==0){
            //el elemento esta repetido
            exito=false;
        }
        else if(elem.compareTo(nodo.getElem())<0){
            //el elem es menor
            if(nodo.getIzquierdo()!=null){
                exito=insertarAux(nodo.getIzquierdo(), elem);
            }
            else{
                nodo.setIzquierdo(new NodoABB(elem, null, null));
            }
        }
        else if(elem.compareTo(nodo.getElem())>0){
            //el elem es mayor
            if(nodo.getDerecho()!=null){
                exito=insertarAux(nodo.getDerecho(), elem);
            }
            else{
                nodo.setDerecho(new NodoABB(elem, null, null));
            }
        }
            
        return exito;
    }
    
    public boolean eliminar(Comparable elemento){
        boolean resultado;
        
        resultado = eliminarAux(this.raiz, null, elemento);
        
        return resultado;
    }
    
    private boolean eliminarAux(NodoABB n, NodoABB padre, Comparable elemento){
        boolean exito = false;
        if(n != null){
            
            if((elemento.compareTo(n.getElem())) == 0){
                
                if(n.getIzquierdo() == null && n.getDerecho() == null){
                    //si n no tiene hijos
                    sinHijo(padre, elemento);
                    exito = true;
                    
                }
                else if((n.getIzquierdo() != null ^ n.getDerecho() != null)){
                    //si n tiene un hijo
                    unHijo(n, padre, elemento);
                    exito = true;
                }
                else{
                    //si n tiene dos hijos
                    dosHijos(n);
                    exito = true;
                 }
            }
            else{
                if(elemento.compareTo(n.getElem())<0){
                    eliminarAux(n.getIzquierdo(), n, elemento);
                }
                if(elemento.compareTo(n.getElem())>0){
                    eliminarAux(n.getDerecho(), n, elemento);
                }
            }
        }
        
        return exito;
    }
    
    
    private void sinHijo(NodoABB padre, Comparable elemento){
        //si no tiene hijos
        if(padre == null){
            //caso especial, es la raiz
            this.raiz = null;
        }
        else{
            if(padre.getIzquierdo().getElem().compareTo(elemento) == 0){
                //si n es el HI de padre
                padre.setIzquierdo(null);
            }
            else{
                //si n es HD de padre
                padre.setDerecho(null);
            }
        }
    }
    
    
    private void unHijo(NodoABB n, NodoABB padre, Comparable elemento){
        
        if(n.getIzquierdo() != null){
            //si n tiene HI
            if(padre == null){
                // caso especial es la raiz
                this.raiz.setIzquierdo(n.getIzquierdo());
            }
            else{
                if(padre.getIzquierdo().getElem().compareTo(elemento) == 0){
                     //si n es el HI de padre
                    padre.setIzquierdo(n.getIzquierdo());
                }
                else{
                     //si n es el HD de padre
                    padre.setDerecho(n.getIzquierdo());
                }
            }
        }
        if(n.getDerecho() != null){
            //si n tiene HD
            if(padre == null){
                // caso especial si es raiz
                this.raiz.setDerecho(n.getDerecho());
            }
            else{
                if(padre.getIzquierdo().getElem().compareTo(elemento) == 0){
                    //si n es el HI de padre
                    padre.setIzquierdo(n.getDerecho());
                }
                else{
                    //si n es el HD de padre
                    padre.setDerecho(n.getDerecho());
                }
            }
        }
    }
    
    
    private void dosHijos(NodoABB n){
        
        // si n tiene AMBOS hijos
        NodoABB aux = n.getIzquierdo(); //tambien podria ser derecho
        if(aux.getDerecho()!=null){
            //si HI del nodo a eliminar tiene descendientes
            while(aux.getDerecho().getDerecho()!=null){ //seria izquierdo si antes optabamos por derecho
                aux = aux.getDerecho();
            } 
            n.setElem(aux.getDerecho().getElem()); //seteo el elemento del candidato a n
            if(aux.getDerecho().getIzquierdo()!=null){
                // si el candidato tiene HI
                aux.setDerecho(aux.getDerecho().getIzquierdo());
            }else{
                // si el candidato no tiene HI
                aux.setDerecho(null);

            }
        }else{
            //si HI del nodo a eliminar es el candidato
            n.setElem(aux.getElem());
            //como candidato no tiene HD
            //si no tuviera HI, de igual manera se setea a nulo          
            n.setIzquierdo(aux.getIzquierdo());

        }
        
    }
    
    
    public Comparable minimoElem(){
        NodoABB min=raiz;
        Comparable elem;
        
        if(min!=null){
            while(min.getIzquierdo()!=null){
                min=min.getIzquierdo();
            }
            elem = min.getElem();
        }
        else elem=null;
        
        return elem;
    }
    
    
    public Comparable maximoElem(){
        NodoABB max=raiz;
        Comparable elem;
        
        if(max!=null){
            while(max.getDerecho()!=null){
                max=max.getIzquierdo();
            }
            elem = max.getElem();
        }
        else elem=null;
        
        return elem;
    }
    
    
    private NodoABB obtenerPadre(NodoABB nodo, Comparable elem){
        
        NodoABB padre = null;
        
        if(nodo.getDerecho()!=null && nodo.getIzquierdo()!=null){
            if(nodo.getDerecho().getElem().equals(elem) || nodo.getIzquierdo().getElem().equals(elem)){
                padre = nodo;
            }
            else{
                padre=obtenerNodo(nodo.getIzquierdo(), elem);
                if(padre==null){
                    padre=obtenerNodo(nodo.getDerecho(),elem);
                }
            }
        }
        else if(nodo.getIzquierdo()!=null){
            if(nodo.getIzquierdo().getElem().equals(elem)){
                padre=nodo;
            }
            else padre=obtenerNodo(nodo.getIzquierdo(), elem);
        }
        else if(nodo.getDerecho()!=null){
            if(nodo.getDerecho().getElem().equals(elem)){
                padre=nodo;
            }
            else padre=obtenerNodo(nodo.getDerecho(), elem);
        }
        
        return padre;
    }
    
    
    public Lista listar(){
        Lista l = new Lista();
        
        l=listarAux(raiz, l);
        
        return l;
    }
    
    
    private Lista listarAux(NodoABB n, Lista l){

        if(n!=null){
            l=listarAux(n.getIzquierdo(), l);
            l.insertar(n.getElem(), l.longitud()-1);
            if(l.localizar(n.getElem())==-1){
                l=listarAux(n, l);
                l.insertar(n.getElem(), l.longitud()-1);
                
            }
        }
        
        return l;
    }
    
    
    public Lista listarRango(Comparable min, Comparable max){
        Lista l = new Lista();
        
        //l=listarRangoAux(raiz, l);
        
        return l;
    }
    
    
    public boolean esVacio(){
        return raiz==null;
    }
    
    
    public ArbolBB clone(){
        ArbolBB clon = new ArbolBB();
        if(raiz != null){
            clon.raiz = new NodoABB(raiz.getElem(), null, null);
            auxClone(raiz, clon.raiz);
        }
        return clon;
    }

    
    private void auxClone(NodoABB nodo1,NodoABB nodo2) {
    //Entran dos nodo, un nodo raiz, y una copia de la raiz
    if (nodo1 != null && nodo2 != null) {
        //SI ambos son distintos de nulos, entonces:
        if (nodo1.getIzquierdo() != null) {
            //Al nodo copia de la raiz, se le asigna a su hijo izquierdo(que se inicializo en el publico con null) 
            // un nuevo nodo con el hijo izquierdo del nodo raiz original
           nodo2.setIzquierdo(new NodoABB(nodo1.getIzquierdo().getElem(),null,null));
        }
        if (nodo1.getDerecho()!= null) {
            nodo2.setDerecho(new NodoABB(nodo1.getDerecho().getElem(),null,null));
        }
         //Hace el llamado recursivo pero con los dos hijos izquierdo, del original y de la copia
         //los cuales ya son distintos de nulos.
         auxClone(nodo1.getIzquierdo(),nodo2.getIzquierdo());
         auxClone(nodo1.getDerecho(),nodo2.getDerecho());

        }
    }
    
    
    public String toString(){
        String mensaje="";
        NodoABB aux=raiz;
        
        mensaje = toStringAux(aux);
                
        return mensaje;
    }
    
    
    private String toStringAux(NodoABB nodo){
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



/*public boolean eliminar(Comparable elem){
        boolean exito;
           
        exito=eliminarAux(raiz, elem);
        
        return exito;
    }
    
    
    private boolean eliminarAux(NodoABB eliminar, Comparable elem){
        boolean exito=false;
        NodoABB padre = null;
        
        if(eliminar!=null){
            if(elem.compareTo(eliminar.getIzquierdo().getElem())==0 || 
                    elem.compareTo(eliminar.getDerecho().getElem())==0){

                padre = eliminar;
                if(padre.getIzquierdo().getElem().equals(elem)){
                    eliminar=padre.getIzquierdo();
                }
                else eliminar=padre.getDerecho();
            }
            if(elem.compareTo(eliminar.getElem())==0){

                if(eliminar.getDerecho()==null && eliminar.getIzquierdo()==null){
                    //no tiene hijos
                    if(padre==null){
                        //es la raiz, sin hijos
                        eliminar.setElem(null);
                        exito=true;
                    }
                    else{
                        exito=sinHijo(padre, eliminar);
                    }
                }
                else if(eliminar.getIzquierdo()!=null && eliminar.getDerecho()!=null){
                    //tiene dos hijos
                    exito = dosHijos(eliminar);
                }
                else{
                    if(padre!=null){
                        exito=unHijo(padre, eliminar);
                    }
                    else{
                        if(raiz.getIzquierdo()!=null){
                            eliminar.setElem(eliminar.getIzquierdo().getElem());
                            if(eliminar.getIzquierdo().getDerecho()!=null){
                                eliminar.setDerecho(eliminar.getIzquierdo().getDerecho());
                                eliminar.setIzquierdo(eliminar.getIzquierdo().getIzquierdo());
                            }
                        }
                    }
                }
            }
            else{
                //elem no se encuentra
                exito=false;
                //llamada recursiva 
                if(exito==false){
                    exito=eliminarAux(eliminar.getIzquierdo(), elem);
                    if(exito==false){
                        exito=eliminarAux(eliminar.getDerecho(), elem);
                    }
                }
            }
        }
        
        return exito;
    }
    
    
    private boolean sinHijo(NodoABB padre, NodoABB eliminar){
        boolean exito;
        
        if(padre.getIzquierdo().getElem()==eliminar.getElem()){
                padre.setIzquierdo(null);
                exito=true;
            }
            else{
                padre.setDerecho(null);
                exito=true;
            }
        
        return exito;
    }
    
    
    private boolean unHijo(NodoABB padre, NodoABB eliminar){
        boolean exito;
        
        if(eliminar.getIzquierdo()!=null){
            //tiene un solo hijo, es izq
            if(padre.getIzquierdo().getElem()==eliminar.getElem()){
                padre.setIzquierdo(eliminar.getIzquierdo());
                exito=true;
            }
            else{
                padre.setDerecho(eliminar.getIzquierdo());
                exito=true;
            }
        }
        else{
            //tiene un solo hijo, es der
            if(padre.getIzquierdo().getElem()==eliminar.getElem()){
                padre.setIzquierdo(eliminar.getDerecho());
                exito=true;
            }
            else{
                padre.setDerecho(eliminar.getDerecho());
                exito=true;
            }
        }
        
        return exito;
    }
    
    
    private boolean dosHijos(NodoABB nodo){
        boolean exito=true;
        NodoABB candidatoB = nodo.getDerecho();
        
        if(candidatoB.getIzquierdo()==null){
            //candidatoB no tiene hijos izq
            nodo.setElem(candidatoB.getElem());
            nodo.setDerecho(candidatoB.getDerecho());
        }
        else{
            //candidatoB tiene hijo izq
            while(candidatoB.getIzquierdo()!=null){
                candidatoB=candidatoB.getIzquierdo();
            }
            if(candidatoB.getDerecho()!=null){
                NodoABB padreAux = obtenerPadre(raiz, candidatoB.getElem());
                padreAux.setIzquierdo(candidatoB.getDerecho());
            }
            nodo.setElem(candidatoB.getElem());
        }
        
        return exito;
    }*/
