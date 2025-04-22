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
        boolean esHerencia;
        String objeto;
        String atributos;
        String atributosH="";
        int cantA=0, i=0, cantH=0;
        
        System.out.println("Es subclase?");
        esHerencia = "si".equals(sc.nextLine());
        
        if(esHerencia){
            System.out.println("Ingrese los atributos de la clase padre");
            atributos = sc.nextLine();
            System.out.println("Ingrese los atributos de la subclase");
            atributosH = sc.nextLine();
            System.out.println("Ingrese el nombre de la subclase");
            objeto = sc.nextLine();
        }
        else{
            System.out.println("Ingrese los atributos de la clase");
            atributos = sc.nextLine();
            System.out.println("Ingrese el nombre de la clase");
            objeto = sc.nextLine();
        }
        
        
        
        for (int j = 0; j < atributos.length(); j++){
            
            if(atributos.charAt(j) != ' '){
                
                if(j==atributos.length()-1){
                    cantA++;
                }
            }
            else{                
                cantA++;                
            }
        }
        
        
        for (int j = 0; j < atributosH.length(); j++){
            
            if(atributosH.charAt(j) != ' '){
                
                if(j==atributosH.length()-1){
                    cantH++;
                }
            }
            else{
                cantH++;
            }
        }
        
        cantH+=cantA;
        
        String [] arrH = new String [cantH];
        String [] arrA = new String [cantA];
        String atributo="";
        
        for (int j = 0; j < atributos.length(); j++){
            //lleno arrA
            if(atributos.charAt(j) != ' '){
                atributo+=atributos.charAt(j);
                if(j==atributos.length()-1){
                    arrA[i]=atributo;
                    atributo="";
                }
            }
            else{
                arrA[i]=atributo;
                i++;
                atributo="";
            }
        }
        
        
        if(esHerencia){
            
            atributosH=atributos+" "+atributosH;
            i=0;
            
            for (int j = 0; j < atributosH.length(); j++){
                //lleno arrH
                if(atributosH.charAt(j) != ' '){
                    atributo+=atributosH.charAt(j);
                    if(j==atributosH.length()-1){
                        arrH[i]=atributo;
                        atributo="";
                    }
                }
                else{
                    arrH[i]=atributo;
                    i++;
                    atributo="";
                }
            }
        }
        else{
            arrH=arrA;
        }
        
        
        System.out.println("\n//Inicializador\n");
        
        
        System.out.print("initialize"+arrH[0].substring(0,1).toUpperCase()+arrH[0].substring(1)+ ": un" 
                +arrH[0].substring(0,1).toUpperCase()+arrH[0].substring(1)+" ");
        
        for (i=1;i<arrH.length;i++){
            System.out.print(arrH[i] + ": un" 
            +arrH[i].substring(0,1).toUpperCase()+arrH[i].substring(1) +" ");
        }
        
        if(esHerencia){
            
            System.out.print("\nself initialize"+arrH[0].substring(0,1).toUpperCase()+arrH[0].substring(1)+ ": un" 
                +arrH[0].substring(0,1).toUpperCase()+arrH[0].substring(1)+" ");
            
            for (i=1;i<arrA.length;i++){
                System.out.print(arrH[i] + ": un" 
                +arrH[i].substring(0,1).toUpperCase()+arrH[i].substring(1) +" ");
            }
            System.out.print(".");
            
            
            for (i=arrA.length;i<arrH.length;i++){
                System.out.print("\n" + arrH[i] + ":= un" 
                +arrH[i].substring(0,1).toUpperCase()+arrH[i].substring(1) +".");
            }
        }
        else{
            
            for (i=0;i<arrH.length;i++){
                System.out.print("\n" + arrH[i] + ":= un" 
                +arrH[i].substring(0,1).toUpperCase()+arrH[i].substring(1) +".");
            }
        }
        
        
        System.out.println("");
        System.out.println("");
        
        System.out.println("//Constructor\n");
        
        for (i=0;i<arrH.length;i++){
            System.out.print("crear"+arrH[i].substring(0,1).toUpperCase()+arrH[i].substring(1)+ ": un" 
                +arrH[i].substring(0,1).toUpperCase()+arrH[i].substring(1)+" ");
        }
        
        System.out.println("\n|un"+objeto+"|");
        System.out.println("un"+objeto+":= self new.");
        System.out.print("un"+objeto+" ");
        System.out.print("initialize"+arrH[0].substring(0,1).toUpperCase()+arrH[0].substring(1)+ ": un" 
                +arrH[0].substring(0,1).toUpperCase()+arrH[0].substring(1)+" ");
        
        for (i=1;i<arrH.length;i++){
            System.out.print(arrH[i] + ": un" 
            +arrH[i].substring(0,1).toUpperCase()+arrH[i].substring(1) +" ");
        }
        
        System.out.print(".\n^un"+objeto+".\n\n");
        
        
        System.out.println("//toString\n");
        
        System.out.print("toString"+objeto+"\n" +
        "|mensaje|\n" +
        "mensaje:= '"+arrH[0].substring(0,1).toUpperCase()
                    +arrH[0].substring(1)+": ' , "+arrH[0] + " asString , ");
        
        for (i=1;i<arrH.length-1;i++){
            System.out.print("', "+arrH[i].substring(0,1).toUpperCase()
                    +arrH[i].substring(1)+": ' , "+arrH[i] + " asString , ");
        }
        
        if(arrH.length>1){
            System.out.print("', "+arrH[arrH.length-1].substring(0,1).toUpperCase()
                    +arrH[arrH.length-1].substring(1)+": ' , "+arrH[arrH.length-1] + " asString.");
        }
        
        System.out.print("\n^mensaje.");
        
    }
    
}


