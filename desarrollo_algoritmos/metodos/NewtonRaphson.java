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
public class NewtonRaphson {
    
    
    public static double funcion(double n){
        
        double fn = 80*Math.exp(-2*n)+20*Math.exp(-0.5*n);
        
        return fn;
    }
    
    
    public static double derivada(double t){
        
        double ft = (-160*Math.exp(-0.5*t)+10*Math.exp(2*t))/Math.exp((5/2)*t);
        
        return ft;
    }
    
    
    public static boolean bolzano(double x1, double x2){
        
        boolean aplican = true;
        double f1 = funcion(x1);
        double f2 = funcion(x2);
        
        if(f1==0) System.out.println("El valor "+x1+" es raiz.");
        if(f2==0) System.out.println("El valor "+x2+" es raiz.");
        
        if (f1*f2 > 0) aplican=false;
        else if(f1*f2 < 0) aplican=true;
        
        return aplican;
    }
    
    
    public static double newtonRaphson(double x, double error){
        
        double raiz;
        
        while(errorMin(x, error)==false){
            
            x = (x-(funcion(x)/derivada(x)));
        }
        
        raiz=x;
        
        return raiz;
    }
    
    
    public static boolean errorMin(double f, double error){
        
        boolean valido=false;
        
        if (Math.abs(funcion(f)) < Math.abs(error)) valido=true;
        
        return valido;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        double raiz, error;
        double x, x1, x2;
        
        System.out.println("Ingrese el valor inicial:");
        x1=sc.nextDouble();
                
        System.out.println("Ingrese el valor final");
        x2=sc.nextDouble();
        
        System.out.println("Ingrese un error aceptable");
        error=sc.nextDouble();
        
        /*while(bolzano(x1,x2) == false){
            
            System.out.println("Los valores iniciales no cumplen con el Teorema de Bolzano. Ingrese otros valores.\n");
        
            System.out.println("Valor inicial:");
            x1=sc.nextDouble();
                
            System.out.println("Valor final");
            x2=sc.nextDouble();
            
        }*/
        
        if(Math.abs(funcion(x1))<Math.abs(funcion(x2))) x=x1;
        else x=x2;
        
        raiz=newtonRaphson(x, error);
        error=funcion(raiz);
        
        System.out.println("La raiz con un error de "+error+" es "+raiz);
    }
    
}

