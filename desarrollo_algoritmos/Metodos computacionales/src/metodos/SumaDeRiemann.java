/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodos;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class SumaDeRiemann {
    
    
    public static double funcion(double x, double y){
        
        double f = Math.pow(x, 2) + 4*Math.pow(y, 2);
        
        return f;
    }
    //16 - Math.pow(x, 2) - 2*Math.pow(y, 2)
    
    
    public static double riemann(double b, double h, int m, int n){
        int i, j;
        double sumaR=0, a=(b/m)*(h/n);
        
        for(j=1;j<=n;j++){
            
            for(i=1; i<=m; i++){
                sumaR += funcion((b/m)*i, (h/n)*j)*a;
            }
            
        }
        
        return sumaR;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        double ini, fin, b, h, sumaR;
        int m, n;
                
        System.out.println("Ingrese el valor inicial en x de la subregion");
        ini = sc.nextDouble();
        System.out.println("Ingrese el valor final en x de la subregion");
        fin = sc.nextDouble();
        
        b = fin - ini;
        
        System.out.println("Ingrese el valor inicial en y de la subregion");
        ini = sc.nextDouble();
        System.out.println("Ingrese el valor final en y de la subregion");
        fin = sc.nextDouble();
        
        h = fin - ini;
        
        System.out.println("Ingrese m");
        m=sc.nextInt();
        System.out.println("Ingrese n");
        n=sc.nextInt();
        
        sumaR = riemann(b, h, m, n);
        
        System.out.println("La suma de Riemann da " +sumaR);
        
    }
    
}
