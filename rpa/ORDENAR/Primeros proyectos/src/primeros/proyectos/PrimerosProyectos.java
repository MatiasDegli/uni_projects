/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeros.proyectos;

import java.util.Scanner;


public class PrimerosProyectos {
    public static void main (String[] args){
        Scanner sc= new Scanner (System.in);
        int cantEnvios, i=1;
        float peso, precioEnvio, totalACobrar=0;
        char envio;
        System.out.println("Ingrese la cantidad de envios a realizar");
        cantEnvios = sc.nextInt();
        while (i<= cantEnvios){
            System.out.println("Ingrese el peso de la encomienda");
            peso = sc.nextFloat();
            totalACobrar+= precioPorEnvio (peso);
            i++;
        }
    }
    static float precioPorEnvio (float peso){
        Scanner sc= new Scanner (System.in);
        String tipoDistancia="";
        float precioEnvio;
        precioEnvio=0;
        System.out.println("Seleccione tipo de distancia C: corta, M: media o L: larga");
        tipoDistancia= sc.nextLine();
        switch (tipoDistancia){
            case "C": precioEnvio+=(50*peso) ;break;
            case "M": precioEnvio+=(75*peso) ;break;
            case "L": precioEnvio+=(100*peso) ;break;
        }
        precioEnvio= precioEnvio+50;
        System.out.println("El precio del envio es de "+precioEnvio+"pesos");
        return peso;
    }
}
