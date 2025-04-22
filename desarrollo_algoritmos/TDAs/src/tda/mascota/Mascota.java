/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.mascota;

/**
 *
 * @author Zambon
 */
public class Mascota {

    /**
     * @param args the command line arguments
     */
    
    //atributos
    private int codigo;
    private String nombre;
    private double peso;
    private int edad;
    
    
    //constructores
    public Mascota (int cod){
    
        codigo = cod;
        nombre="";
        peso=0;
        edad=0;
        
        
    }
    
    public Mascota (int cod, String nn, double pe, int ed){
    
        codigo = cod;
        nombre = nn;
        peso = pe;
        edad = ed;
    } 
    
    
    
    //observadores
    public int getCodigo() {

        return codigo;
     } 
    public String getNombre() {

        return nombre;
     } 
    public double getPeso() {

        return peso;
     } 
    
    public int getEdad() {

        return edad;
     } 
    
    public String toString() {
        
        String cadena= "Codigo: " +this.getCodigo() 
                + "\nNombre: "+this.getNombre()+"\nPeso: "
                + ""+this.getPeso()+ "\nEdad: "+ this.getEdad(); 
        return cadena;
     } 
    
    
    
    //modificadores
 
    public void setNombre(String nn) {
        
        nombre = nn;
     } 
    
    
    public void setPeso(double pe) {
        
        peso = pe;
     } 
    
    
    public void setEdad(int ed) {

        edad = ed;
     } 
    
    
    //propias de Mascota
    
    public boolean esIgual(Mascota m){
    
        return m.codigo==codigo;
    
    }
    
}


/* Constructores 
+ Mascota (int cod) 
+ Mascota (int cod, String nn, double pe, int ed) 

Observadores 
+ getCodigo () : int 
+ getNombre () : String 
+ getPeso () : double 
+ getEdad () : int 
+ toString () : String 

Modificadores 
+ setCodigo (int cod) 
+ setNombre (String nn) 
+ setPeso (double pe) 
+ setEdad (int ed) 

Propias del tipo 
+ equals ( Mascota otra) : boolean
  */
