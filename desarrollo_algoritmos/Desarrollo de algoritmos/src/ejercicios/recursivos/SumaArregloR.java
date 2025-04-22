/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.recursivos;
import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class SumaArregloR {

    /**
     * @param args the command line arguments
     */
    public static double sumArr(int i, int j, double [][] matrizNum, double acumSum){
    
        if (i < matrizNum.length && j < matrizNum[0].length) {
            acumSum += matrizNum[i][j];
            acumSum = sumArr(i, j + 1, matrizNum, acumSum);
            if (j == matrizNum[0].length-1){
                System.out.println("La suma de los elementos de la fila 1 de la matriz es: "+acumSum);
                acumSum-=acumSum;
                acumSum = sumArr(i + 1, (j - (matrizNum[0].length - 1)), matrizNum, acumSum);
            }
        }
        return acumSum;
    }
    
    
    
     public static void cargarMatriz(double[][]matriz){
        Scanner sc = new Scanner(System.in);
        int i, j;
       
        for (i = 0; i < matriz.length; i++){
        
            for (j = 0; j < matriz[0].length; j++){
                System.out.println("Ingrese el numero de la posicion "+(j+1)+  " de la fila " +(i+1));
                matriz[i][j] = sc.nextDouble();
        }
        }
    }

    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int cantF, cantC, i=0, j=0;
        double suma = 0;
        
        System.out.println("Ingrese la cantidad de filas de la matriz");
        cantF = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz");
        cantC = sc.nextInt();
        
        double [][] matrizNum= new double [cantF][cantC];
        cargarMatriz(matrizNum);
        sumArr(i, j, matrizNum, suma);
    }
}

