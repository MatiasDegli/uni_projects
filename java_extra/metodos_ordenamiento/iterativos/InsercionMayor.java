/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodos.iterativos;

import java.util.Arrays;

/**
 *
 * @author Zambon
 */
public class InsercionMayor {


    public static void ordenarInsercion(int [] arr){
        int i, aux, j;
        
        for(i=1;i<arr.length;i++){
            aux = arr[i];
            j=i;
            
            while(j>0 && arr[j-1]<aux){
                arr[j]=arr[j-1];
                j--;
            }
            
            arr[j]=aux;
            
        }
        
    }


    public static void main(String[] args) {
        // TODO code application logic here
        
        int [] arr = {7, 6, 11, 17, 3, 15, 5, 19, 30, 14};
        
        System.out.println(Arrays.toString(arr));
        ordenarInsercion(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    
}
