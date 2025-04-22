/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.socio;

/**
 *
 * @author Zambon
 */
public class Socio {

    private int codigo;
    private String nombreCompleto;
    private int edad;
    private int cantidadTorneosGanados;
    private int mayorPuntaje;
    
    // Constructores
    public Socio (int cod){
        codigo = cod;
        nombreCompleto = "";
        edad = 0;
        cantidadTorneosGanados = 0;
        mayorPuntaje = 0;
    }
    
    public Socio (int cod, String nom, int ed, int canT, int mayorP){
        codigo = cod;
        nombreCompleto = nom;
        edad = ed;
        cantidadTorneosGanados = canT;
        mayorPuntaje = mayorP;
    }
    
    
    // Observadores
    public int getCodigo(){
        return codigo;
    }
    
    public String getNombreCompleto(){
        return nombreCompleto;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public int getCantidadTorneosGanados(){
        return cantidadTorneosGanados;
    }
    
    public int getMayorPuntaje(){
        return mayorPuntaje;
    }
    
    public String toString(){
    String cadena = "Informacion del socio:\nCodigo: "+getCodigo()+"\nNombre y apellido: "
            +getNombreCompleto()+"\nEdad: "+getEdad()+"\nTorneos ganados: "+getCantidadTorneosGanados()+"\nMayor puntaje: "+getMayorPuntaje();
    return cadena;
    }
    
    // Modificadores
    public void setNombreCompleto(String nom){
        nombreCompleto = nom;
    }
    
    
    
}


/*
Socio
- codigo: int
- nombreCompleto: String
- edad: int
- cantidadTorneosGanados: int
- mayorPuntaje: int

Constructores
+ Socio (int cod)
+ Socio (int cod, String nom, int ed, int canT, int mayorP)

Observadores
+ getCodigo() : int
+ getNombreCompleto() : String
+ getEdad() : int
+ getCantidadTorneosGanados() : int 
+ getMayorPuntaje() : int
+ toString() : String

Modificadores
+ setEdad(int ed)
+ setCantidadTorneosGanados(int canT)
+ setMayorPuntaje(int mayorP)

Propios del tipo
+ equals(Socio otro) : boolean
*/

