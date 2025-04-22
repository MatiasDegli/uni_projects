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
public class BurbujaMejorado {
    
    
    public static void intercambio(int i, int [] arr){
        int aux;
        aux=arr[i];
        arr[i]=arr[i+1];
        arr[i+1]=aux;
    }
    
    
    public static void ordenBurbujaMejorada(int [] arr){
        int i=0, j;
        boolean ordenado=false;
        
        while((i<arr.length) && (ordenado==false)){
            ordenado=true;
            
            for(j=0; j<arr.length-i-1; j++){
                
                if(arr[j]>arr[j+1]){
                    ordenado = false;   
                    intercambio (j, arr);
                }
                
            }
            
            i=i+1;   
        }    
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] arr={89, 45, 68, 90, 29, 34, 17};
        
        System.out.println(Arrays.toString(arr));
        ordenBurbujaMejorada(arr);
        System.out.println(Arrays.toString(arr));   
    }
    
}

