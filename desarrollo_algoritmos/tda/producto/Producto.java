/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.producto;

/**
 *
 * @author Zambon
 */
public class Producto {
    
    
    //Atributos
    private int codigo;
    private String descripcion;
    private double precio;
    private double stock;

    
    //Constructoras
    public Producto (int cod){
        codigo = cod;
        descripcion = "";
        precio = 0;
        stock = 0;
    }

    public Producto (int cod, String desc, double pre, double sto){
        codigo = cod;
        descripcion = desc;
        precio = pre;
        stock = sto;
    }


    //Observadoras
    public int getCodigo(){
        return codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public double getPrecio(){
        return precio;
    }

    public double getStock(){
        return stock;
    }


    //Modificadoras
    
    public void setDescripcion (String des) {
        descripcion = des;
    }

    public void setPrecio (double pre) {
        precio = pre;
    }

    public void setStock (double sto) {
        stock = sto;
    }


    //Propias del tipo
    public String toString(){
        String cadena = "";
        return cadena;
    }

    public boolean equals(Producto otro){
        return this.codigo == otro.getCodigo();
    }

}
