/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jerarquicas.dinamicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class ArbolBin {
    

    private NodoArbol raiz;
    
    
    public ArbolBin(){
        raiz=null;
    }
    
    
    public boolean insertar(Object elemPadre, Object newElem, char posHijo){
        boolean exito=true;
        NodoArbol aux;
        posHijo=Character.toLowerCase(posHijo);
        
        if(posHijo != 'i' && posHijo != 'd'){
            
            /*revisa el caracter ingresado, debe ser i, I, d o D, 
            sino retorna false*/
            
            exito=false;
        }
        else if(raiz==null){
            
            /*si el arbol esta vacio, ingresa el nuevo 
            elemento directamente en la raiz*/
            
            raiz=new NodoArbol(newElem, null, null);
            exito=true;
        }
        else{
            
            /*busca el nodo padre con su elemento en un metodo recursivo*/
            
            aux = obtenerNodo(elemPadre, raiz);
            
            if(aux==null){
                
                /*el arbol no tiene ningun nodo con el elemento ingresado*/
                
                exito=false;
            }
            else{
                
                /*revisa la posicion ingresada, si el nodo en la pos 
                ingresada esta ocupado, exito queda en false*/
                
                if(posHijo=='i' && aux.getIzquierdo()==null){
                    aux.setIzquierdo(new NodoArbol(newElem, null, null));
                    exito=true;
                }
                else if(posHijo=='d' && aux.getDerecho()==null){
                    aux.setDerecho(new NodoArbol(newElem, null, null));
                    exito=true;
                }
            }
        }
        
        return exito;
    }
        
    
    private NodoArbol obtenerNodo(Object elem, NodoArbol aux){
        NodoArbol recorre=null;
        
        if(aux!=null){
            
            if(aux.getElem().equals(elem)){
                recorre = aux;
            }
            else{
                recorre=obtenerNodo(elem, aux.getIzquierdo());
                
                if(recorre==null){
                    recorre=obtenerNodo(elem, aux.getDerecho());
                }
            }
        }
        
        return recorre;
    }
    
    
    /*public boolean insertarPorPosicion(Object newElem, int posPadre, char posHijo){
        boolean exito;
        
        NodoArbol padre = nodoPorPosicion(2, 0, raiz);
        posHijo=Character.toLowerCase(posHijo);
        
        if(padre!=null){
            System.out.println(padre.getElem().toString());
            
            if(posHijo=='i' && padre.getIzquierdo()==null){
                padre.setIzquierdo(new NodoArbol(newElem, null, null));
                exito=true;
            }
            else if(posHijo=='d' && padre.getDerecho()==null){
                padre.setDerecho(new NodoArbol(newElem, null, null));
                exito=true;
            }
            else{
                exito=false;
            }    
        }
        else{
            exito=false;
        }
        
        return exito;
    }
    
    
    private NodoArbol nodoPorPosicion(int pos, int posActual, NodoArbol recorre){
                
        if(recorre!=null && posActual!=pos){
            
            recorre=nodoPorPosicion(pos, posActual+1, recorre.getIzquierdo());
            recorre=nodoPorPosicion(pos, posActual+1, recorre.getDerecho());
            
        }
        
        return recorre;
    }
    */
    
    public boolean esVacio(){
        return raiz==null;
    }
    
    
    public int altura(){
        int n;
        
        if(raiz==null){
            n=-1;
        }
        else{
           n = obtenerAltura(0, 0, raiz);
        }
        
        return n;
    }
    
    
    private int obtenerAltura(int n, int altura, NodoArbol recorre){
        
        if(recorre!=null){
        
            if(n>altura) altura=n;
            
            if(recorre.getIzquierdo()==null && recorre.getDerecho()==null){
                n=0;
            }
            
            altura = obtenerAltura(n+1, altura, recorre.getIzquierdo());
            altura = obtenerAltura(n+1, altura, recorre.getDerecho());
            
        }
                
        return altura;
    }
   
    
    public int nivel(Object elem){
        int n;
        NodoArbol aux = raiz;
        
        if(raiz==null){
            n=-1;
        }
        else{
           n = obtenerNivel(0, 0, elem, aux);
        }
        
        return n;
    }
    
    
    private int obtenerNivel(int n, int altura, Object elem, NodoArbol recorre){
        
        if(recorre!=null){
            
            if(recorre.getElem().equals(elem)){
                altura=n;
            } 
            else{
                if(recorre.getIzquierdo()==null && recorre.getDerecho()==null){
                    n=0;
                }
                
                altura = obtenerNivel(n+1, altura, elem, recorre.getIzquierdo());
                altura = obtenerNivel(n+1, altura, elem, recorre.getDerecho());
            }
        }
        return altura;
    }
    
    
    public Object padre(Object elem){
        Object elemPadre;
        
        NodoArbol aux=raiz;
        
        elemPadre = obtenerElemPadre(elem, aux);
        
        return elemPadre;
    }
    
    
    private Object obtenerElemPadre(Object elem, NodoArbol recorre){
        
        if(recorre!=null){
            
            if(recorre.getIzquierdo()!=null &&
            recorre.getIzquierdo().getElem().equals(elem)){
                
                elem=recorre.getElem();
            }
            else if(recorre.getDerecho()!=null &&
            recorre.getDerecho().getElem().equals(elem)){

                elem=recorre.getElem();
            }
            else{    
                elem = obtenerElemPadre(elem, recorre.getIzquierdo());
                elem = obtenerElemPadre(elem, recorre.getDerecho());
            }
        }
        
        return elem;
    }
    
    
    public Lista listarPreorden(){
        Lista preorden = new Lista();
        
        listarPreordenAux(raiz, preorden);
        
        return preorden;
    }
    
    
    private void listarPreordenAux(NodoArbol nodo, Lista lis){
        
        if(nodo!=null){
            lis.insertar(lis.longitud()+1, nodo.getElem());
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
        
    }
    
    
    public Lista listarInorden(){
        Lista inorden = new Lista();
        
        listarInordenAux(raiz, inorden);
        
        return inorden;
    }
    
    
    private void listarInordenAux(NodoArbol nodo, Lista lis){
        
        if(nodo!=null){
            listarInordenAux(nodo.getIzquierdo(), lis);          
            lis.insertar(lis.longitud()+1, nodo.getElem());
            listarInordenAux(nodo.getDerecho(), lis);
        }
        
    }
    
    
    public Lista listarPosorden(){
        Lista posorden = new Lista();
        
        listarPosordenAux(raiz, posorden);
        
        return posorden;
    }
    
    
    private void listarPosordenAux(NodoArbol nodo, Lista lis){
        
        if(nodo!=null){
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(lis.longitud()+1, nodo.getElem());
        }
        
    }
    
    
    public Lista listarNiveles(){
        Lista porNivel = new Lista();
        Cola c1 = new Cola();
        c1.poner(raiz);
        NodoArbol aux;
        
        while(!c1.esVacia()){
            
           aux = (NodoArbol) c1.obtenerFrente();
           
           c1.sacar();
           
           porNivel.insertar(porNivel.longitud()+1, aux.getElem());
           
           if(aux.getIzquierdo()!=null){
               c1.poner(aux.getIzquierdo());
           }
           if(aux.getDerecho()!=null){
               c1.poner(aux.getDerecho());
           }
        }
        
        return porNivel;
    }
    
    
    public ArbolBin clone(){
        ArbolBin clon = new ArbolBin();
        
        clon.raiz=new NodoArbol(raiz.getElem(), null, null);
        
        cloneAux(clon.raiz, raiz);
        
        return clon;
    }
    
    
    private void cloneAux(NodoArbol clon, NodoArbol recorre){
        
        if(recorre!=null && clon!=null){
            
            if(recorre.getIzquierdo()!=null && recorre.getElem().equals(clon.getElem())){
                NodoArbol HI = new NodoArbol(recorre.getIzquierdo().getElem(), null, null);
                clon.setIzquierdo(HI);               
            }
            
            if(recorre.getDerecho()!=null && recorre.getElem().equals(clon.getElem())){
                NodoArbol HD = new NodoArbol(recorre.getDerecho().getElem(), null, null);
                clon.setDerecho(HD);                
            }
            
            cloneAux(clon.getIzquierdo(), recorre.getIzquierdo());
            cloneAux(clon.getDerecho(), recorre.getDerecho());
        }
    }
    
    
    public void vaciar(){
        raiz=null;
    }
    
    
    public String toString(){
        String mensaje="";
        
        mensaje+=anotarNodo("", raiz);
        
        return mensaje;
    }
    
    
    private String anotarNodo(String cadena, NodoArbol nodo){
        String mensaje;
        
        if(nodo!=null){
        
            if(nodo.getIzquierdo()!=null){
                mensaje=nodo.getElem() + " es padre de "
                    + nodo.getIzquierdo().getElem() +" (izq)";
                
                if(nodo.getDerecho()!=null){
                    mensaje+= " y de " + nodo.getDerecho().getElem()+" (der)";
                }
            }
            else if(nodo.getDerecho()!=null){
                mensaje=nodo.getElem() + " es padre de "
                    + nodo.getDerecho().getElem() +" (der)";
            }
            else{
                mensaje = nodo.getElem() + " no tiene hijos";
            }
            
            mensaje+="\n";
            
            cadena+=mensaje;
            
            cadena=anotarNodo(cadena, nodo.getIzquierdo());
            cadena=anotarNodo(cadena, nodo.getDerecho());
        }
        
        
        return cadena;
    }
    
    
    public Lista frontera(){
        Lista hojas = new Lista();
        
        auxFrontera(hojas, raiz);
        
        return hojas;
    }
    
    public void auxFrontera(Lista lis, NodoArbol recorre){
        
        if(recorre!=null){
            
            if(recorre.getIzquierdo()==null && recorre.getDerecho()==null){
                lis.insertar(lis.longitud()+1, recorre.getElem());
            }
            
            auxFrontera(lis, recorre.getIzquierdo());
            auxFrontera(lis, recorre.getDerecho());
        }
    }
    
    
    public Lista obtenerAncestros(Object elem){
        Lista lis = new Lista();
        
        lis=auxAncestros(lis, elem, raiz);
        
        return lis;
    }
    
    private Lista auxAncestros(Lista lis, Object elemHijo, NodoArbol recorre){
        
        if(recorre!=null){
            
            if(recorre.getIzquierdo()!=null && recorre.getIzquierdo().getElem().equals(elemHijo)){
                lis.insertar(lis.longitud()+1, recorre.getElem());
                elemHijo=recorre.getElem();
                lis=auxAncestros(lis, elemHijo, raiz);
            }
            else if(recorre.getDerecho()!=null && recorre.getDerecho().getElem().equals(elemHijo)){
                lis.insertar(lis.longitud()+1, recorre.getElem());
                elemHijo=recorre.getElem();
                lis=auxAncestros(lis, elemHijo, raiz);
            }
            else{
                lis = auxAncestros(lis, elemHijo, recorre.getIzquierdo());
                lis = auxAncestros(lis, elemHijo, recorre.getDerecho());
            }
        }
        
        return lis;
    }
    
    
    public Lista obtenerDescendientes(Object elem){
        Lista lis = new Lista();
        
        lis=descendientesAux(false, lis, elem, raiz);
        
        return lis;
    }
    
    private Lista descendientesAux(boolean encontrado, Lista lis, Object elem, NodoArbol aux){
        
        if(aux!=null){
            
            if(aux.getElem().equals(elem)){
                encontrado = true;
            }

            if(encontrado==false){
                lis=descendientesAux(encontrado, lis, elem, aux.getDerecho());
                lis=descendientesAux(encontrado, lis, elem, aux.getIzquierdo());
            }
            else{
                lis=descendientesAux(encontrado, lis, elem, aux.getDerecho());
                lis=descendientesAux(encontrado, lis, elem, aux.getIzquierdo());
                
                if(!aux.getElem().equals(elem)){
                    lis.insertar(lis.longitud()+1, aux.getElem());
                }
            }
        }
        
        return lis;
    }
    
    
    public boolean verificarPatron(Lista patron){
	int longitud = patron.longitud();
	boolean exito;
	
	exito = patronAux(0, 1, longitud, false, patron, raiz);

	return exito;
    }

    
    private boolean patronAux(int n, int pos, int longitud, boolean exito, Lista patron, NodoArbol recorre){
        
        if(recorre!=null && patron.recuperar(pos)!=null && exito == false){
            
            Object elem = patron.recuperar(pos);
            
            if(recorre.getElem().equals(elem)){
                n++;
                pos++;
                
                if(n==longitud){
                    exito = true;
                }
            }
            else if(n > 0 && n != longitud){
                n=0;
                pos=0;
            }
            
            exito = patronAux(n, pos, longitud, exito, patron, recorre.getIzquierdo());
            exito = patronAux(n, pos, longitud, exito, patron, recorre.getDerecho());
        }
        
        return exito;
    }
    
    
    public ArbolBin clonarInvertido(){
	
	ArbolBin clon = new ArbolBin();
	
	clon.raiz = new NodoArbol(raiz.getElem(), null, null);

	clonInvAux(clon.raiz, raiz);

	return clon;
    }



    private void clonInvAux(NodoArbol clon, NodoArbol recorre){

        if(recorre!=null && clon!=null){

            if(recorre.getIzquierdo()!=null){
                clon.setDerecho(new NodoArbol(recorre.getIzquierdo().getElem(), null, null));
            }

            if(recorre.getDerecho()!=null){
                clon.setIzquierdo(new NodoArbol(recorre.getDerecho().getElem(), null, null));
            }

            clonInvAux(clon.getDerecho(), recorre.getIzquierdo());
            clonInvAux(clon.getIzquierdo(), recorre.getDerecho());	
        }
    }
    
    
}
