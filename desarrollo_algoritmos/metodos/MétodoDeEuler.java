/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodos;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class MétodoDeEuler {

    public static double funcion(double x, double y){
        
        double f = Math.exp(x);
        
        return f;
    }
    //Math.pow(y, 2) + 1
    
    
    public static double euler(double x, double y, double h, double tope){
        
        double d = funcion(x,y);
        x+=h;
        y = y + h*d;
        System.out.println("x = "+x);
        if(x < tope) y = euler(x, y, h, tope);
        
        return y;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        double x, y, h, tope, valor;
                
        System.out.println("Ingrese x0");
        x = sc.nextDouble();
        System.out.println("Ingrese y0");
        y = sc.nextDouble();
        System.out.println("Ingrese h");
        h = sc.nextDouble();
        System.out.println("Ingrese hasta que valor de x quiere llegar");
        tope = sc.nextDouble();
        
        valor = euler(x,y,h,tope);
        
        System.out.println(valor);
    }
    
}
