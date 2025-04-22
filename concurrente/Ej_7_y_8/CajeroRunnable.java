/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_7_y_8;

/**
 *
 * @author matia
 */
public class CajeroRunnable implements Runnable {
    
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    

// Constructor, y métodos de acceso
    
    public CajeroRunnable(String name, Cliente cli){
        nombre=name;
        cliente=cli;
        initialTime=System.currentTimeMillis();
    }
    
    
    public void run() {
        
        System.out.println("El cajero " + this.nombre +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            
            System.out.println("Procesado el producto " + (i + 1) + " del cliente " + 
                    this.cliente.getNombre() + "->Tiempo: " +
                    (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }
        
        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE "
                + "PROCESAR "+ this.cliente.getNombre() + " EN EL TIEMPO: " + 
                (System.currentTimeMillis() - this.initialTime) / 1000 +
                "seg");
    }
    
    
    public void esperarXsegundos(int cantidad){
        
        try{
            Thread.sleep(cantidad*1000);
        }
        catch(InterruptedException exc){
            System.out.println("El cajero fue interrumpido");
        }    
    }
    
}
