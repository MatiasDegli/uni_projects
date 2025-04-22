/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodos.pharo;
import java.util.Scanner;
/**
 *
 * @author Zambon
 */
public class ConstructorEInicializador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String objeto;
        int cantA, i;
        
        System.out.println("Ingrese el objeto de la class");
        objeto = sc.next();
        System.out.println("Ingrese la cantidad de atributos del objeto");
        cantA = sc.nextInt();
        
        String [] arrA = new String [cantA];
        
        for (i=0;i<arrA.length;i++){
            
            System.out.println("Ingrese el atributo numero " +(i+1)+ " del objeto");
            arrA[i]=sc.next();
            
        }
        
        
        System.out.println("\n//Inicializador\n");
        
        
        System.out.print("initialize"+arrA[0].substring(0,1).toUpperCase()+arrA[0].substring(1)+ ": un" 
                +arrA[0].substring(0,1).toUpperCase()+arrA[0].substring(1)+" ");
        
        for (i=1;i<arrA.length;i++){
            System.out.print(arrA[i] + ": un" 
            +arrA[i].substring(0,1).toUpperCase()+arrA[i].substring(1) +" ");
        }
        

        for (i=0;i<arrA.length;i++){
            System.out.print("\n" + arrA[i] + ":= un" 
            +arrA[i].substring(0,1).toUpperCase()+arrA[i].substring(1) +".");
        }
        
        
        System.out.println("");
        System.out.println("");
        
        System.out.println("//Constructor\n");
        
        for (i=0;i<arrA.length;i++){
            System.out.print("crear"+arrA[i].substring(0,1).toUpperCase()+arrA[i].substring(1)+ ": un" 
                +arrA[i].substring(0,1).toUpperCase()+arrA[i].substring(1)+" ");
        }
        
        System.out.println("\n|un"+objeto+"|");
        System.out.println("un"+objeto+":= self new.");
        System.out.print("un"+objeto+" ");
        System.out.print("initialize"+arrA[0].substring(0,1).toUpperCase()+arrA[0].substring(1)+ ": un" 
                +arrA[0].substring(0,1).toUpperCase()+arrA[0].substring(1)+" ");
        
        for (i=1;i<arrA.length;i++){
            System.out.print(arrA[i] + ": un" 
            +arrA[i].substring(0,1).toUpperCase()+arrA[i].substring(1) +" ");
        }
        
        System.out.print(".\n^un"+objeto+".\n\n");
        
        
        System.out.println("//toString\n");
        
        System.out.print("toString"+objeto+"\n" +
        "|mensaje|\n" +
        "mensaje:= '"+arrA[0].substring(0,1).toUpperCase()
                    +arrA[0].substring(1)+": ' , "+arrA[0] + " asString , ");
        
        for (i=1;i<arrA.length-1;i++){
            System.out.print("', "+arrA[i].substring(0,1).toUpperCase()
                    +arrA[i].substring(1)+": ' , "+arrA[i] + " asString , ");
        }
        
        if(arrA.length>1){
            System.out.print("', "+arrA[arrA.length-1].substring(0,1).toUpperCase()
                    +arrA[arrA.length-1].substring(1)+": ' , "+arrA[arrA.length-1] + " asString.");
        }
        
        System.out.print("\n^mensaje.");
        
    }
    
}


