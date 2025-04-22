/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calificacion;

/**
 *
 * @author Zambon
 */

import java.util.Scanner; 
public class Calificacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int calificacion, cantEstudiantes, i;
        String nombreEstudiante, respuestas;
        calificacion = 0;
        System.out.println("Ingresar la cantidad de estudiantes");
        cantEstudiantes = sc.nextInt();
        
        
        for (i = 0; i < 5; i++){
        System.out.println("Seleccione si la respuesta es C, I o S");
        respuestas = sc.next();
                
    }
    
}
