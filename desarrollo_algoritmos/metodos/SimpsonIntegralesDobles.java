/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodos;

import java.util.Scanner;
import java.math.BigDecimal;
        
/**
 *
 * @author User
 */
public class SimpsonIntegralesDobles {

    
    public static double funcion(double x, double y){
        
        double f = Math.exp(y-x);
        
        return f;
    }
    //Ecuaciones para comprobar resultados con la teoría
    //Math.log(x + 2*y)
    //Math.pow(x, 2) + Math.pow(y, 2)
    //Math.exp(y-x)
    
    public static double volumen(double arrI[], double k){
        
        int i;
        double vol, sumImpar=0, sumPar=0;
        
        for(i=1;i<arrI.length-1;i++){
            if(i%2!=0){
                sumImpar+=arrI[i];
            }
            if(i%2==0){
                sumPar+=arrI[i];
            }
            
        }
        
        vol = (k/3) * (arrI[0] + arrI[arrI.length-1] + 4*sumImpar + 2*sumPar);
        return vol;
    }
    
    
    public static double simpson(double x0, double xn, double y0, int m, int n, double h){
        
        int j, i;
        double I, sumImpar=0, sumPar=0, puntoImpar=x0+h, puntoPar=x0+2*h;
        
        for(j=2;j<m-1;j+=2){
            sumPar+=funcion(puntoPar, y0);
            puntoPar+=2*h;
        }
            
        for(i=1;i<m;i+=2){
            sumImpar+=funcion(puntoImpar, y0);
            puntoImpar+=2*h;
        }
        
        I = (h/3) * (funcion(x0, y0) + funcion(xn, y0) + 4*sumImpar + 2*sumPar);
        
        return I;
    }
    
    
    public static double arregloI(double x0, double xn, int m, double y0, double yn, int n){
        
        int l;
        double vol, h=(xn-x0)/m, k=(yn-y0)/n;
        
        double [] arrI = new double [n+1];
        
        
        for(l=0;l<=n;l++){
            
            arrI[l] = simpson(x0, xn, y0, m, n, h);
            y0+=k;
            
        }
        
        vol = volumen (arrI, k);
        
        return vol;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int m,n;
        double volumen;
        double x0, xn, y0, yn;
        
        System.out.println("Ingrese el extremo inicial en x");
        x0=sc.nextDouble();
                
        System.out.println("Ingrese el extremo final en x");
        xn=sc.nextDouble();
        
        System.out.println("Ingrese m");
        m=sc.nextInt();
        
        System.out.println("Ingrese el extremo inicial en y");
        y0=sc.nextDouble();
                
        System.out.println("Ingrese el extremo final en y");
        yn=sc.nextDouble();

        System.out.println("Ingrese n");
        n=sc.nextInt();
        
        volumen=arregloI(x0,xn,m,y0,yn,n);
        
        //BigDecimal bd = new BigDecimal(String.valueOf(volumen));
        //BigDecimal rounded = bd.setScale(6, RoundingMode.FLOOR);
        
        
        //System.out.println("El volumen es: "+rounded);
        System.out.println(String.format("%.6f", volumen));
    }
    
}
