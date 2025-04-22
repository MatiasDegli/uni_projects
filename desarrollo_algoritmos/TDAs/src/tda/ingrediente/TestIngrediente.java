/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.ingrediente;
import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class TestIngrediente {
    
    public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    Ingrediente ingr1 = new Ingrediente ("sal",30,"gr");
    System.out.print("El ingrediente es: " + ingr1.getNombre() + " La cantidad es " + ingr1.getCantidad() + " " + ingr1.getUnidad());
    }
}

    

