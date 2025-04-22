/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_2;

/**
 *
 * @author matia
 */
public class Estudiante implements Runnable {

    private String nombre;
    private MonitorControl monitor;

    public Estudiante(String nom, MonitorControl mon) {
        nombre = nom;
        monitor = mon;
    }

    public void run() {

        try {
            monitor.ingresaEstudiante();

            estudiando();

            monitor.saleEstudiante();
            
        } catch (InterruptedException Exc) {

        }

    }

    public void estudiando() throws InterruptedException {
        System.out.println("El estudiante " + nombre + " estudia.");

        Thread.sleep(5000);

        System.out.println("El estudiante " + nombre + " termina de estudiar.");
    }

}
