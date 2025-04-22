/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.normales;

/**
 *
 * @author Zambon
 */
public class Piramide {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
        public static void main(String[] args) {
        for (int fila = 1; fila <= 5; fila++) {
            for (int colum = 1; colum <= fila; colum++) {
                System.out.print(colum);
            }
            System.out.println(" ");

        }
    
}
}

