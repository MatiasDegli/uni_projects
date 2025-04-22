/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_4;

/**
 *
 * @author matia
 */
public class Main {

    public static void main(String[] args) {

        // Crear impresoras
        Impresora imp1 = new Impresora("a144");
        Impresora imp2 = new Impresora("b21");
        Impresora imp3 = new Impresora("b11");

        // Colocarlas en un array
        Impresora[] impresoras = {imp1, imp2, imp3};

        // Crear gestores de impresoras
        GestorImpresoras gestor = new GestorImpresoras(impresoras);

        // Crear hilos (clientes) que intentarán imprimir
        Thread c1 = new Thread(gestor, "Matias");
        Thread c2 = new Thread(gestor, "Mateo");
        Thread c3 = new Thread(gestor, "Juan");
        Thread c4 = new Thread(gestor, "Simon");
        Thread c5 = new Thread(gestor, "Roberto");

        // Iniciar los hilos
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}

