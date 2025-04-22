/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_6;

/**
 *
 * @author matia
 */
class Corredor implements Runnable{
    
    private String name;
    private double recorrido = 0;
    
    
    public Corredor(String nombre){
        name = nombre;
    }
    
    public void run(){
        
        int centenar=1;
        
        try{
            for (int i = 0; i < 100; i++) {
                
                Thread.sleep(200);
                
                double cantM = 1 + (Math.random() * 9);
                cantM = Math.floor(cantM * 10) / 10;
                
                
                if(recorrido>100*centenar){
                    System.out.println(this.name+" alcanzo los "+ centenar*100 + " metros en "+i+" segs\n");
                    centenar++;
                }                              
                
                recorrido = recorrido + cantM;
            }
            recorrido = Math.floor((recorrido)*10) /10;
            Thread.sleep(100);
            System.out.println("\nEl corredor "+this.name+" logro "+ recorrido + " metros en los 100 segundos! \n\n");
        }
        catch(InterruptedException exc){
            System.out.println("\nEl corredor "+this.name+ " tuvo un accidente\n\n");
        }        
    }
    
    public double getRecorrido(){
        return recorrido;   
    }
    
    public String getNombre(){
        return name;   
    }
}
