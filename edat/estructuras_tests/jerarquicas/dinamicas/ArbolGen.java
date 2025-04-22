/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas.dinamicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        raiz = null;
    }

    public boolean insertar(Object newElem, Object elemPadre) {
        boolean exito = true;
        NodoGen padre;

        if (raiz == null) {
            raiz = new NodoGen(newElem, null, null);
        } else {

            padre = obtenerNodo(elemPadre, raiz);

            if (padre != null) {
                System.out.println("padre: " + padre.getElem().toString());

                if (padre.getHijoIzquierdo() == null) {
                    padre.setHijoIzquierdo(new NodoGen(newElem, null, null));
                } else {
                    NodoGen hijo = padre.getHijoIzquierdo();
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(new NodoGen(newElem, null, null));
                }

            } else
                exito = false;
        }

        return exito;
    }

    private NodoGen obtenerNodo(Object elem, NodoGen recorre) {

        if (recorre != null && !recorre.getElem().equals(elem)) {

            NodoGen hijo = recorre.getHijoIzquierdo();

            if (hijo != null && hijo.getElem().equals(elem)) {
                recorre = hijo;
            }

            while (hijo != null && !recorre.getElem().equals(elem)) {

                if (hijo.getHijoIzquierdo() != null) {
                    recorre = obtenerNodo(elem, hijo);
                }

                hijo = hijo.getHermanoDerecho();

                if (hijo != null && hijo.getElem().equals(elem)) {
                    recorre = hijo;
                }
            }
        }

        return recorre;
    }

    public boolean insertarPorPosicion(Object newElem, int pos) {
        boolean exito;

        exito = posicionAux(false, newElem, 1, pos, raiz);

        return exito;
    }

    private boolean posicionAux(boolean exito, Object newElem, int i, int pos, NodoGen recorre) {

        if (recorre != null && exito == false) {

            NodoGen hijo = recorre.getHijoIzquierdo();

            if (i == pos) {
                if (hijo == null) {
                    recorre.setHijoIzquierdo(new NodoGen(newElem, null, null));
                } else {
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(new NodoGen(newElem, null, null));
                }
                exito = true;
            } else {

                while (hijo != null && exito == false) {
                    exito = posicionAux(exito, newElem, i + 1, pos, hijo);
                    hijo = hijo.getHermanoDerecho();
                }

            }
        }

        return exito;
    }

    public boolean pertenece(Object elem) {
        boolean exito;

        exito = perteneceAux(false, elem, raiz);

        return exito;
    }

    private boolean perteneceAux(boolean exito, Object elem, NodoGen recorre) {

        if (recorre != null && exito == false) {

            NodoGen hijo = recorre.getHijoIzquierdo();

            if (hijo != null && hijo.getElem().equals(elem)) {
                exito = true;
            }

            while (hijo != null && !recorre.getElem().equals(elem)) {

                if (hijo.getHijoIzquierdo() != null) {
                    exito = perteneceAux(exito, elem, hijo);
                }

                hijo = hijo.getHermanoDerecho();

                if (hijo != null && hijo.getElem().equals(elem)) {
                    recorre = hijo;
                    exito = true;
                }
            }
        }

        return exito;
    }

    public Lista ancestros(Object elemHijo) {
        Lista lis = new Lista();

        lis = ancestrosAux(lis, elemHijo, raiz);

        return lis;
    }

    private Lista ancestrosAux(Lista lis, Object elemHijo, NodoGen recorre) {

        if (recorre != null && !raiz.equals(elemHijo)) {

            NodoGen hijo = recorre.getHijoIzquierdo();

            while (hijo != null) {

                lis = ancestrosAux(lis, elemHijo, hijo);

                if (hijo.getElem().equals(elemHijo)) {
                    lis.insertar(lis.longitud() + 1, recorre.getElem());
                    lis = ancestrosAux(lis, recorre.getElem(), raiz);
                }

                hijo = hijo.getHermanoDerecho();
            }
        }

        return lis;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public int altura() {
        int alturaArbol;

        if (raiz == null) {
            alturaArbol = -1;
        } else if (raiz.getHijoIzquierdo() == null) {
            alturaArbol = 0;
        } else {
            alturaArbol = alturaAux(0, 0, raiz);
        }

        return alturaArbol;
    }

    private int alturaAux(int altura, int alturaMax, NodoGen recorre) {

        if (recorre != null) {

            NodoGen hijo = recorre.getHijoIzquierdo();

            if (hijo == null && recorre.getHermanoDerecho() == null) {

                if (altura > alturaMax)
                    alturaMax = altura;

                altura = 0;
            }

            while (hijo != null) {

                alturaMax = alturaAux(altura + 1, alturaMax, hijo);

                hijo = hijo.getHermanoDerecho();
            }
        }

        return alturaMax;
    }

    public int nivel(Object elem) {
        int nivelNodo;

        nivelNodo = nivelAux(0, -1, elem, raiz);

        return nivelNodo;
    }

    private int nivelAux(int altura, int nivelNodo, Object elem, NodoGen recorre) {

        if (recorre != null) {

            NodoGen hijo = recorre.getHijoIzquierdo();

            if (recorre.getElem().equals(elem)) {
                nivelNodo = altura;
            }

            if (hijo == null && recorre.getHermanoDerecho() == null) {
                altura = 0;
            }

            while (hijo != null && nivelNodo == -1) {

                nivelNodo = nivelAux(altura + 1, nivelNodo, elem, hijo);

                hijo = hijo.getHermanoDerecho();
            }
        }

        return nivelNodo;
    }

    public Object padre(Object elemHijo) {
        Object elemPadre;

        elemPadre = padreAux(elemHijo, raiz);

        return elemPadre;
    }

    private Object padreAux(Object elemHijo, NodoGen recorre) {
        Object elemPadre = null;

        if (recorre != null) {

            NodoGen hijo = recorre.getHijoIzquierdo();

            if (hijo != null && hijo.getElem().equals(elemHijo)) {
                elemPadre = recorre.getElem();
            }

            while (hijo != null && elemPadre == null) {
                elemPadre = padreAux(elemHijo, hijo);

                hijo = hijo.getHermanoDerecho();
            }

        }

        return elemPadre;
    }

    public Lista listarPreorden() {
        Lista preorden = new Lista();

        listarPreordenAux(raiz, preorden);

        return preorden;
    }

    private void listarPreordenAux(NodoGen recorre, Lista lis) {

        if (recorre != null) {

            lis.insertar(lis.longitud() + 1, recorre.getElem());

            NodoGen hijo = recorre.getHijoIzquierdo();

            while (hijo != null) {
                listarPreordenAux(hijo, lis);

                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarInorden() {
        Lista inorden = new Lista();

        listarInordenAux(raiz, inorden);

        return inorden;
    }

    private void listarInordenAux(NodoGen recorre, Lista lis) {

        if (recorre != null) {

            if (recorre.getHijoIzquierdo() != null) {
                listarInordenAux(recorre.getHijoIzquierdo(), lis);
            }

            lis.insertar(lis.longitud() + 1, recorre.getElem());

            if (recorre.getHijoIzquierdo() != null) {
                NodoGen hijo = recorre.getHijoIzquierdo();

                while (hijo != null) {
                    listarInordenAux(hijo, lis);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden() {
        Lista posorden = new Lista();

        listarPosordenAux(raiz, posorden);

        return posorden;
    }

    private void listarPosordenAux(NodoGen recorre, Lista lis) {

        if (recorre != null) {

            if (recorre.getHijoIzquierdo() != null) {
                listarPosordenAux(recorre.getHijoIzquierdo(), lis);
            }

            NodoGen hijo = recorre.getHijoIzquierdo();

            while (hijo != null) {
                hijo = hijo.getHermanoDerecho();

                listarPosordenAux(hijo, lis);
            }

            lis.insertar(lis.longitud() + 1, recorre.getElem());
        }
    }

    public Lista listarNiveles() {
        Lista porNivel = new Lista();

        porNivel.insertar(porNivel.longitud() + 1, raiz.getElem());
        porNivel.insertar(porNivel.longitud() + 1, 0);

        Cola col = new Cola();

        listarNivelesAux(raiz, porNivel, col, 0, false);

        return porNivel;
    }

    private void listarNivelesAux(NodoGen recorre, Lista porNivel, Cola col, int nivel, boolean primo) {

        if (recorre != null) {
            NodoGen hijo = recorre.getHijoIzquierdo();

            while (hijo != null) {
                porNivel.insertar(porNivel.longitud() + 1, hijo.getElem());

                hijo = hijo.getHermanoDerecho();
            }

            if (primo == false) {
                porNivel.insertar(porNivel.longitud() + 1, nivel + 1);
            }

            hijo = recorre.getHijoIzquierdo();

            while (hijo != null) {

                if (hijo.getHijoIzquierdo() != null) {
                    col.poner(hijo);
                } else if (hijo.getHermanoDerecho() == null) {
                    listarNivelesAux(null, porNivel, col, nivel, primo);
                }

                hijo = hijo.getHermanoDerecho();
            }

            if (!col.esVacia()) {
                NodoGen siguiente = (NodoGen) col.obtenerFrente();

                col.sacar();

                if (siguiente.getHermanoDerecho() != null) {
                    listarNivelesAux(siguiente, porNivel, col, nivel, true);
                } else {
                    listarNivelesAux(siguiente, porNivel, col, nivel + 1, false);
                }
            }
        }
    }

    public void vaciar() {
        raiz = null;
    }

    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();

        clon.raiz = new NodoGen(raiz.getElem(), null, null);

        cloneAux(clon.raiz, raiz);

        return clon;
    }

    private void cloneAux(NodoGen nodoClon, NodoGen recorre) {

        if (recorre != null) {

            NodoGen hijo = recorre.getHijoIzquierdo();

            if (hijo != null) {
                nodoClon.setHijoIzquierdo(new NodoGen(hijo.getElem(), null, null));
            }

            NodoGen hijoClon = nodoClon.getHijoIzquierdo();

            while (hijo != null) {
                cloneAux(hijoClon, hijo);

                hijo = hijo.getHermanoDerecho();

                if (hijo != null) {
                    hijoClon.setHermanoDerecho(new NodoGen(hijo.getElem(), null, null));
                    hijoClon = hijoClon.getHermanoDerecho();
                }
            }
        }
    }

    public boolean verificarCamino(Lista camino) {

        boolean exito;

        exito = verificarAux(camino, false, raiz, 1);

        return exito;
    }

    private boolean verificarAux(Lista camino, boolean completado, NodoGen recorre, int i) {

        if (recorre != null && completado == false) {

            NodoGen hijo = recorre.getHijoIzquierdo();

            if (i <= camino.longitud() && camino.recuperar(i).equals(recorre.getElem())) {
                i++;
                if (i == camino.longitud() + 1) {
                    completado = true;
                }
            } else if (i != 1) {
                i = 1;
            }

            while (hijo != null) {
                completado = verificarAux(camino, completado, hijo, i);
                hijo = hijo.getHermanoDerecho();
            }
        }

        return completado;
    }

    public boolean jerarquizar(Object elem) {
        boolean exito;

        exito = jerarquizarAux(elem, raiz, raiz);

        return exito;
    }

    private boolean jerarquizarAux(Object elem, NodoGen recorre, NodoGen hermanoIzq) {
        boolean exito = false;

        if (recorre != null) {

            if (recorre.getElem().equals(elem)) {
                Object elemPadre = padre(recorre.getElem());
                NodoGen padre = obtenerNodo(elemPadre, raiz);

                if (padre != null || padre != raiz) {
                    NodoGen guardar = padre.getHermanoDerecho();
                    hermanoIzq.setHermanoDerecho(recorre.getHermanoDerecho());
                    padre.setHermanoDerecho(recorre);
                    recorre.setHermanoDerecho(guardar);
                    exito = true;
                }
            } else {
                NodoGen hijo = recorre.getHijoIzquierdo();

                while (hijo != null) {

                }
            }
        }

        return exito;
    }

    public String toString() {
        return toStringAux(raiz);
    }

    private String toStringAux(NodoGen recorre) {
        String cadena = "";

        if (recorre != null) {

            cadena += recorre.getElem().toString() + " -> ";
            NodoGen hijo = recorre.getHijoIzquierdo();

            while (hijo != null) {
                cadena += hijo.getElem() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            hijo = recorre.getHijoIzquierdo();
            while (hijo != null) {
                cadena += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }

        return cadena;
    }

    public boolean verificarPatron(Lista lisPatron) {
        boolean exito;

        exito = patronAux(true, lisPatron, 1, raiz);

        return exito;
    }

    private boolean patronAux(boolean exito, Lista lis, int pos, NodoGen recorre) {

        if (pos > lis.longitud()) {
            exito = false;
        } else if (recorre != null && exito == true) {

            if (recorre.getElem().equals(lis.recuperar(pos))) {
                pos++;
                NodoGen hijo = recorre.getHijoIzquierdo();

                if (pos == lis.longitud() && hijo != null) {
                    exito = false;
                } else {
                    while (hijo != null && !hijo.getElem().equals(lis.recuperar(pos))) {

                        hijo = hijo.getHermanoDerecho();
                    }

                    if (hijo != null && pos < lis.longitud()) {
                        exito = patronAux(exito, lis, pos, hijo);
                    } else if (hijo == null) {
                        exito = false;
                    }
                }

            } else {
                exito = false;
            }
        }

        return exito;
    }

    public int descendienteMasLejano(Object d) {
        int[] nivelFinal = new int[1];
        nivelFinal[0] = 0;

        if (!raiz.getElem().equals(d)) {
            descendienteAux(raiz, d, nivelFinal, 0);
        }

        return nivelFinal[0];
    }

    private int descendienteAux(NodoGen recorre, Object d, int[] nivelFinal, int nivelActual) {
        if (recorre != null) {

            NodoGen hijo = recorre.getHijoIzquierdo();
            nivelActual++;

            while (hijo != null) {

                if (hijo.getElem().equals(d)) {
                    if (nivelFinal[0] < nivelActual) {
                        nivelFinal[0] = nivelActual;
                    }
                }
                nivelFinal[0] = descendienteAux(hijo, d, nivelFinal, nivelActual);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return nivelFinal[0];
    }

    private void llenar(Lista aLlenar, Lista llena) {
        for (int i = 1; i <= llena.longitud(); i++) {
            aLlenar.insertar(i, llena.recuperar(i));
        }
    }

    public Lista caminoAHojaMasLejana() {
        Lista camino = new Lista(), actual = new Lista();

        if (raiz != null) {
            actual.insertar(actual.longitud()+1, raiz.getElem());
            hojaLejanaAux(raiz, camino, actual);
        }

        return camino;
    }

    private void hojaLejanaAux(NodoGen recorre, Lista camino, Lista actual) {
        if (recorre != null) {
            NodoGen hijo = recorre.getHijoIzquierdo();

            if (hijo == null && actual.longitud() > camino.longitud()) {
                camino.vaciar();
                llenar(camino, actual);
            }
            else{
                while (hijo != null) {
                    actual.insertar(actual.longitud()+1, hijo.getElem());
                    hojaLejanaAux(hijo, camino, actual);
                    hijo = hijo.getHermanoDerecho();
                }
            }
            
        }
        actual.eliminar(actual.longitud());
    }

}
