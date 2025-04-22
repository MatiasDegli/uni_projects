/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_8;

/**
 *
 * @author matia
 */
public class Main {
    public static void main(String[] args) {
        // Crear instancias del controlador y las líneas
        ControladorProduccion controlador = new ControladorProduccion();
        LineaElectrico lineaElectrico = new LineaElectrico(controlador);
        LineaMecanico lineaMecanico = new LineaMecanico(controlador);

        // Asignar las líneas al controlador
        controlador.setLineas(lineaElectrico, lineaMecanico);
        
        // Crear y iniciar el hilo del controlador
        Thread controladorThread = new Thread(controlador);
        controladorThread.start();
        /*
        // Probar con un solo producto eléctrico y mecánico
        // Crear un producto eléctrico
        Electrico productoElectrico = new Electrico(lineaElectrico);
        

        // Crear un producto mecánico (suponiendo que tengas una clase Mecánico similar)
        Mecanico productoMecanico = new Mecanico(lineaMecanico); // Asegúrate de tener esta clase
        productoMecanico.start();
        productoElectrico.start();
        */
        ///*
        // Probar con un loop que genere 50 productos aleatorios
        for (int i = 0; i < 50; i++) {
            // Generar un producto aleatorio entre eléctrico y mecánico
            if (Math.random() < 0.5) {
                Electrico productoRandomElectrico = new Electrico(lineaElectrico);
                productoRandomElectrico.start();
            } else {
                Mecanico productoRandomMecanico = new Mecanico(lineaMecanico); // Asegúrate de tener esta clase
                productoRandomMecanico.start();
            }

            // Esperar un poco antes de generar el siguiente producto
            try {
                Thread.sleep(100); // Ajusta el tiempo según sea necesario
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //*/
    }
}