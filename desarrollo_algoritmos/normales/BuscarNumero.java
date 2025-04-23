/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.normales;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Zambon
 */
public class BuscarNumero {
    
    
    public static int buscaNum(int [] arr, int n, int pos, boolean existe){
        
        if(pos<arr.length && existe==false && arr[pos]>=n){
            System.out.println(arr[pos]);
            if(arr[pos]==n){
                existe = true;
                System.out.println(existe);
            }
            else{
                pos=buscaNum(arr, n, pos+1, existe);
            }
        }
            
        if(existe == false){
            pos = -1;
        }
        
        return pos;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n, pos;
        
        int [] arr = {30, 26, 23, 22, 20, 18, 14, 11, 10, 7, 5, 2};
        
        
        System.out.println(Arrays.toString(arr));
        
        System.out.println("Ingrese el número que desea buscar");
        n=sc.nextInt();
        
        pos = buscaNum(arr, n, 0, false);
        
        if(pos==-1)System.out.println("El número ingresado no se encuentra en el arreglo");
        else System.out.println("El número ingresado se encuentra en la posición "+(pos+1));
        
    }
    
}
