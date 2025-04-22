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
public class Biseccion {
    
    
    public static double funcion(double n){
        
        double f = 2*Math.sin(n);
        
        return f;
    }
    
    
    public static boolean bolzano(double ini, double fin){
        
        boolean aplican = true;
        double f1 = funcion(ini);
        double f2 = funcion(fin);
        
        if(f1==0) System.out.println("El valor "+ini+" es raiz.");
        if(f2==0) System.out.println("El valor "+fin+" es raiz.");
        
        if (f1*f2 > 0) aplican=false;
        else if(f1*f2 < 0) aplican=true;
        
        return aplican;
    }
    
    
    public static double biseccion(double ini, double fin, double error){
        
        double raiz;
        
        double f1 = funcion(ini);
        double f2 = funcion(fin);
        double n;
        
        while(errorMin(ini, error)==false && errorMin(fin, error)==false){
            
            n = ((ini+fin)/2);
            double fn = funcion(n);
            
            if(f1<0 && fn<0 && fn>f1) ini=n;
            
            else if(f1>0 && fn>0 && fn<f1) ini=n;
            
            else if(f2<0 && fn<0 && fn>f2) fin=n;
            
            else if(f2>0 && fn>0 && fn<f2) fin=n;
        }
        
        if(errorMin(ini, error)){
            raiz=ini;
        }
        else raiz=fin;
        
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
        double ini, fin;
        
        System.out.println("Ingrese el valor inicial:");
        ini=sc.nextDouble();
                
        System.out.println("Ingrese el valor final");
        fin=sc.nextDouble();
        
        System.out.println("Ingrese un error aceptable");
        error=sc.nextDouble();
        
        while(bolzano(ini,fin) == false){
            
            System.out.println("Los valores iniciales no cumplen con el Teorema de Bolzano. Ingrese otros valores.\n");
        
            System.out.println("Valor inicial:");
            ini=sc.nextDouble();
                
            System.out.println("Valor final");
            fin=sc.nextDouble();
            
        }
        
        raiz=biseccion(ini,fin, error);
        error=funcion(raiz);
        
        System.out.println("La raiz con un error de "+error+" es "+raiz);
    }
    
}
