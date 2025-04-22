/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodos.java;

import java.util.Scanner;

/**
 *
 * @author Zambon
 */
public class ClaseObjetoAuto {

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
        String [] arrT = new String [cantA];
        
        for (i=0;i<arrA.length;i++){
            System.out.println("Ingrese el tipo del atributo numero " +(i+1)+ " del objeto");
            arrT[i]=sc.next();
            System.out.println("Ingrese el atributo numero " +(i+1)+ " del objeto");
            arrA[i]=sc.next();
            
        }
        
        
        System.out.print("\npublic class "+objeto+" {\n" +
            "    \n" +
            "    \n" +
            "    //Atributos\n");

        
        for (i=0;i<arrA.length;i++){
            System.out.print("    private "+arrT[i]+ " " +arrA[i]+ ";\n"); 
        }
        
         
        System.out.print("\n" +
            "    \n" +
            "    //Constructoras\n" +
            "    public "+objeto+" ("+arrT[0]+" "+arrA[0].substring(0, 3)+"){\n"); 

        System.out.print("        "+arrA[0]+" = "+arrA[0].substring(0, 3)+";\n");
        for (i=1;i<arrA.length;i++){
            if ("String".equals(arrT[i]))System.out.print("        "+arrA[i]+" = \"\";\n");
            if ("int".equals(arrT[i]))System.out.print("        "+arrA[i]+" = 0;\n");
            if ("double".equals(arrT[i]))System.out.print("        "+arrA[i]+" = 0;\n");
            if ("boolean".equals(arrT[i]))System.out.print("        "+arrA[i]+" = false;\n");
            if ("char".equals(arrT[i]))System.out.print("        "+arrA[i]+" = ' ';\n");
        }
        
        
        System.out.print("    }\n" +
            "\n");


        System.out.print("    public "+objeto);
        
        System.out.print(" (");
        for (i=0;i<(arrA.length-1);i++){
            System.out.print(arrT[i]+ " " +arrA[i].substring(0, 3)+ ", "); 
        }       
        System.out.print(arrT[arrA.length-1]+ " " +arrA[arrA.length-1].substring(0, 3)); 
        System.out.print("){\n");

        for (i=0;i<arrA.length;i++){
            System.out.print("        "+arrA[i]+" = "+arrA[i].substring(0, 3)+";\n");
        }   

        
        System.out.print("    }\n" +
            "\n" +
            "\n" +
            "    //Observadoras\n");

        for (i=0;i<arrA.length;i++){
            System.out.print("    public "+arrT[i]+" get"+arrA[i].substring(0,1).toUpperCase()+arrA[i].substring(1)+"(){\n" +
                "        return "+arrA[i]+";\n" +
                "    }\n" +
                "\n");
        }

        
        System.out.print("\n" +
        "    //Modificadoras\n");

        for (i=0;i<(arrA.length-1);i++){
            System.out.print("    public void set"+arrA[i].substring(0,1).toUpperCase()+arrA[i].substring(1)+" ("+arrT[i]+" "+arrA[i].substring(0, 3)+") {\n" +
            "        "+arrA[i]+" = "+arrA[i].substring(0, 3)+";\n" +
            "    }\n" +
            "\n");        
        }
        System.out.print("    public void set"+arrA[arrA.length-1].substring(0,1).toUpperCase()+arrA[arrA.length-1].substring(1)+" ("+arrT[arrA.length-1]+" "+arrA[arrA.length-1].substring(0, 3)+") {\n" +
            "        "+arrA[arrA.length-1]+" = "+arrA[arrA.length-1].substring(0, 3)+";\n" +
            "    }\n" +
            "\n");
        

        
        System.out.print("\n" +
            "    //Propias del tipo\n" +
            "    public String toString(){\n" +
            "        String cadena = ");
        
        for (i=0;i<arrA.length-1;i++){
            System.out.print("\"\\n"+arrA[i].substring(0,1).toUpperCase()+arrA[i].substring(1)+": \"+get"+arrA[i].substring(0,1).toUpperCase()+arrA[i].substring(1)+"()+ "); 
        }
        System.out.print("\"\\n"+arrA[arrA.length-1].substring(0,1).toUpperCase()+arrA[arrA.length-1].substring(1)+": \"+get"+arrA[arrA.length-1].substring(0,1).toUpperCase()+arrA[arrA.length-1].substring(1)+"()");
        
        
        System.out.print(";\n" +"        return cadena;\n" +
            "    }\n" +
            "\n" +
            "    public boolean equals("+objeto+" otro){\n" +
            "        return this."+arrA[0]+" == otro.get"+arrA[0].substring(0,1).toUpperCase()+arrA[0].substring(1)+"();\n" +
            "    }\n" +
            "\n" +
            "}\n");
        
    }
    
}
