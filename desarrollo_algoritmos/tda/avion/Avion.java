/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.avion;

/**
 *
 * @author Zambon
 */

    
public class Avion {
    
    
    //atributos
    private String identificador;
    private String modelo;
    private int cantidadDeAsientos;
    private double kmRecorridos;
    private double velocidadPromedio;

    
    //Constructores
    public Avion (String id){
        identificador=id;
        modelo="";
        cantidadDeAsientos=0;
        kmRecorridos=0;
        velocidadPromedio=0;
    }

    public Avion (String id,String mod,int cantAs,double kmRec,double velProm){
        identificador=id;
        modelo=mod;
        cantidadDeAsientos=cantAs;
        kmRecorridos=kmRec;
        velocidadPromedio=velProm;
    }


    //observadoras
    public String getIdentificador(){
        return identificador;
    }

    public String getModelo(){
        return modelo;
    }

    public  int getCantidadDeAsientos(){
        return cantidadDeAsientos;
    }

    public double getKmRecorridos(){
        return kmRecorridos;
    }

    public double getVelocidadPromedio(){
        return velocidadPromedio;
    } 


    //modificadoras
    public void setKmRecorridos (double kmRec) {
        kmRecorridos=kmRec;
    }
    public void setVelocidadPromedio(double velProm){
        velocidadPromedio=velProm;
    }


    //Propias
    public String toString(){
        String cadena = "Identificador: "+getIdentificador()+ "\nModelo: "+getModelo()
                + "\nCantidad de asientos: "+getCantidadDeAsientos()+ "\nKilometros recorridos: "
                +getKmRecorridos()+ "\nVelocidad promedio: "+getVelocidadPromedio();
        return cadena;
    }

    public boolean equals (Avion otro){
        return this.identificador==otro.identificador;
    }

}
    
    


/*5. Construir el TDA para tratar la abstracción de una línea área. 
Para los aviones sus atributos son: identificador, modelo, cantidad de asientos, km recorridos, velocidad promedio.
Definir el diagrama UML, con Constructoras, Observadoras, Modificadoras y Propias del tipo. 
Diseñar el UML Avion e implementarlo. Implementar un algoritmo de test. 

<Avion>
<-> TEXTO identificador
<-> TEXTO modelo 
<-> ENTERO cantidadDeAsientos
<-> REAL kmRecorridos 
<-> REAL velocidadPromedio

Constructoras
<Avion> (identificador, modelo, cantidadDeAsientos, kmRecorridos, velocidadPromedio)
<Avion> (

Observadoras
<+> getIdentificador() : TEXTO
<+> getModelo() : TEXTO
<+> getCantidadDeAsientos() : ENTERO
<+> getKmRecorridos() : REAL
<+> getVelocidadPromedio() : REAL

Modificadoras
<+> setKmRecorridos

Propias
<+> toString() : TEXTO
<+> equals(Avion objeto): LOGICO

*/