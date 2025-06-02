/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lineales.estaticas;

/**
 *
 * @author matia
 */

public class Pila {


    private Object[] arreglo; 
    private int tope;
    private static int TAMANIO = 10;


    public Pila(){
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }


    public boolean apilar(Object nuevoElem){
        boolean exito;

        if(tope+1 >= TAMANIO){
            //La pila esta llena
            exito=false;
        }
        else{
            //La pila tiene espacio disponible
            tope++;
            arreglo[tope]=nuevoElem;
            exito=true;
        }

        return exito;
    }


    public boolean desapilar(){
        boolean exito;

        if(tope==-1){
            //Pila vacia
            exito=false;
        }
        else{
            //Se elimina el valor del tope
            arreglo[tope]=null;
            tope--;
            exito=true;
        }

        return exito;
    }


    public Object obtenerTope(){
        Object elem;

        if(tope==-1){
            elem=null;
        }
        else{
            elem=arreglo[tope];
        }

        return elem;
    }


    public boolean esVacia(){
        return tope == -1;
    }


    public void vaciar(){

        while(tope>-1){
            arreglo[tope]=null;
            tope--;
        }

    }


    public Pila clone(){
        Pila clon = new Pila();

        clon.arreglo=this.arreglo.clone();
        clon.tope=this.tope;

        return clon;
    }


    public String toString(){
        String mensaje="";

        for (int i = 0; i <= tope; i++) {
            mensaje+=arreglo[i].toString();
        }

        return mensaje;
    }

}