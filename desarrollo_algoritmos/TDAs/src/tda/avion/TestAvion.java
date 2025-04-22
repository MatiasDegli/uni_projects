/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.avion;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TestAvion {

    
    
    
    
    
    
    public static void cargarArr(Avion[] arr){
        Scanner sc = new Scanner(System.in);
        String id, modelo;
        int cantAs, i;
        double kmRec, velProm;
        
        for (i = 0; i < arr.length; i++){
            System.out.println("Ingrese el identificador del avion "+(i+1));
            id=sc.next();
            System.out.println("Ingrese el modelo del avion "+i);
            modelo=sc.next();
            System.out.println("Ingrese la cantidad de asientos del avion "+i);
            cantAs=sc.nextInt();
            System.out.println("Ingrese los kilometros recorridos del avion "+i);
            kmRec=sc.nextDouble();
            System.out.println("Ingrese la velocidad promedio del avion "+i);
            velProm=sc.nextDouble();
            arr[i] = new Avion(id, modelo, cantAs, kmRec, velProm);
        }
    }
    
    public static void mostrarArr(Avion[] arr){
        int i;
        for (i = 0; i < arr.length; i++){
            System.out.print(arr[i] +"\n");
        }
    }
      
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Avion avion1 = new Avion("AV12", "Air", 220, 124578.3, 567.5);
        int cantAviones;
        
        System.out.println("Ingrese la cantidad de aviones que desea analizar");
        cantAviones = sc.nextInt();
        
        Avion [] arrAviones = new Avion [cantAviones];
        cargarArr(arrAviones);
        mostrarArr(arrAviones);
        
        
    }
    
}

/*8. Diseñar un algoritmo que almacene en una estructura adecuada la información de una cierta cantidad de aviones. 
El algoritmo debe realizar la carga de la estructura y permitir realizar las siguientes acciones: 
• Mostrar el avión que tiene mayor velocidad (en caso de iguales devolver el último encontrado) 
• Mostrar la cantidad de asientos que tiene un cierto avión (dado su identificador) 
• Mostrar cuantos aviones de un cierto modelo tiene la empresa 
• Mostrar el promedio de km recorrido por todos los aviones 
*/