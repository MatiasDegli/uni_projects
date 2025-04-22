/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.mascota;
import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TestMascota {
    
    
    
    public static Mascota modMascota (Mascota mascota1, double pesoMod){
        Mascota mascotaMod;
        mascotaMod = new Mascota ((mascota1.getCodigo()), (mascota1.getNombre()), pesoMod, (mascota1.getEdad()+1));
        
        return mascotaMod;}
    
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        double peso, pesoNuevo;
        int edad, codigo;
        String nombre;
        
        System.out.println("Ingrese el codigo de su mascota");
        codigo = sc.nextInt();
        System.out.println("Ingrese el nombre de su mascota");
        nombre = sc.next();
        System.out.println("Ingrese el peso de su mascota");
        peso = sc.nextDouble();
        System.out.println("Ingrese la edad de su mascota");
        edad = sc.nextInt();
        
        Mascota mascota1;
        mascota1 = new Mascota (codigo, nombre, peso, edad);
    
        
    
        System.out.println("\nDatos de la mascota: \nCodigo: "+mascota1.getCodigo()+"\nNombre: "+mascota1.getNombre()+"\nPeso: "+mascota1.getPeso()+"\nCodigo: "+mascota1.getEdad());
        System.out.println();
        
        System.out.println("Ingrese un nuevo peso para su mascota");
        pesoNuevo = sc.nextDouble();
        System.out.println();
        
        System.out.println("Los datos de su nueva mascota son:");
        //modMascota(mascota1, pesoNuevo);
        System.out.println(modMascota(mascota1, pesoNuevo));
        
    }
    
}

/*Implementar la clase Mascota.
Implementar un algoritmo de test que cargue los datos de una Mascota y luego permita realizar
las siguientes operaciones:
• Mostrar el nombre de la Mascota.
• Aumentar la edad de la mascota en 1.
• Cambiar el peso de la mascota por un valor ingresado por el usuario.
• Mostrar todos los datos de la mascota.*/

