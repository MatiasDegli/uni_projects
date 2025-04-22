/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodos.iterativos;
import java.util.Scanner;
import java.util.Arrays;



public class MergeSort {
    

   
    public static void merge (String [] arr, String [] izq, String [] der){
        
        int izqLength = izq.length;
        int derLength = der.length;
        
        int i = 0, j = 0, k = 0, q = 0;
        
        while (i < izqLength && j < derLength) {
            
            if (izq[i].charAt(q) < der[j].charAt(q)) {
                arr[k] = izq[i];
                i++;
                k++;
                q=0;
            }
            else if(izq[i].charAt(q) == der[j].charAt(q)){
                q++;
                if(q==izq[i].length()){
                    arr[k] = izq[i];
                    i++;
                    k++;
                    q=0;
                }
                else if(q==der[j].length()){
                    arr[k] = der[j];
                    j++;
                    k++;
                    q=0;
                }
            }
            else{
                arr[k] = der[j];
                j++;
                k++;
                q=0;
            }
        }
        
        while (i < izqLength) {
            arr[k] = izq[i];
            i++;
            k++;
        }
        
        while (j < derLength) {
            arr[k] = der[j];
            j++;
            k++;
        }
        
    }
    
    
    public static void mergeSortA(String [] arr) {
        
        int longArr = arr.length;

        if (longArr < 2) {
            return;
        }

        int med = longArr / 2;
        String [] izq = new String[med];
        String [] der = new String[longArr - med];

        for(int i = 0; i < med; i++) {
            izq[i] = arr[i];
        }
        for(int i = med; i < longArr; i++) {
            der[i - med] = arr[i];
        }
        
        mergeSortA(izq);
        mergeSortA(der);
        merge(arr, izq, der);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int i;
        
        String [] arr = {"José C. Paz" ,"Quilmes" , "Pilar" ,"Neuquén" ,
            "Santiago" ,"Puente Alto" ,"Antofagasta" ,"Viña del Mar" ,
            "Valparaíso" ,"Talcahuano" ,"San Bernardo" ,"Temuco" 
                ,"Iquique" ,"Concepción" ,"Rancagua" ,"La Pintana" 
                ,"Talca" ,"Arica"};
        
        
        
        System.out.println(Arrays.toString(arr)+"\n");
        mergeSortA(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
    
    /*
José C. Paz
Quilmes
Pilar
Neuquén
Santiago
Puente Alto;568106
Antofagasta;607534
Viña del Mar;334248
Valparaíso;1825757
Talcahuano;163626
San Bernardo
Temuco
Iquique
Concepción
Rancagua
La Pintana
Talca
Arica*/
    
    
    

    /*public static void merge(int izq, int med, int der, int [] arr){
        int i = 0, j = med;
        int [] aux = new int [arr.length];
        
        while(i<aux.length){ 
            
            if(izq<med && j<der){
                if (arr[izq] < arr[med]){
                aux[i] = arr[izq];
                i+=1;
                izq+=1;
                }
                else{
                    aux[i] = arr[med];
                    i+=1;
                    j+=1;
                }
            }
            else if(izq==med){
                aux[i]=arr[j];
                i+=1;
            }
            else if(j==der){
                aux[i]=arr[izq];
                i+=1;
            }
            
        }
    }*/
    
    
    /*public static void mergesortA(int izq, int der, int [] arr){
        
        int med;
        
        if(arr.length<2){
            
        }
        else{
            if(izq < der){
            med=(izq+der)/2;
            mergesortA(izq, med, arr);
            mergesortA(med+1, der, arr);
            merge(izq, med, der, arr);
            }
        }
        
        
        
    }*/
    
    
    /*public static void merge (int[] arr, int[] izq, int[] der){
        
        int izqLength = izq.length;
        int derLength = der.length;
        
        int i = 0, j = 0, k = 0;
        
        while (i < izqLength && j < derLength) {
            
            if (izq[i] <= der[j]) {
                arr[k] = izq[i];
                i++;
            }
            else{
                arr[k] = der[j];
                j++;
            }
            k++;
        }
        
        while (i < izqLength) {
            arr[k] = izq[i];
            i++;
            k++;
        }
        
        while (j < derLength) {
            arr[k] = der[j];
            j++;
            k++;
        }
        
    }
    
    
    public static void mergeSortA(int[] arr) {
        
        int longArr = arr.length;

        if (longArr < 2) {
            return;
        }

        int med = longArr / 2;
        int[] izq = new int[med];
        int[] der = new int[longArr - med];

        for(int i = 0; i < med; i++) {
            izq[i] = arr[i];
        }
        for(int i = med; i < longArr; i++) {
            der[i - med] = arr[i];
        }
        
        mergeSortA(izq);
        mergeSortA(der);
        merge(arr, izq, der);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        int [] arr = new int [10];
        
        for(i=0; i<arr.length;i++){
            arr[i]  = (int)(Math.random()*99);
        }
        
        System.out.println(Arrays.toString(arr));
        mergeSortA(arr);
        System.out.println(Arrays.toString(arr));
    }
}*/



