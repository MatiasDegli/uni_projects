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
public class SeleccionR {

    
    public static int buscaMenor(int [] arr, int inicio, int menor, int posMenor){
        
        if(inicio<arr.length){
            
            if(arr[inicio]<menor){
                menor=arr[inicio];
                posMenor=inicio;
                posMenor = buscaMenor(arr, inicio+1, menor, posMenor);
            }
            else{
                posMenor = buscaMenor(arr, inicio+1, menor, posMenor);
            }
        }
        
        return posMenor;
    }
    
    
    public static int [] arrSeleccion(int [] arr, int inicio){
        int posMenor, aux;
        
        if(inicio<arr.length-1){
            aux=arr[inicio];
            posMenor=buscaMenor(arr, inicio, arr[inicio], inicio);
            arr[inicio]=arr[posMenor];
            arr[posMenor]=aux;
            arr=arrSeleccion(arr, inicio+1);
        }
        
        return arr;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        
        int [] arr = new int [20];
        
        for(i=0; i<arr.length;i++){
            arr[i]  = (int)(Math.random()*99);
        }
        
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrSeleccion(arr, 0)));
    }
    
}
