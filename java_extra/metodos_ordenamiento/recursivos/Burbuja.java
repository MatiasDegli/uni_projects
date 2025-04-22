/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodos.recursivos;

import java.util.Arrays;

/**
 *
 * @author Zambon
 */
public class Burbuja {

    public static int [] arrBurbuja(int[] arr, int i, int fin){
        int aux;
        
        if(fin>1){
            if(i<fin-1 && arr[i]>arr[i+1]){
                aux=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=aux;
                arr=arrBurbuja(arr, i+1, fin);
            }
            else if(i<fin-1){
                arr=arrBurbuja(arr, i+1, fin);
            }
            else if(i==fin-1){
                arr=arrBurbuja(arr, i-(fin-1), fin-1);
            }
        }
        
        return arr;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        
        int [] arr = new int [15];
        
        for(i=0; i<arr.length;i++){
            arr[i]  = (int)(Math.random()*99);
        }
        
        System.out.println(Arrays.toString(arr));
        
        System.out.println(Arrays.toString(arrBurbuja(arr, 0, arr.length)));
    }
    
}
