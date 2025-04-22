/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg7;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TP7 {

    /**
     * @param args the command line arguments
     */
    
    public static int calificacion (int correcto, int incorrecto, int nulo){
    
    int notaFinal;
    
    correcto = correcto * 2;
    incorrecto = incorrecto * (-1);
    nulo = nulo * 0;
    
    notaFinal = correcto + incorrecto; 
    
    if (notaFinal < 0) notaFinal = 0;
    
    return notaFinal;}
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int cantAlumnos, i=1, correcta, incorrecta, nula, notaFinal;
        String nombre;
        
        System.out.println("Ingrese la cantidad de alumnos");
        cantAlumnos = sc.nextInt();
        
        for (i = 1; i <= cantAlumnos; i++){
         
            System.out.println("Ingrese el nombre del alumno");
            nombre = sc.next();
            System.out.println("Ingrese la cantidad de respuestas correctas que obtuvo");
            correcta = sc.nextInt();
            System.out.println("Ingrese la cantidad de respuestas incorrectas que obtuvo");
            incorrecta = sc.nextInt();
            System.out.println("Ingrese la cantidad de respuestas nulas que obtuvo");
            nula = sc.nextInt();
            
            
            
            notaFinal = calificacion(correcta, incorrecta, nula);
            
            if (notaFinal < 6) System.out.println("Lo siento, "+nombre+" estudie más para la próxima, su nota es " +notaFinal);
            else System.out.println("Felicidades!, "+nombre+" aprobaste, tu nota es " +notaFinal);
            
            
            
        };
        
        //if (correcta + incorrecta + nula < 5) System.out.println("No puede haber más de  respuestas");
        
        
    }
    
}
