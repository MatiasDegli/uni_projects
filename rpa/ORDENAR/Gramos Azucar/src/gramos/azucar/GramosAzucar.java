/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramos.azucar;

/**
 *
 * @author Zambon
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class GramosAzucar {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Scanner sc = new Scanner(System.in);
        float cucharaG = 18, cucharaP = 7, tazaG = 120, tazaP = 70, grAz;
        DecimalFormat formateador = new DecimalFormat("####.##");
          System.out.print("Ingrese la cantidad de gramos de azucar");
        grAz = sc.nextFloat();
        
        tazaG = grAz / tazaG;
        tazaP = grAz / tazaP;
        cucharaG = grAz / cucharaG;
        cucharaP = grAz / cucharaP;
        
        System.out.print(+grAz+"gramos de azúcar equivalen a " +cucharaG+ "cucharas grandes, " +cucharaP+ "cucharas pequeñas " +tazaG+ "tazas grandes y a " +tazaP+ "tazas pequeñas.");
        
        
    }
    
}
