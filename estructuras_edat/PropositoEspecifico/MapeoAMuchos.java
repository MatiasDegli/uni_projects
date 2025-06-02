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
public class MapeoAMuchos {
    
    private int TAM=100;
    private int cant=0;
    private NodoHashMapeoM[] tabla = new NodoHashMapeoM[TAM];
    
    
    public void MapeoAMuchos(){
        
    }
    
    
    private int hash(Object valorDominio) {
        // Implementa aquí tu propio algoritmo de hash
        // Este es un ejemplo simple que convierte el objeto a una cadena y calcula el hash
        return Math.abs(valorDominio.toString().hashCode()) % TAM;
    }
    
    
    public boolean asociar(Object valorDominio, Object valorRango){
        boolean exito = false;
        
        int pos = hash(valorDominio);
        
        NodoHashMapeoM aux = tabla[pos];
        
        if(aux!=null){  
            while(aux!=null && !aux.getDominio().equals(valorDominio)){
                aux=aux.getEnlace();
            }
            if(aux!=null){
                Lista listaRango=aux.getRango();
                listaRango.insertar(listaRango.longitud()+1, valorRango);
                exito=true;
            }
        }
        
        return exito;
    }
    
    
    public boolean desasociar(Object valorDominio, Object valorRango){
        boolean exito = false; 
        
        int pos = hash(valorDominio);
        
        NodoHashMapeoM aux = tabla[pos];        
        
        if(aux!=null){
            // La tabla tiene uno o más elementos en la posicion pos
            while(aux.getEnlace()!=null && aux.getDominio().equals(valorDominio)){                
                aux=aux.getEnlace();
            }
            if(aux!=null){
                // Encontró el dominio
                Lista rango = aux.getRango();
                exito = rango.eliminarAparicion(valorRango);
                // Elimina el valor en la lista si lo encuentra                
            }
        }
        
        return exito;
    }
    
    
    public Lista obtenerValor(Object valorDominio){
        Lista rango = new Lista();
        
        int pos = hash(valorDominio);
        
        NodoHashMapeoM aux = tabla[pos];
        
        while(aux!=null && !aux.getDominio().equals(valorDominio)){
            aux=aux.getEnlace();            
        }
        if(aux!=null){
            rango.pasarElementos(rango, aux.getRango());
        }
        
        return rango;
    }
    
    
    public Lista obtenerConjuntoDominio(){
        Lista dominio = new Lista();
        
        if(cant>0){
            for (int i = 0; i < TAM; i++) {
                
                if(tabla[i]!=null){
                    dominio.insertar(dominio.longitud()+1, tabla[i].getDominio());
                    
                    if(tabla[i].getEnlace()!=null){
                        NodoHashMapeoM aux = tabla[i].getEnlace();
                        
                        while(aux!=null){
                            dominio.insertar(dominio.longitud()+1, aux.getDominio());
                            aux=aux.getEnlace();
                        }
                    }
                }
            }
        }        
        
        return dominio;
    }
    
    
    public Lista obtenerConjuntoRango(){
        Lista rango = new Lista();
        
        for (int i = 0; i < TAM; i++) {
            NodoHashMapeoM actual = tabla[i];
            
            if(tabla[i]!=null){
                rango.pasarElementos(rango, actual.getRango());
                NodoHashMapeoM aux = actual.getEnlace();
                
                while(aux!=null){
                    rango.pasarElementos(rango, aux.getRango());
                    aux=aux.getEnlace();
                }
            }
        }
        
        return rango;
    }
    
    
    public boolean insertar(Object valorDominio){
        boolean encontrado = false;
        
        int pos = hash(valorDominio);
        
        NodoHashMapeoM aux = tabla[pos];        

        while(!encontrado && aux!=null){
            encontrado=aux.getDominio().equals(valorDominio);
            aux=aux.getEnlace();
        }

        if(!encontrado){
            tabla[pos] = new NodoHashMapeoM(valorDominio, tabla[pos]);
            cant++;
        }
        
        return !encontrado;
    }
                  
    
    public boolean eliminar(Object valorDominio){
        boolean exito = false;
        
        int pos = hash(valorDominio);
        
        NodoHashMapeoM aux = tabla[pos];        
        
        if(aux.getDominio().equals(valorDominio)){
            tabla[pos] = tabla[pos].getEnlace();
            cant--;
            exito=true;
        }
        else{
            NodoHashMapeoM anterior = aux;
            
            while(aux!=null && !aux.getDominio().equals(valorDominio)){
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
    
    
    public boolean pertenece(Object valorDominio){
        boolean exito = false;
        
        int pos = hash(valorDominio);
        
        NodoHashMapeoM recorre = tabla[pos];
        
        while(recorre!=null && !recorre.getDominio().equals(valorDominio)){
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
       
    
    public void vaciar(){
        tabla=null;
        cant=0;
    }
    
    
    public MapeoAMuchos clone() {
        MapeoAMuchos clon = new MapeoAMuchos();
        clon.TAM = TAM;
        clon.tabla = new NodoHashMapeoM[TAM];

        for (int i = 0; i < TAM; i++) {
            if (tabla[i] != null) {
                clon.tabla[i] = new NodoHashMapeoM(tabla[i].getDominio(), null);
                Lista rangoClon = new Lista();
                rangoClon.pasarElementos(rangoClon, tabla[i].getRango());
                clon.tabla[i].setRango(rangoClon);

                NodoHashMapeoM aux = tabla[i].getEnlace();
                NodoHashMapeoM auxClon = clon.tabla[i];
                
                while (aux != null) {
                    NodoHashMapeoM nuevoNodo = new NodoHashMapeoM(aux.getDominio(), null);
                    rangoClon = new Lista();
                    rangoClon.pasarElementos(rangoClon, aux.getRango());
                    nuevoNodo.setRango(rangoClon);
                    auxClon.setEnlace(nuevoNodo);
                    
                    auxClon = auxClon.getEnlace();
                    aux = aux.getEnlace();
                }
                
                clon.cant++;
            }
        }

        return clon;
    }

    
    
}
