package Estructuras;

public class AVL {

    private NodoAVL raiz;

    public boolean pertenece(Comparable elem) {
        boolean exito = true;

        if (esVacio()) {
            exito = false;
        } else {
            exito = perteneceAux(elem, raiz);
        }

        return exito;
    }

    public boolean perteneceAux(Comparable elem, NodoAVL recorre) {
        boolean exito = false;

        if (recorre != null) {

            if (recorre.getElem().compareTo(elem) == 0) {
                exito = true;
            } else if (recorre.getElem().compareTo(elem) > 0) {
                exito = perteneceAux(elem, recorre.getIzquierdo());
            } else {
                exito = perteneceAux(elem, recorre.getDerecho());
            }
        }

        return exito;
    }

    public Comparable obtenerIgual(Comparable elem) {
        Comparable encontrado = null;

        if (!esVacio()) {
            encontrado = obtenerIgualAux(elem, raiz);
        }

        return encontrado;
    }

    private Comparable obtenerIgualAux(Comparable elem, NodoAVL recorre) {
        Comparable encontrado = null;

        if (recorre != null) {

            if (recorre.getElem().compareTo(elem) == 0) {
                encontrado = recorre.getElem();
            } else if (recorre.getElem().compareTo(elem) > 0) {
                encontrado = obtenerIgualAux(elem, recorre.getIzquierdo());
            } else {
                encontrado = obtenerIgualAux(elem, recorre.getDerecho());
            }
        }

        return encontrado;
    }

    public boolean insertar(Comparable newElem) {
        boolean exito = false;

        if (esVacio()) {
            raiz = new NodoAVL(newElem, null, null);
            exito = true;
        } else {
            exito = insertarAux(newElem, raiz, null);
        }

        return exito;
    }

    private boolean insertarAux(Comparable elem, NodoAVL recorre, NodoAVL padre) {
        boolean exito = true;

        if (recorre != null) {
            if (recorre.getElem().compareTo(elem) > 0) {
                if (recorre.getIzquierdo() == null) {
                    recorre.setIzquierdo(new NodoAVL(elem, null, null));
                } else {
                    exito = insertarAux(elem, recorre.getIzquierdo(), recorre);
                }
            } else if (recorre.getElem().compareTo(elem) < 0) {
                if (recorre.getDerecho() == null) {
                    recorre.setDerecho(new NodoAVL(elem, null, null));
                } else {
                    exito = insertarAux(elem, recorre.getDerecho(), recorre);
                }
            } else {
                exito = false;
            }

            recorre.recalcularAltura();
            recorre = balancear(recorre, padre);
        }

        return exito;
    }

    private NodoAVL balancear(NodoAVL recorre, NodoAVL padre) { // void

        if (recorre != null) {
            int balance = obtenerBalance(recorre);
            int balanceHijo = 0;
            NodoAVL hijo = null;

            if (Math.abs(balance) > 1) {
                NodoAVL HI = recorre.getIzquierdo();
                NodoAVL HD = recorre.getDerecho();

                if (HI != null && HD != null) {

                    if (HI.getAltura() > HD.getAltura()) {
                        balanceHijo = obtenerBalance(HI);
                        hijo = HI;
                    } else {
                        balanceHijo = obtenerBalance(HD);
                        hijo = HD;
                    }
                } else if (HI != null && HD == null) {
                    balanceHijo = obtenerBalance(HI);
                    hijo = HI;
                } else if (HD != null) {
                    balanceHijo = obtenerBalance(HD);
                    hijo = HD;
                }

                if (balance == 2) {
                    if (balanceHijo == -1) {
                        recorre.setIzquierdo(rotacionIzquierda(hijo, recorre));
                        recorre = rotacionDerecha(recorre, padre);
                    } else {

                        recorre = rotacionDerecha(recorre, padre);
                    }
                } else if (balance == -2) {

                    if (balanceHijo == 1) {
                        recorre.setDerecho(rotacionDerecha(hijo, recorre));
                        recorre = rotacionIzquierda(recorre, padre);
                    } else {
                        recorre = rotacionIzquierda(recorre, padre);
                    }
                }
            }
        }

        return recorre;
    }

    private NodoAVL rotacionIzquierda(NodoAVL pivote, NodoAVL padre) {

        NodoAVL HD = pivote.getDerecho();
        pivote.setDerecho(HD.getIzquierdo());
        HD.setIzquierdo(pivote);
        pivote.recalcularAltura();
        HD.recalcularAltura();

        if (pivote == raiz) {
            raiz = HD;
        } else {
            if (padre.getIzquierdo() == pivote) {
                padre.setIzquierdo(HD);
            } else {
                padre.setDerecho(HD);
            }   
        }

        return HD;
    }

    private NodoAVL rotacionDerecha(NodoAVL pivote, NodoAVL padre) {

        NodoAVL HI = pivote.getIzquierdo();
        pivote.setIzquierdo(HI.getDerecho());
        HI.setDerecho(pivote);
        pivote.recalcularAltura();
        HI.recalcularAltura();

        if (pivote == raiz) {
            raiz = HI;
        } else {
            if (padre.getIzquierdo() == pivote) {
                padre.setIzquierdo(HI);
            } else {
                padre.setDerecho(HI);
            }
        }

        return HI;
    }

    private int obtenerBalance(NodoAVL nodo) {
        int balance = 0;
        NodoAVL HI = nodo.getIzquierdo();
        NodoAVL HD = nodo.getDerecho();

        if (HI != null && HD != null) {
            balance = (HI.getAltura() - HD.getAltura());
        } else if (HI != null && HD == null) {
            balance = (HI.getAltura() + 1);
        } else if (HD != null) {
            balance = (-1 - HD.getAltura());
        }

        return balance;
    }

    public boolean eliminar(Comparable elem) {
        boolean exito = false;

        exito = eliminarAux(elem, raiz, null, null);

        return exito;
    }

    private boolean eliminarAux(Comparable elem, NodoAVL recorre, NodoAVL padre, NodoAVL abuelo) {
        boolean exito = false;

        if (recorre != null) {

            if (recorre.getElem().compareTo(elem) == 0) {

                NodoAVL izq = recorre.getIzquierdo();
                NodoAVL der = recorre.getDerecho();

                if (padre == null) {
                    // se quiere eliminar la raiz
                    eliminarRaiz(izq, der, recorre);
                } else {
                    if (izq == null && der == null) {
                        // eliminar Nodo sin hijos
                        sinHijo(recorre, padre);
                    } else if (izq != null && der != null) {
                        // eliminar Nodo con dos hijos 
                        dosHijos(recorre, padre);
                    } else {
                        // eliminar Nodo con un hijo
                        unHijo(recorre, padre);
                    }

                    padre.recalcularAltura();
                    padre = balancear(padre, abuelo);
                }
                
                exito=true;

            } else if (recorre.getElem().compareTo(elem) < 0) {
                exito = eliminarAux(elem, recorre.getDerecho(), recorre, padre);
            } else {
                exito = eliminarAux(elem, recorre.getIzquierdo(), recorre, padre);
            }

            if(exito){
                recorre.recalcularAltura();
                recorre = balancear(recorre, padre);
            }
        }

        return exito;
    }
    
    private void eliminarRaiz(NodoAVL izq, NodoAVL der, NodoAVL recorre){
        if (izq == null && der == null) {
            // La raíz es única: el árbol queda vacío.
            raiz = null;
        } else if (izq != null && der == null) {
            // La raíz tiene solo hijo izquierdo.
            raiz = izq;
        } else if (izq == null && der != null) {
            // La raíz tiene solo hijo derecho.
            raiz = der;
        } else {
            // La raíz tiene dos hijos.
            dosHijos(recorre, null);
        }
    }

    private void sinHijo(NodoAVL actual, NodoAVL padre) {

        if (padre.getIzquierdo() == actual) {
            padre.setIzquierdo(null);
        } else {
            padre.setDerecho(null);
        }
    }

    private void unHijo(NodoAVL actual, NodoAVL padre) {

        NodoAVL izq = actual.getIzquierdo();
        NodoAVL der = actual.getDerecho();

        if (izq != null && der == null) {

            if (padre.getIzquierdo() == actual) {
                padre.setIzquierdo(izq);
            } else {
                padre.setDerecho(izq);
            }
            padre.recalcularAltura();
            // balancear(padre); parece innecesario ya que cuando vuele a eliminarAux se balancea
        } else if (izq == null && der != null) {

            if (padre.getIzquierdo() == actual) {
                padre.setIzquierdo(der);
            } else {
                padre.setDerecho(der);
            }
        }
    }

    // private void dosHijos(NodoAVL actual, NodoAVL padreActual) {
    //     NodoAVL abueloSucesor = padreActual;
    //     NodoAVL padreSucesor = actual; // Padre del sucesor comienza como el nodo actual
    //     NodoAVL sucesor = actual.getDerecho();
    
    //     Buscar el sucesor inorder (más izquierdo del subárbol derecho)
    //     while (sucesor.getIzquierdo() != null) {
    //         abueloSucesor = padreSucesor;
    //         padreSucesor = sucesor;
    //         sucesor = sucesor.getIzquierdo();
    //     }
        
    //     Eliminar el sucesor usando su padre real
    //     eliminarAux(sucesor.getElem(), sucesor, padreSucesor, abueloSucesor);
    //     actual.setElem(sucesor.getElem());
    // }

    private void dosHijos(NodoAVL actual, NodoAVL padreActual) {
        NodoAVL abueloSucesor = padreActual;
        NodoAVL padreSucesor = actual; // Padre del sucesor comienza como el nodo actual
        NodoAVL sucesor = actual.getIzquierdo();
    
        // Buscar el sucesor inorder (más izquierdo del subárbol derecho)
        while (sucesor.getDerecho() != null) {
            abueloSucesor = padreSucesor;
            padreSucesor = sucesor;
            sucesor = sucesor.getDerecho();
        }
        
        // Eliminar el sucesor usando su padre real
        eliminarAux(sucesor.getElem(), sucesor, padreSucesor, abueloSucesor);
        actual.setElem(sucesor.getElem());
    }
    
    public Lista listar() {
        Lista lis = new Lista();

        listarAux(lis, raiz);

        return lis;
    }

    private void listarAux(Lista lis, NodoAVL recorre) {

        if (recorre != null) {
            listarAux(lis, recorre.getIzquierdo());
            lis.insertar(lis.longitud() + 1, recorre.getElem());
            listarAux(lis, recorre.getDerecho());
        }

    }

    public Lista listarRango(Comparable piso, Comparable techo) {
        Lista lis = new Lista();

        listarRangoAux(lis, piso, techo, raiz);

        return lis;
    }

    private void listarRangoAux(Lista lis, Comparable piso, Comparable techo, NodoAVL recorre) {

        if (recorre != null) {
            
            if(recorre.getElem().compareTo(piso) < 0){
                listarRangoAux(lis, piso, techo, recorre.getDerecho());
            }
            else if(recorre.getElem().compareTo(piso) >= 0) {
                listarRangoAux(lis, piso, techo, recorre.getIzquierdo());
                if(recorre.getElem().compareTo(techo)<=0){
                    lis.insertar(lis.longitud() + 1, recorre.getElem());                
                }
                if(recorre.getElem().compareTo(techo) < 0){
                    listarRangoAux(lis, piso, techo, recorre.getDerecho());
                }
            }
        }
    }

    public Comparable minimoElem() {
        Comparable min;
        NodoAVL recorre = raiz;

        if (esVacio()) {
            min = null;
        } else {
            if (recorre.getIzquierdo() != null) {
                while (recorre.getIzquierdo() != null) {
                    recorre = recorre.getIzquierdo();
                }
            }
            min = recorre.getElem();
        }

        return min;
    }

    public Comparable maximoElem() {
        Comparable max;
        NodoAVL recorre = raiz;

        if (esVacio()) {
            max = null;
        } else {
            if (recorre.getDerecho() != null) {
                while (recorre.getDerecho() != null) {
                    recorre = recorre.getDerecho();
                }
            }
            max = recorre.getElem();
        }

        return max;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public void vaciar() {
        raiz = null;
    }

    public String toString() {

        String msj = toStringAux("", raiz);

        return msj;
    }

    private String toStringAux(String msj, NodoAVL recorre) {
        String cadena;

        if (recorre != null) {

            if (recorre.getIzquierdo() != null) {
                cadena = recorre.getElem().toString() + " es padre de "
                        + recorre.getIzquierdo().getElem().toString() + " (izq)";

                if (recorre.getDerecho() != null) {
                    cadena += " y de " + recorre.getDerecho().getElem().toString() + " (der)";
                }
            } else if (recorre.getDerecho() != null) {
                cadena = recorre.getElem().toString() + " es padre de "
                        + recorre.getDerecho().getElem().toString() + " (der)";
            } else {
                cadena = recorre.getElem().toString() + " no tiene hijos";
            }

            cadena += "\n";

            msj += cadena;

            msj = toStringAux(msj, recorre.getIzquierdo());
            msj = toStringAux(msj, recorre.getDerecho());
        }

        return msj;
    }

}