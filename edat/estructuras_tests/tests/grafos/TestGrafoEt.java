/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.grafos;

import grafos.dinamicos.etiquetados.GrafoEtiquetado;
import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class TestGrafoEt {

    public static void main(String[] args) {

        GrafoEtiquetado g = new GrafoEtiquetado();

        g.insertarVertice("A");
        g.insertarVertice("B");
        g.insertarVertice("D");
        g.insertarVertice("C");
        g.insertarVertice("E");
        g.insertarVertice("F");
        g.insertarVertice("G");

        g.insertarArco("A", "B", 1);
        g.insertarArco("B", "C", 2);
        g.insertarArco("C", "F", 3);
        g.insertarArco("A", "D", 7);
        g.insertarArco("A", "E", 6);
        g.insertarArco("E", "F", 6);
        g.insertarArco("D", "F", 9);
        g.insertarArco("A", "G", 1);
        g.insertarArco("G", "F", 2);

        System.out.println(g.toString());

        System.out.println("\n -------------------------------- \n");

        g.eliminarVertice("G");

        System.out.println(g.toString());
        
        //System.out.println(g.primerCaminoMenorPeso("A", "F", 15, 4).toString());

        //System.out.println(g.primerCaminoMenorPesoLong("A", "F", 15, 5).toString());

        //System.out.println(g.primerCaminoPesoEntre("A", "F", 10, 13).toString());
    }

}
