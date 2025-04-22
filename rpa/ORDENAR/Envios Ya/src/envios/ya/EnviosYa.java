/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envios.ya;
import java.util.Scanner;
/**
 *
 * @author Zambon
 */
public class EnviosYa {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int codigo, codigoRegion, codigoProv;
        
        System.out.println("ingrese el código del paquete");
        
        codigo = sc.nextInt();
        
        codigoProv = codigo % 100 ;        
               
        codigoRegion = codigo % 10000;
        
        codigoRegion = codigoRegion - codigoProv;
        
        codigoRegion = codigoRegion / 100;
        
        System.out.println("Región destino: "+codigoRegion+ " - Provincia destino: " +codigoProv);
    }
    
}
