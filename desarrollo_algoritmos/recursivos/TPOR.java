/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.recursivos;

import java.util.Arrays;


/**
 *
 * @author Zambon
 */
public class TPOR {

    
    public static int[][] cargarMatriz(int n, int cont, int[][] matriz){
        int j;
        if(n!=0){
            
            j=n%10;
            
            if(matriz[0][j-1] != n%10){
                matriz[0][j-1] = n%10;
                matriz[1][j-1]=cont;
                matriz = cargarMatriz(n/10, cont+1, matriz);
            }
            else{
                matriz = cargarMatriz(n/10, cont, matriz);
            }
        }
        
        return matriz;
    }
    
    
    public static int  numMayor (int n, int mayor){
        
        if(n!=0){
            if(mayor<n%10){
                mayor=n%10;
            }
            mayor=numMayor(n/10, mayor);
        }
        
      return mayor;
    }
    
    
    public static int[] arrOrdenado (int [][] matriz, int[] arr, int j){
        
        if(j<arr.length){
            if(matriz[1][j]!=0){
                arr[matriz[1][j]]=matriz[0][j];
                arr=arrOrdenado(matriz, arr, j+1);
            }
            else{
                arr=arrOrdenado(matriz, arr, j+1);
            }
        }
        
      return arr;
    }
    
    
    public static int eliminaRepetidos(int j, int cont, int nMod, int[] arr){
        if(j<arr.length){
            
            nMod+=arr[j]*cont;
            nMod=eliminaRepetidos(j+1,cont*10,nMod,arr);
        }
            
        return nMod;
    }
     
    
    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 2356342, mayor;
        mayor = numMayor(n, 0);
        int [][] matriz = new int [2][mayor];
        int [] arr = new int [mayor];
        cargarMatriz(n,1,matriz);
        arrOrdenado(matriz, arr, 0);
        System.out.println(eliminaRepetidos(1,1,0,arr));
        
    }
}


