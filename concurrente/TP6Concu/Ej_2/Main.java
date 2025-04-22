/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_2;

/**
 *
 * @author matia
 */
public class Main {

    public static void main(String[] args) {

        // Crear el monitor de control para las mesas
        MonitorControl monitor = new MonitorControl();

        // Nombres de los estudiantes
        String[] nombresEstudiantes = {
            "Juan", "Ana", "Pedro", "Luisa", "Carlos", "Sofía", "Martín", "Laura", "Javier", "María",
            "Lucas", "Clara", "Pablo", "Verónica", "Tomás", "Camila", "Andrés", "Valentina", "Miguel", "Paula"
        };

        // Crear e iniciar hilos de estudiantes
        for (int i = 0; i < nombresEstudiantes.length; i++) {
            Estudiante estudiante = new Estudiante(nombresEstudiantes[i], monitor);
            Thread hiloEstudiante = new Thread(estudiante);
            hiloEstudiante.start();

            // Pausa breve entre la creación de hilos para simular llegada gradual
            try {
                Thread.sleep(500); // 1 segundo de pausa entre la llegada de cada estudiante
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
