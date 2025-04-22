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
public class SeleccionMayor {
    
    
    public static int buscaMayor(int [] arr, int i){
        int mayor=arr[i], posMayor=i;
        
        for(i=i; i<arr.length; i++){
            
            if(arr[i]>mayor){
                mayor=arr[i];
                posMayor=i;   
            }
            
        }
        
        return posMayor;
    }
    
    
    public static void intercambiar(int [] arr, int posMayor, int i){
        
        int aux;
        aux=arr[i];
        arr[i]=arr[posMayor];
        arr[posMayor]=aux;
        
    }
    
    
    public static void ordenarSeleccion(int [] arr){
        int i, posMayor;
        
        for(i=0; i<arr.length; i++){
            posMayor=buscaMayor(arr, i);
            intercambiar(arr, posMayor, i);
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int [] arr = {7, 6, 11, 17, 3, 15, 5, 19, 30, 14};
        
        System.out.println(Arrays.toString(arr));
        ordenarSeleccion(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    
}
