/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas;

import lineales.dinamicas.Lista;


/**
 *
 * @author matia
 */
public class TablaHashA {
    
    private Nodo[] tabla; 
    private final int TAM=10;    
    private int cant = 0;
    
    
    public void TablaHashA(){
        tabla = new Nodo[TAM];
    }
    
    
    public boolean insertar(Object elem){
        boolean encontrado = false;
        
        int pos = elem.hashCode()%TAM;
        
        Nodo aux = tabla[pos];
        
        while(!encontrado && aux!=null){
            encontrado=aux.getElem().equals(elem);
            aux=aux.getEnlace();
        }
        
        if(!encontrado){
            tabla[pos]=new Nodo(elem, tabla[pos]);
            cant++;
        }
        
        return !encontrado;
    }
                  
    
    public boolean eliminar(Object elem){
        boolean exito = false;
        
        int pos = elem.hashCode()%TAM;
        
        Nodo aux = tabla[pos];        
        
        if(aux.getElem().equals(elem)){
            tabla[pos] = tabla[pos].getEnlace();
            cant--;
            exito=true;
        }
        else{
            Nodo anterior = aux;
            
            while(aux!=null && !aux.getElem().equals(elem)){
                anterior = aux;
                aux=aux.getEnlace();
            }        
            if(aux!=null){
                anterior.setEnlace(aux.getEnlace());
                cant--;
                exito=true;
            }
        }
        
        return exito;
    }
    
    
    public boolean pertenece(Object elem){
        boolean exito = false;
        
        int pos = elem.hashCode()%TAM;
        
        Nodo recorre = tabla[pos];
        
        while(recorre!=null && !recorre.getElem().equals(elem)){
            recorre=recorre.getEnlace();
        }
        
        if(recorre!=null){
            exito=true;
        }
            
        return exito;
    }
    
    
    public boolean esVacia(){
        return cant==0;
    }
    
    
    public Lista listar(){
        Lista lis = new Lista();
        
        for (int i = 0; i < TAM; i++) {
            if(tabla[i]!=null){
                lis.insertar(lis.longitud()+1, tabla[i].getElem());
                if(tabla[i].getEnlace()!=null){
                    Nodo siguiente = tabla[i].getEnlace();
                    while(siguiente!=null){
                        lis.insertar(lis.longitud()+1, siguiente.getElem());
                        siguiente=siguiente.getEnlace();
                    }
                }
            }
        }
        
        return lis;
    }
    
    
    public void vaciar(){
        tabla=null;
        cant=0;
    }
    
}
