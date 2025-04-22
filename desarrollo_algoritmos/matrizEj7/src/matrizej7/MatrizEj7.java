/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizej7;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class MatrizEj7 {

    
    
    
     public static void cargarMatriz(int[][]matriz){
        Scanner sc = new Scanner(System.in);
        int i, j;
       
        for (i = 0; i < matriz.length; i++){
        
            for (j = 0; j < matriz[0].length; j++){
                System.out.println("Ingrese el número de la posición "+(j+1)+  " de la fila " +(i+1)+ " de la matriz");
                matriz[i][j] = sc.nextInt();
        }
        }
    }

   public static void mostrarMatriz(int[][]matriz){
        
        int i, j;
        
        for (i = 0; i < matriz.length; i++){
            for (j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j] +" ");
        }
            System.out.println(" ");
        }
        
    }
   
   public static void matrizEspiral(int[][]matriz){
        
        int i = 0, j = 0;
        int[][]matrizE = new int [matriz.length][matriz[0].length];
                
             for (j = 0; j < matriz.length; j++){
                
                System.out.print(matriz[0][j] +" ");
            }
            System.out.println();

 for (i = 0; i < matriz.length; i++){
                
                System.out.print(matriz[i][0] +" ");
            }
            System.out.println();
for (j = matriz.length - 1; j >= 0 ; j--){
                
                System.out.print(matriz[matriz.length][j] +" ");
            }
            System.out.println();

for (i = matriz.length - 1; i > 0 ; i--){
                
                System.out.print(matriz[i][0] +" ");
            }
            System.out.println();

for (j = 0; j < matriz.length - 2; j++){
                
                System.out.print(matriz[1][j] +" ");
            }
            System.out.println();

   
    }
    
      /**
     * @param args the command line arguments
     */
     
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int cantF, cantC;
        System.out.println("Ingrese la cantidad de filas de la matriz");
        //cantF = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz");
        //cantC = sc.nextInt();
        int [][] matriz = new int [3][3];
        cargarMatriz(matriz);
        matrizEspiral(matriz);
        mostrarMatriz(matriz);
    }
    
}
