/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.especificas;

import PropositoEspecifico.MapeoAMuchos;

/**
 *
 * @author matia
 */
public class TestMapeoMuchos {
    
    public static void main(String[] args) {
        
        

        MapeoAMuchos mapa = new MapeoAMuchos();
        
        mapa.insertar(2);
        mapa.insertar(9);
        mapa.insertar(10);
        
        System.out.println("Dominio: "+mapa.obtenerConjuntoDominio().toString());             
        
        mapa.asociar(2, 4);
        mapa.asociar(9, 81);
        mapa.asociar(10, 100);
        mapa.asociar(9, 729);
        
        MapeoAMuchos clon = mapa.clone();
        
        System.out.println("El dominio del clon es: "+clon.obtenerConjuntoDominio().toString() + " "
                + "y el Rango del clon es: "+ clon.obtenerConjuntoRango().toString());
        
        System.out.println("Rango: "+mapa.obtenerConjuntoRango().toString());
        
        mapa.desasociar(10, 100);
        
        System.out.println("Rango: "+mapa.obtenerConjuntoRango().toString());
        
        System.out.println("Valor de 9: "+mapa.obtenerValor(9).toString());
        
        mapa.eliminar(9);
        
        System.out.println("Dominio: "+mapa.obtenerConjuntoDominio().toString()+" y Rango: "+mapa.obtenerConjuntoRango().toString());
        
        System.out.println("Pertenece 10? "+mapa.pertenece(10));
        
    }
    
    
    
    
    
}
