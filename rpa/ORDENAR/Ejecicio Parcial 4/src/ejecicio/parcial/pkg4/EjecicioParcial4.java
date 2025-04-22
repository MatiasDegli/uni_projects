/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecicio.parcial.pkg4;

/**
 *
 * @author Zambon
 */
import java.util.Scanner;
public class EjecicioParcial4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int mujeres3Horas = 0, cantM = 0, cantH = 0;
        char sexo, seguir;
        double horasGuardia, promedioH = 0, promedioM = 0, horasMujeres, horasHombres;
        horasMujeres = 0;
        horasHombres = 0;
        
        do {
            System.out.println("Ingrese la cantidad de horas de guardia del bombero");
            horasGuardia = sc.nextInt();
            System.out.println("Ingrese el sexo del bombero, M para mujer, H para hombre");
            sexo = sc.next().charAt(0);
            switch (sexo){
                case 'M': horasMujeres += horasGuardia; cantM+=1; break;
                case 'H': horasHombres += horasGuardia; cantH+=1; break;
            
            
        }
            if (sexo == 'M'&& horasGuardia > 3) mujeres3Horas +=1;  
            System.out.println("¿desea seguir ingresando bomberos? ingrese Y para si o N para no");
            seguir = sc.next().charAt(0);
    }while(seguir != 'N');
    promedioH = horasHombres / cantH;
    promedioM = horasMujeres / cantM;
    
    System.out.println("El promedio de horas de guardia de mujeres es de" +promedioM+ "Y el promedio de horas de guardia de hombres es de" +promedioH);
    System.out.println("La cantidad de mujeres que hacen más de 3 horas de guardia es de " +mujeres3Horas);
}
}
