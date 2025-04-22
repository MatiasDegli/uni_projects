/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.ingrediente;

/**
 *
 * @author Zambon
 */
public class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidad;
    


//constructores
public Ingrediente (String nom){
nombre=nom;
cantidad=0;
unidad="";
}

public Ingrediente (String nom, double can, String un){
    nombre=nom;
    cantidad=can;
    unidad=un;
}

//observadores
public String getNombre (){
    return nombre;
}

public double getCantidad (){
    return cantidad;
}

public String getUnidad(){
    return unidad;
}

public String toString(){
    String cadena= "De el ingrediente"+getNombre()+"se necesitan "+getCantidad()+" "+getUnidad()+"";
    return cadena; 
}

//modificadores
public void setNombre (String nom){
    nombre=nom;
}
public void setCantidad (double can){
    cantidad=can;
}
public void setUnidad (String un){
    unidad=un;
}

}

/*Implementar un TDA Ingrediente que permita almacenar el nombre de un ingrediente, 
la cantidad y la unidad de medida (por ejemplo si es 1 huevo será “unidad”, 
si es 1 litro será “litro”, si son 100 gramos será “gramos”). Diseñe el UML y realice la implementación. 
Diseñe un algoritmo que permita testear el TDA construido.


Ingrediente
-nombre: string
-cantidad: double
-unidad: string
Constructores
Ingrediente (String nom)
Ingrediente (String nom; double cant, String un)

Observadores
+getNombre () : String 
+getCantidad () : double
+getUnidad (): String
+ toString () : String 

Modificadores
+setNombre (String n)
+setCantidad(double cant)
+setUnidad(Sring un)



*/
    

