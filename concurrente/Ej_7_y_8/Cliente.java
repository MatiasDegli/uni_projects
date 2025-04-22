/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7_y_8;

/**
 *
 * @author matia
 */
public class Cliente {

    private String nombre;
    private int[] carroCompra;
    // Constructor y métodos de acceso
    
    
    public Cliente(String name, int[] arr){
        nombre=name;
        carroCompra=arr;
    }
    
    
    public String getNombre(){
        return nombre;
    }
    
    
    public int[] getCarroCompra(){
        return carroCompra;
    }
}
