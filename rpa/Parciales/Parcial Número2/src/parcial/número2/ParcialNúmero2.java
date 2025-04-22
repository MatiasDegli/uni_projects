/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.número2;

/**
 *
 * @author Zambon
 */
import java.util.Scanner;
public class ParcialNúmero2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int cantVigas, puenteA = 0, puenteC = 0, vigasA=0, 
                vigasC=0, promedioA=0, promedioC=0, mayorA20=0;
        char tipoPuente;
        boolean ingresoPuente;
        Scanner sc = new Scanner(System.in);
        do {
        System.out.println("Ingrese la cantidad de vigas");
        cantVigas = sc.nextInt();
        System.out.println("Ingrese el tipo de puente, C: concreto y A: acero");
        tipoPuente = sc.next().charAt(0);
        switch (tipoPuente){
            case 'A': puenteA+=1; vigasA+= cantVigas; 
            case 'C': puenteC+=1; vigasC+= cantVigas;
    }
        if (tipoPuente == puenteA) promedioA = vigasA / puenteA;
        
        if (tipoPuente == puenteC) promedioC = vigasC / puenteC;
        
        if (tipoPuente == puenteC && cantVigas > 20) mayorA20+=1;
        
        System.out.println("el promedio de vigas de acero por puente es de "+promedioA+
                " , el promedio de vigas de concreto por puente es de "+promedioC+
                " y la cantidad de puentes de concreto con más de 20 vigas es de "+mayorA20);
        
        System.out.println("¿Quiere seguir ingresando puentes? true(si), false(no)");
        ingresoPuente = sc.nextBoolean();
        }while (ingresoPuente=true);
        
        
   }
}
   