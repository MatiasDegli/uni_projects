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
public class BurbujaMatriz {

    public static int [][] matrizBurbuja(int[][] matriz, int i, int j, int fin){
        int aux;
        
        if(fin>1){
            if(j<fin-1 && i<matriz.length && matriz[i][j]>matriz[i][j+1]){
                aux=matriz[i][j];
                matriz[i][j]=matriz[i][j+1];
                matriz[i][j+1]=aux;
                matriz = matrizBurbuja(matriz, i ,j+1, fin);
            }
            else if(j<fin-1&& i<matriz.length){
                matriz=matrizBurbuja(matriz, i, j+1, fin);
            }
            else if(j==fin-1 && i<matriz.length){
                matriz=matrizBurbuja(matriz, i, j-(fin-1), fin-1);
            }
        }
        else if(i<matriz.length){
            matriz=matrizBurbuja(matriz, i+1, j, fin + matriz[i].length-1);
        }

        return matriz;
    }
            
    
    public static void main(String[] args) {
        // TODO code application logic here
        int i, j;
        
        int [][] matriz = new int [5][6];
        
        for(i=0; i<matriz.length;i++){
            for(j=0; j<matriz[0].length;j++){
                matriz[i][j]  = (int)(Math.random()*99);
            }
        }
        
        
        System.out.println(Arrays.deepToString(matriz));
        
        System.out.println(Arrays.deepToString(matrizBurbuja(matriz, 0, 0, matriz[0].length)));
    }

}
