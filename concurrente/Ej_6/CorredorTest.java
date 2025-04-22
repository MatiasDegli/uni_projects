/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_6;

/**
 *
 * @author matia
 */
class CorredorTest implements Runnable{
    
    private String name;
    private double recorrido = Math.floor((Math.random() * 100)*10)/10;
    
    
    public CorredorTest(String nombre){
        name = nombre;
    }
    
    public void run(){
        
        try{
            for (int i = 0; i < recorrido; i++) {
                
                Thread.sleep(300);
                
                if(i%5==0 && i > 0){
                    System.out.println(this.name+" llego a "+ i + "km\n");
                }                                
            }
            
            Thread.sleep(100);
            System.out.println("\nEl corredor "+this.name+" finalizo en "+ recorrido + " kilometros\n\n");
        }
        catch(InterruptedException exc){
            System.out.println("\nEl corredor "+this.name+ " tuvo un accidente\n\n");
        }        
    }
    
    public double getRecorrido(){
        return recorrido;   
    }

}
