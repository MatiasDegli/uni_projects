/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas.dinamicas;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 *
 * @author Zambon
 */
public class ArbolGen {
    private NodoGen raiz;

    public ArbolGen() {
        raiz = null;
    }

    public boolean insertar(Object hijo, Object elemPadre) {
        boolean exito = false;
        NodoGen nodoNuevo = new NodoGen(hijo, null, null);
        if (esVacio()) {
            this.raiz = new NodoGen(hijo, raiz, raiz);
            exito = true;
            // si el arbol esta vacio, inserta el elemento en la raiz
        } else {
            NodoGen nodo = obtenerNodo(this.raiz, elemPadre);
            // utilizo el modulo obtenerNodo para buscar localizar el elemento padre que
            // quiero
            if (nodo != null) {
                // condicion que el nodo no sea nulo
                if (nodo.getHijoIzquierdo() == null) {
                    nodo.setHijoIzquierdo(nodoNuevo);
                    // si mi nodo padre no tiene hijo izquierdo lo inserto como nuevo hijo izquierdo
                } else {
                    nodo = nodo.getHijoIzquierdo();
                    // si mi nodo Padre tiene hijos me paro en el hijo izquierdo y recorro sus
                    // hermanos
                    while (nodo.getHermanoDerecho() != null) {
                        nodo = nodo.getHermanoDerecho();
                        // recorre los hermanos derechos hasta que llega al ultimo
                    }
                    nodo.setHermanoDerecho(nodoNuevo);
                    // inserto como ultimo en los hermanos del hijo izquierdo
                }
                exito = true;
            }
        }
        return exito;
    }

    
    public boolean esVacio() {
        return this.raiz == null;
    }

    
    public void vaciar() {
        this.raiz = null;
    }

    
    public Lista ancestros(Object elem) {
        Lista l = new Lista();
        if (!elem.equals(this.raiz.getElem())) {
            ancestrosAux(elem, this.raiz, l);
        }
        return l;
    }
    
    
    private boolean ancestrosAux(Object elem, NodoGen n, Lista l) {
        boolean flag = false;
        // flag es una variable de tipo booleana que verifica si el elemento que busco
        // se encuentra en la subrama en la que estoy parado
        if (n != null && !flag) {
            // siempre que el nodo sea distinto de nulo continuo
            if (n.getElem().equals(elem)) {
                flag = true;
                // si el elemento es encontrado mi bandera es verdadera
            } else {
                if (n.getHijoIzquierdo() != null) {
                    // si tengo hijo izquierdo lo llamo con la variable aux hijo
                    NodoGen hijo = n.getHijoIzquierdo();
                    while (hijo != null && !flag) {
                        flag = ancestrosAux(elem, hijo, l);
                        hijo = hijo.getHermanoDerecho();
                        System.out.println(flag);
                    }
                    if (flag) {
                        l.insertar(n.getElem(), l.longitud() + 1);
                    }
                }
            }
        }
        return flag;
    }
    
    
    public boolean pertenece(Object elem) {
        boolean si = false;

        if (obtenerNodo(raiz, elem) != null) {
            si = true;
        }

        return si;
    }
    
    
    public Object padre(Object elemento) {
        Object elemPadre = null;
        if (this.raiz != null && !this.raiz.equals(elemento)) {
            elemPadre = padreAux(this.raiz, elemento);
        }
        return elemPadre;
    }
    
    
    private Object padreAux(NodoGen n, Object elem) {
        Object resultado = null;
        // si no es vacio
        if (n != null && pertenece(elem)) {
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null && resultado == null) {
                // visitahijos de n
                if (hijo.getElem().equals(elem)) {
                    resultado = n.getElem();
                } else {
                    hijo = hijo.getHermanoDerecho();
                }
            }
            if (resultado == null) {

                hijo = n.getHijoIzquierdo();
                while (hijo != null && resultado == null) {
                    resultado = padreAux(hijo, elem);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return resultado;
    }

    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoGen nodo) {
        int aux, resultado = -1;
        if (nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                aux = alturaAux(hijo);
                if (aux > resultado) {
                    resultado = aux;

                }
                hijo = hijo.getHermanoDerecho();
            }
            resultado++;
        }
        return resultado;
    }

    public int nivel(Object elem) {
        int n = 0;
        NodoGen aux = this.raiz;

        if (obtenerNodo(aux, elem) == null)
            n = -1;

        while (obtenerNodo(aux, elem) != null) {
            if (obtenerNodo(aux.getHijoIzquierdo(), elem) != null) {
                aux = aux.getHijoIzquierdo();
                n++;
            } else
                aux = aux.getHermanoDerecho();
        }
        return n;
    }

    public Lista listarPreorden() {
        Lista l = new Lista();
        listarPreordenAux(this.raiz, l);
        return l;
    }

    private void listarPreordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            ls.insertar(n.getElem(), ls.longitud() + 1);
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                listarPreordenAux(hijo, ls);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarPosorden() {
        Lista l = new Lista();
        listarPosordenAux(this.raiz, l);
        l.insertar(this.raiz.getElem(), l.longitud() + 1);
        return l;
    }

    private void listarPosordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                listarPosordenAux(hijo, ls);
                ls.insertar(hijo.getElem(), ls.longitud() + 1);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarInorden() {
        Lista l = new Lista();
        listarInordenAux(this.raiz, l);
        return l;
    }

    private void listarInordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            // llamado recursivo con primer hijo de n
            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }
            // visita del nodo n
            ls.insertar(n.getElem(), ls.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        if (this.raiz != null) {
            clon.raiz = new NodoGen(raiz.getElem(), null, null);
            cloneAux(raiz, clon.raiz);
        }
        return clon;
    }

    private void cloneAux(NodoGen nodo, NodoGen nodoClon) {

        if (nodo != null && nodoClon != null) {
            if (nodo.getHijoIzquierdo() != null) {
                nodoClon.setHijoIzquierdo(new NodoGen(nodo.getHijoIzquierdo().getElem(), null, null));
            }
            if (nodo.getHermanoDerecho() != null) {
                nodoClon.setHermanoDerecho(new NodoGen(nodo.getHermanoDerecho().getElem(), null, null));
            }

            cloneAux(nodo.getHijoIzquierdo(), nodoClon.getHijoIzquierdo());
            cloneAux(nodo.getHermanoDerecho(), nodoClon.getHermanoDerecho());
        }
    }

    public Lista listarPorNiveles() {
        Lista lista = new Lista();
        listarPorNivelesAux(this.raiz, lista);
        return lista;
    }

    private void listarPorNivelesAux(NodoGen n, Lista lista) {
        Cola c = new Cola();
        c.poner(n);
        if (this.raiz != null) {
            while (!c.esVacia()) {
                NodoGen nodo = (NodoGen) c.obtenerFrente();
                c.sacar();
                lista.insertar(nodo.getElem(), lista.longitud() + 1);
                if (nodo.getHijoIzquierdo() != null) {
                    NodoGen hijo = nodo.getHijoIzquierdo();
                    while (hijo != null) {
                        c.poner(hijo);
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
        }
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            s += n.getElem().toString() + "->";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ",";
                hijo = hijo.getHermanoDerecho();
            }
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }
    private NodoGen obtenerNodo(NodoGen n, Object elem) {
        NodoGen nodoTemp = null;
        if (n != null) {
            // si es distinto de nulo
            if (n.getElem().equals(elem)) {
                // llegue al nodo que busco, se corta el ciclo
                nodoTemp = n;
            } else {

                nodoTemp = obtenerNodo(n.getHermanoDerecho(), elem);
                // avanza por los hermanos derechos del nodo
                if (nodoTemp == null) {
                    nodoTemp = obtenerNodo(n.getHijoIzquierdo(), elem);
                    // si no lo encontre entre todos sus hermanos,avanzo al hijo izquierdo
                }

            }
        }
        return nodoTemp;
    }

    // Ejercicios auxiliares ---------------------------------------------------

    public boolean sonFrontera(Lista unaLista) {
        int i = 1;
        boolean son = true;
        if (raiz == null || unaLista.esVacia()) {
            son = false;
            //si la lista es vacia o el arbol es vacio devuelve falso
        }
        while (i <= unaLista.longitud() && son) {
            NodoGen n = obtenerNodo(raiz, unaLista.recuperar(i));
            //para cada elemento de la lista, lo asigno a un nodo y llamo a obtener Nodo para localizarlo
             if (n==null ||n.getHijoIzquierdo() != null) {
                son = false;
                //Si el nodo tiene hijos o no pertenece al arbol es falso

            }
            i++;
        }
        return son;
    }

    public boolean equals(ArbolGen unArbol){
        boolean igual;

        igual=equalsAux(this.raiz, unArbol.raiz);

        return igual;
    }


    private boolean equalsAux(NodoGen nodo, NodoGen nodo2) {
        boolean igual = true;

        if (nodo == null && nodo2 == null) {
            igual = true; // Ambos nodos son nulos
        } 
        else if (nodo == null || nodo2 == null) {
            igual = false; // Uno de los nodos es nulo y el otro no
        } 
        else if (!nodo.getElem().equals(nodo2.getElem())) {
            igual = false; // Los elementos de los nodos son diferentes
        } 
        else{
            NodoGen hijo = nodo.getHijoIzquierdo();
            NodoGen hijo2 = nodo2.getHijoIzquierdo();

            // Llamado Recursivo para comparar los hijos de los nodos
            while (hijo != null || hijo2 != null) {
                if (!equalsAux(hijo, hijo2)) {
                    igual = false; 
                    // Si los hijos son diferentes retorna falso
                    break;
                }
                
                hijo = hijo.getHermanoDerecho();
                hijo2 = hijo2.getHermanoDerecho();
            }
        }

        return igual;
    }

}