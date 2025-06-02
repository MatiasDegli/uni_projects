/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PropositoEspecifico;

import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class NodoHashMapeoM {
    
    private Object dominio;
    private Lista rango;
    private NodoHashMapeoM enlace;
    
    
    public NodoHashMapeoM(Object dom, NodoHashMapeoM en){
        dominio=dom;
        rango=new Lista();
        enlace=en;
    }
    
    
    public Object getDominio(){
        return dominio;
    }
    
    
    public NodoHashMapeoM getEnlace(){
        return enlace;
    }            
    
    
    public Lista getRango(){
        return rango;
    }
    
    
    public void setDominio(Object dom){
        dominio=dom;
    }
    
    
    public void setEnlace(NodoHashMapeoM en){
        enlace=en;
    }
    
    
    public void setRango(Lista r){
        rango=r;
    }
    
}
