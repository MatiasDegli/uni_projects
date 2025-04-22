/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;
import java.util.Scanner;
/**
 *
 * @author Zambon
 */
public class Matriz {

    /**
     * @param matriz
     */
    
    for (j = 0; j < matriz[0].length; j++){
                
                System.out.print(matriz[0][j] +" ");
            }
            System.out.println();
            
            
            for (i = 1; i < matriz.length - 1; i++){
            
            System.out.print(matriz[i][matriz[0].length - 1] +" ");
            }
            System.out.print(matriz[i][matriz[0].length - 2]);
            
            System.out.println();
            
            
            for (j = matriz[0].length - 3; j > 0; j--){
            
            System.out.print(matriz[matriz.length - 1][j] +" ");
            
            }
            
            for (i = matriz.length - 2; i > 0; i--){
            
            System.out.print(matriz[i][0] +" ");
            
            }
            
            System.out.println();
            
            for (j = 2; j < matriz[0].length-2; j++){
            
            System.out.print(matriz[1][j] +" ");
            }
           
            System.out.print(matriz[2][2] +" ");
            System.out.print(matriz[2][1] +" ");
            
    public static void cargarMatriz(double[][]matriz){
        Scanner sc = new Scanner(System.in);
        int i, j;
       
        for (i = 0; i < matriz.length; i++){
        
            for (j = 0; j < matriz[0].length; j++){
                System.out.println("Ingrese el número de la posición "+(j+1)+  " de la fila " +(i+1));
                matriz[i][j] = sc.nextDouble();
        }
        }
    }
            
    
    public static void mostrarMatriz(double[][]matriz){
        
        int i, j;
        
        for (i = 0; i < matriz.length; i++){
            for (j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j] +" ");
        }
            System.out.println(" ");
        }
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int cantF, cantC;
        System.out.println("Ingrese la cantidad de filas de la matriz");
        cantF = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz");
        cantC = sc.nextInt();
        double [][] matriz = new double [cantF][cantC];
        cargarMatriz(matriz);
        mostrarMatriz(matriz);
    }
    
}
