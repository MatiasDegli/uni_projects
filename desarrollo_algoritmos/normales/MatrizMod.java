/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.normales;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class MatrizMod {

    
    
    
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
    
     
     public static void cargarArr(int[]arr){
        Scanner sc = new Scanner(System.in);
        int i;
        for (i = 0; i < arr.length; i++){
            System.out.println("Ingrese el número de la posición  "+(i+1)+ " del arreglo");
            arr[i] = sc.nextInt();
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

     public static void mostrarArr(int[]arr){
        int i;
        for (i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
        }
    }
      
     
     public static void reemplazaFila(int[][]matriz, int[]arr, int filaMod){
     
     int i = filaMod - 1, j;
      for (j = 0; j < matriz[0].length; j++){
                matriz[i][j] = arr[j];
        }
     }
     
     
     public static void salida(int[][]matrizInt, int[]arrInt, int filaMod){
        cargarMatriz(matrizInt);
        cargarArr(arrInt);
        System.out.println();
        System.out.println("A continuación se mostrará la matriz y el arreglo originales");
        mostrarMatriz(matrizInt);
        System.out.println();
        mostrarArr(arrInt);
        System.out.println();
        reemplazaFila(matrizInt, arrInt, filaMod);
        System.out.println();
        System.out.println("Ahora se mostrará la matriz modificada");
        mostrarMatriz(matrizInt);
     }
     
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int cantF, cantC, filaMod;
        System.out.println("Ingrese la cantidad de filas de la matriz");
        cantF = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz");
        cantC = sc.nextInt();
        System.out.println("Ingrese el número de la fila de la matriz que quiera reemplazar por los elementos del arreglo");
        filaMod = sc.nextInt();
        int [][] matrizInt = new int [cantF][cantC];
        int[] arrInt = new int [cantC];
        salida(matrizInt, arrInt, filaMod);
    }
    
}
