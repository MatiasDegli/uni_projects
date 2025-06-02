/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudad.tda;

/**
 *
 * @author Zambon
 */
public class Ciudad {
    
    
    //Atributos
    private String nombre;
    private int poblacion;
    private double latitud;
    private double longitud;

    
    //Constructoras
    public Ciudad (String nom){
        nombre = nom;
        poblacion = 0;
        latitud = 0;
        longitud = 0;
    }

    public Ciudad (String nom, int pob, double lat, double lon){
        nombre = nom;
        poblacion = pob;
        latitud = lat;
        longitud = lon;
    }


    //Observadoras
    public String getNombre(){
        return nombre;
    }

    public int getPoblacion(){
        return poblacion;
    }

    public double getLatitud(){
        return latitud;
    }

    public double getLongitud(){
        return longitud;
    }


    //Modificadoras

    public void setPoblacion (int pob) {
        poblacion = pob;
    }


    //Propias del tipo
    public String toString(){
        
        String cadena = "\nNombre: "+getNombre()+ ". Poblacion: "+getPoblacion()+
                ". Latitud: "+getLatitud()+ ". Longitud: "+getLongitud();
        
        
        return cadena;
    }
    
    public boolean equals(Ciudad otra){
        return nombre == otra.getNombre();
    }
    
    public boolean equalsDos(Ciudad otra){
        return nombre == otra.getNombre() && poblacion == otra.getPoblacion() && latitud == otra.getLatitud() && longitud == otra.getLongitud();
    }
    
    public int compareTo(Ciudad otra){
        return nombre.compareTo(otra.getNombre());
    }

}

