/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author matia
 */
public class LineaElectrico {
    
    
    Semaphore preparacion = new Semaphore(1);
    Semaphore ensamblando = new Semaphore(1);
        
    private final Cola productos;
    private Electrico listo;
    private int cantProductos = 0;
    private final ControladorProduccion control; 

    public LineaElectrico(ControladorProduccion cont) {
        this.productos = new Cola();
        this.control = cont;
    }
    
    
    public void llegaElectrico(Electrico prod) throws InterruptedException{
        
        try{
            preparacion.acquire();

            productos.poner(prod);

            cantProductos++;

            System.out.println("\nLlega producto. La linea E tiene "
                    +cantProductos+" produtos");
            
            if(!control.getComienzo()){
                control.empiezaEnsamble();
                control.primeraLinea("Electrico");            
            }
            
        }
        finally{
            preparacion.release();
        }
    }
    
    
    public void prepararProducto() throws InterruptedException{
        
        preparacion.acquire();
        
        try{
            
            while(listo!=null){
                System.out.println("...");
                //El hilo se queda esperando a la variable listo
                Thread.sleep(500);
            }
            if(!productos.esVacia()){
                
                Thread.sleep(3000);
                
                listo = (Electrico) productos.obtenerFrente();
                
                productos.sacar();

                System.out.println("\nHay un producto listo para ensamblar.");

            }
            else if(productos.esVacia() && listo==null){
                System.out.println("\nNo hay productos para preparar.");
                control.cambiaLinea();
            }
        }
        finally{
            preparacion.release();
        }
        
        if(listo!=null){
            ensamblajeElectrico();
        }
    }
    
    
    public void ensamblajeElectrico() throws InterruptedException{
        
        
        ensamblando.acquire();
        
        Electrico ensamblar = listo;
        listo=null;
        
        try{
            
                
            System.out.println("\nSe comienza a ensamblar un producto electrico.");

            Thread.sleep(5000);

            ensamblar.setEnsamblado();

            ensamblar.sale();

            cantProductos--;

            control.actualizar();
                
            
        }
        finally{
            ensamblando.release();
        }
        
    }
    
}
