/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;
import lineales.dinamicas.Lista;
/**
 *
 * @author Zambon
 */
public class testLista {
    
    public static void main(String[] args) {
        Lista listita = new Lista();
        int i=0;
        
        for(i=0;i<12;i++){
            listita.insertar(i, i);
        }
        
        System.out.println(listita.toString());
        
        listita.eliminar(4);
        
        System.out.println(listita.toString());
        
    }
    
}
