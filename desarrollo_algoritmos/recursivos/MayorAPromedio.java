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
public class MayorAPromedio {

    
    public static void cargarArr(int[]arr){
        Scanner sc = new Scanner(System.in);
        int i;
        for (i = 0; i < arr.length; i++){
            System.out.println("Ingrese el numero de la posicion  "+(i+1)+ " del arreglo");
            arr[i] = sc.nextInt();
        }
    }
    
    
    public static double promedio(int i, double prom, int [] arr){
        
        if (i < arr.length){
            prom+=arr[i];
            prom=promedio(i+1, prom, arr);
        }
        else{
            prom=prom/arr.length;
        }
        
        return prom;
    }
    
    
    public static int mayoresAProm(int i, double prom, int [] arr, int cantMayor){
        
        if(i < arr.length){
            if(arr[i]>prom){
                cantMayor=mayoresAProm(i+1, prom, arr, cantMayor+1);
            }
            else{
                cantMayor=mayoresAProm(i+1, prom, arr, cantMayor);
            }
        }
        
        return cantMayor;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int cantNums;
        double prom;
        System.out.println("Ingrese la cantidad de numeros del arreglo");
        cantNums=sc.nextInt();
        int [] arr = new int [cantNums];
        cargarArr(arr);
        prom = promedio(0, 0, arr);
        System.out.println(prom);
        System.out.println("La cantidad de numeros del arreglo mayores que el promedio es de "+mayoresAProm(0,prom,arr,0));
    }
}
