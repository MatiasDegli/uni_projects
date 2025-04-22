/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_4;

/**
 *
 * @author matia
 */
public class ParqueTematico{
    
    
    private Lista areas = new Lista();
    
    
    public void agregarArea(Area area){
        areas.insertar(areas.longitud()+1, area);
    }
    
    
    public synchronized boolean reservar(int n){
        
        boolean exito;
        
        //Se chequea la disponibilidad del area requerida
        
        Area area = (Area) areas.recuperar(n);
        
        if(area.getDisponibilidad()){
            exito=true;
            area.reservada();
        }
        else{
            exito=false;
        }
        
        return exito;
    }
    
    
    public int getCantAreas(){
        return areas.longitud();
    }
    
}
