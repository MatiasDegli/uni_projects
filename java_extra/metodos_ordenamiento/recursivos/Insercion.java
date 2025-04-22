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
public class Insercion {

    
    public static int [] arrInsercion(int [] arr, int i, int fin, int aux){
        
        
        if(fin<arr.length){
            
            if(i==fin-1){       //guarda variable
                aux=arr[fin];
            }
            
            
            if(aux<=arr[i] && i>=0){
                if(i==0){
                    arr[i+1]=arr[i];
                    arr[i]=aux;
                    arr = arrInsercion(arr, fin, fin+1, aux);
                }
                else{       //corrimiento
                    arr[i+1]=arr[i];
                    arr = arrInsercion(arr, i-1, fin, aux);
                }
            }
            else if(aux>arr[fin-1]){
                arr = arrInsercion(arr, fin, fin+1, aux);
            }
            else{       //ubica aux en la posicion correcta si arr[i] es menor que aux
                arr[i+1]=aux;
                arr = arrInsercion(arr, fin, fin+1, aux);
            }
        }
        
        return arr;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        
        int [] arr = new int [10];
        
        for(i=0; i<arr.length;i++){
            arr[i]  = (int)(Math.random()*99);
        }
        
        System.out.println(Arrays.toString(arr));
        
        System.out.println(Arrays.toString(arrInsercion(arr, 0, 1, 0)));
    }
    
}
