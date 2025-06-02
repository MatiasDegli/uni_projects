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
public class ABB {
    
    private NodoABB raiz;
    
    
    public boolean insertar(Comparable newElem){
        boolean exito;
        
        if(esVacio()){
            raiz=new NodoABB(newElem, null, null);
        }
        
        exito=insertarAux(true, newElem, raiz);
        
        return exito;
    }
    
    
    private boolean insertarAux(boolean exito, Comparable elem,  NodoABB recorre){
        
        if(recorre!=null){
            
            if(elem.compareTo(recorre.getElem())<0){
            
                if(recorre.getIzquierdo()==null){
                    recorre.setIzquierdo(new NodoABB(elem, null, null));
                }
                else{
                    exito=insertarAux(exito, elem, recorre.getIzquierdo());
                }
            }
            else if(elem.compareTo(recorre.getElem())>0){
                if(recorre.getDerecho()==null){
                    recorre.setDerecho(new NodoABB(elem, null, null));
                }
                else{
                    exito=insertarAux(exito, elem, recorre.getDerecho());
                }
            }
            else{
                exito=false;
            }
                
        }
        
        return exito;
    }
    
    
    public boolean pertenece(Comparable elem){
        boolean exito;
        
        exito=perteneceAux(elem, raiz);
        
        return exito;
    }
    
    
    private boolean perteneceAux(Comparable elem, NodoABB recorre){
        boolean exito = false;
        
        if(recorre!=null){
            
            if(recorre.getElem().compareTo(elem)==0){
                exito=true;
            }
            else if(recorre.getElem().compareTo(elem)<0){
                exito=perteneceAux(elem, recorre.getDerecho());
            }
            else{
                exito=perteneceAux(elem, recorre.getIzquierdo());
            }
        }
        
        return exito;
    }
    
    
    public boolean eliminar(Comparable elem){
        boolean exito;
        
        exito=eliminarAux(elem, raiz);
        
        return exito;
    }
    
    
    private boolean eliminarAux(Comparable elem, NodoABB recorre){
        boolean exito=false;
        
        if(recorre!=null){
            
            NodoABB izq = recorre.getIzquierdo();
            NodoABB der = recorre.getDerecho();
            
            if(recorre.getElem().compareTo(elem)==0){
                
                NodoABB padre = obtenerPadre(elem, raiz);
                
                System.out.println(padre.getElem());
                
                if(izq==null && der==null){                    
                    sinHijo(padre, recorre);
                    exito=true;
                }
                else if(izq!=null && der==null){
                    if(padre.getIzquierdo()==recorre){
                        padre.setIzquierdo(izq);
                    }
                    else{
                        padre.setDerecho(izq);
                    }
                    exito=true;
                }
                else if(izq==null && der!=null){
                    if(padre.getIzquierdo()==recorre){
                        padre.setIzquierdo(der);
                    }
                    else{
                        padre.setDerecho(der);
                    }
                    exito=true;
                }
                else{
                    while(der.getIzquierdo()!=null){
                        der=der.getIzquierdo();
                    }
                    eliminarAux(der.getElem(), raiz);
                    recorre.setElem(der.getElem());
                    
                    exito=true;
                }
            }
            else if(recorre.getElem().compareTo(elem)<0){
                exito=eliminarAux(elem, recorre.getDerecho());
            }
            else{
                exito=eliminarAux(elem, recorre.getIzquierdo());
            }
        }
        
        return exito;
    }
    
    
    private void sinHijo(NodoABB padre, NodoABB actual){
        
        if(padre.getIzquierdo()==actual){
            padre.setIzquierdo(null);
        }
        else{
            padre.setDerecho(null);
        }
    }
    
    
    private NodoABB obtenerPadre(Comparable elem, NodoABB recorre){
        NodoABB padre = null;
        
        if(recorre!=null){
            
            if(recorre.getIzquierdo()!=null && recorre.getIzquierdo().getElem().compareTo(elem)==0 || 
                recorre.getDerecho()!=null && recorre.getDerecho().getElem().compareTo(elem)==0){
                
                padre=recorre;
            }
            else if(recorre.getElem().compareTo(elem)<0){
                padre=obtenerPadre(elem, recorre.getDerecho());
            }
            else{
                padre=obtenerPadre(elem, recorre.getIzquierdo());
            }
        }
        
        return padre;
    }
    
    
    public Lista listar(){
        Lista lis = new Lista();
        
        listarAux(lis, raiz);
        
        return lis;
    }
    
    
    private void listarAux(Lista lis, NodoABB recorre){
        
        if(recorre!=null){
            listarAux(lis, recorre.getIzquierdo());
            lis.insertar(lis.longitud()+1, recorre.getElem());
            listarAux(lis, recorre.getDerecho());
        }
        
    }
    
    
    public Lista listarRango(Comparable piso, Comparable techo){
        Lista lis = new Lista();
        
        listarRangoAux(lis, piso, techo, raiz);
        
        return lis;
    }
    
    
    private void listarRangoAux(Lista lis, Comparable piso, Comparable techo, NodoABB recorre){
        
        if(recorre!=null && recorre.getElem().compareTo(techo)<=0){
            listarRangoAux(lis, piso, techo, recorre.getIzquierdo());
            
            if(recorre.getElem().compareTo(piso)>=0){
                lis.insertar(lis.longitud()+1, recorre.getElem());
            }
            
            listarRangoAux(lis, piso, techo, recorre.getDerecho());
        }
        
    }
    
    
    public Comparable minimoElem(){
        Comparable min;
        NodoABB recorre=raiz;
        
        if(esVacio()){
            min=null;
        }
        else{
            if(recorre.getIzquierdo()!=null){
                while(recorre.getIzquierdo()!=null){
                    recorre=recorre.getIzquierdo();
                }
            }
            min=recorre.getElem();
        }
        
        return min;
    }
    
    
    public Comparable maximoElem(){
        Comparable max;
        NodoABB recorre=raiz;
        
        if(esVacio()){
            max=null;
        }
        else{
            if(recorre.getDerecho()!=null){
                while(recorre.getDerecho()!=null){
                    recorre=recorre.getDerecho();
                }
            }
            max=recorre.getElem();
        }
        
        return max;
    }
    
    
    public boolean esVacio(){
        return raiz==null;
    }
    
    
    public String toString(){
        
        String msj=toStringAux("", raiz);
        
        return msj;
    }
    
    
    private String toStringAux(String msj, NodoABB recorre){
        String cadena;
        
        if(recorre!=null){
        
            if(recorre.getIzquierdo()!=null){
                cadena=recorre.getElem() + " es padre de "
                    + recorre.getIzquierdo().getElem() +" (izq)";
                
                if(recorre.getDerecho()!=null){
                    cadena+= " y de " + recorre.getDerecho().getElem()+" (der)";
                }
            }
            else if(recorre.getDerecho()!=null){
                cadena=recorre.getElem() + " es padre de "
                    + recorre.getDerecho().getElem() +" (der)";
            }
            else{
                cadena = recorre.getElem() + " no tiene hijos";
            }
            
            cadena+="\n";
            
            msj+=cadena;
            
            msj=toStringAux(msj, recorre.getIzquierdo());
            msj=toStringAux(msj, recorre.getDerecho());
        }
        
        return msj;
    }
    
}
