/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.estaticas;

/**
 *
 * @author matia
 */
public class Cola {


    private Object[] arreglo;
    private static final int TAMANIO=10;
    private int frente;
    private int fin;


    public Cola(){
        arreglo = new Object[TAMANIO];
        frente = 0;
        fin = 0;
    }


    public boolean poner(Object newElem){
        boolean exito;

        if(((fin+1)%TAMANIO==frente)){
            exito=false;
        }
        else{
            arreglo[fin]=newElem;
            fin = (fin+1)%TAMANIO;
            exito=true;
        }

        return exito;
    }


    public boolean sacar(){
        boolean exito;

        //Cola vacia
        if(fin==frente){
            exito=false;
        }
        else{
            arreglo[frente]=null;
            frente = (frente+1)%TAMANIO;
            exito=true;
        }

        return exito;
    }


    public Object obtenerFrente(){
        Object elem;

        if(fin==frente){
            elem=null;
        }
        else{
            elem = arreglo[frente];
        }

        return elem;
    }


    public boolean esVacia(){

        return frente==fin; 

    }


    public void vaciar(){

        if(frente!=fin){
            while(arreglo[frente]!=null){
            arreglo[frente]=null;
            frente=(frente+1)%TAMANIO;
            }
        }

    }


    public Cola clone(){
        Cola clon = new Cola();
        int i = frente;

        if(frente!=fin){

            while(arreglo[i]!=null) {
                clon.arreglo[i]=arreglo[i];
                i=(i+1)%TAMANIO;
            }

            clon.frente=frente;
            clon.fin=fin;
        }

        return clon;
    }


    public String toString(){
        String mensaje="[";
        int i = frente;

        if(frente==fin){
            mensaje="Cola vacia"; 
        }
        else{
            while(arreglo[(i+1)%TAMANIO]!=null) {
                mensaje+=arreglo[i]+", ";
                i=(i+1)%TAMANIO;
            }
            mensaje+=arreglo[i]+"]";            
        }

        return mensaje;
    }

}
