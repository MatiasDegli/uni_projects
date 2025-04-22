/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodos.recursivos;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class MayorNum {

    /**
     * @param args the command line arguments
     */
    public static double mayorNum(int n, double [] arrNum){
    double aux, acumMayor=0;
    
    
    if (n < arrNum.length) {
        aux = arrNum[n];
            if (aux > acumMayor) acumMayor = aux;
            System.out.println(aux);
        aux = mayorNum(n + 1, arrNum);
    }
    
    return acumMayor;
    }
    
    
    public static void cargarArr(double[]arr){
        Scanner sc = new Scanner(System.in);
        int i;
        for (i = 0; i < arr.length; i++){
            System.out.println("Ingrese el número de la posición  "+(i+1)+ " del arreglo");
            arr[i] = sc.nextInt();
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int cantNums, n=0;
        
        System.out.println("Ingrese la cantidad de numeros del arreglo");
        cantNums = sc.nextInt();
        
        double [] arrNum= new double [cantNums];
        cargarArr(arrNum);
        
        System.out.println(mayorNum(n, arrNum));
        
        
    }
    
}
