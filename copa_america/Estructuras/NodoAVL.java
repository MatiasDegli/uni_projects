package Estructuras;

public class NodoAVL {

    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;

    public NodoAVL(Comparable el, NodoAVL izq, NodoAVL der) {
        elem = el;
        izquierdo = izq;
        derecho = der;
        altura = 0;
    }

    public Comparable getElem() {
        return elem;
    }

    public void setElem(Comparable el) {
        elem = el;
    }

    public int getAltura() {
        return altura;
    }

    public void recalcularAltura() {

        if (izquierdo == null && derecho == null) {
            altura = 0;
        } else if (izquierdo != null && derecho != null) {

            if (izquierdo.getAltura() > derecho.getAltura()) {
                altura = izquierdo.getAltura() + 1;
            } else {
                altura = derecho.getAltura() + 1;
            }
        } else {

            if (izquierdo != null) {
                altura = izquierdo.getAltura() + 1;
            } else {
                altura = derecho.getAltura() + 1;
            }
        }
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izq) {
        izquierdo = izq;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL der) {
        derecho = der;
    }

}
