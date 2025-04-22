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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // carga una matriz con filas y columnas deseadas
        Scanner sc = new Scanner(System.in);
        
        int cantF, cantC;
        System.out.println("Ingrese la cantidad de filas de la matriz");
        cantF = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz");
        cantC = sc.nextInt();
        double [][] matriz = new double [cantF][cantC];
        cargarMatriz(matriz);
        mostrarMatriz(matriz);
        matrizFila(matriz);
        matrizColumna(matriz);
        matrizEspiral(matriz);
        matrizZigZag(matriz);
    }
          
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
     
    
    public static void matrizFila (double[][]matriz){
        //muestra la matriz por filas de atras hacia adelante
        int i, j;
        
        for (i = 0; i < matriz.length; i++){
            for (j= matriz[0].length-1; j>=0; j--){
                System.out.print(matriz[i][j] +" ");
        }
            System.out.println(" ");
        }
        
    }
    
    public static void matrizColumna (double [][] matriz){
        //muestra la matriz por columnas de arriba hacia abajo
        int i, j;
        for (j = 0; j<matriz[0].length; j++ ){
            for (i=0; i<matriz.length; i++){
                System.out.print(matriz[i][j] +" ");
            }
            System.out.println(" ");
        }
    }
    
    public static void matrizEspiral (double [][] matriz){
    /* Llena la matriz recibida por parametro en forma de espiral */

    int i, j;
    int   aux = matriz[0].length-1;

    for(i = 1; i < matriz[0].length; i++) {
        for(j = i-1; j < aux; j++) {
            System.out.print(matriz[matriz[0].length-(aux+1)][j]+" ");
        }
        System.out.print("");

        for( j = i-1; j < aux; j++) {
            System.out.print(matriz[j][aux]+" ");
        }
        System.out.println();
        for(j = aux; j >= (i-1); j--) {
            System.out.print(matriz[aux][j]+" ");
        }
       System.out.println();
        aux--;
        for(j = aux; j >= i; j--) {
            System.out.print(matriz[j][matriz[0].length-(aux+2)]+" ");
        }
        System.out.println();

    }
}
        
        
    
    
    
    
        
    
  public static void matrizZigZag(double [][] matriz){
      //muestra la matriz en forma de zigzag
        int j;
        int cont=0;
        boolean sube=true;
        for (int i=0; i<matriz.length;i++){
            if(sube){
                for(j=0;j<matriz.length;j++){
                    System.out.print(matriz[i][j]+" ");
                }
                System.out.println(" ");
                sube= !sube;
            }else if(!sube){
                for(j=matriz.length-1;j>=0;j--){
                    System.out.print(matriz[i][j]+" ");
                }
                sube= !sube;
                System.out.println(" ");
            }
        }
}
    }


    

