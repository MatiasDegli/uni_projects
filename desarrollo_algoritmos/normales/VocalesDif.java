/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.normales;

/**
 *
 * @author Zambon
 */
public class VocalesDif {

    
    public static int buscaVocales (String cadena){
        int vocalesDif=0, i, j, palabrasVocal=0;
        String vocales = "aeiou", sumaVocal="";
        
        for(i = 0; i < cadena.length(); i++){
            
            if (cadena.charAt(i)== ' '){
                vocalesDif=0;
                sumaVocal="";
            }
            
            for(j=0; j < vocales.length(); j++){
                if(sumaVocal.indexOf(cadena.charAt(i))!=-1){
                    
                }
                else if(cadena.charAt(i)==vocales.charAt(j)){
                    sumaVocal+=cadena.charAt(i);
                    vocalesDif+=1;
                }
            }
            
            if (vocalesDif>3){
                vocalesDif=0;
                palabrasVocal += 1;
            }
        }
        
        return palabrasVocal;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cadena =  "modularizar no es murcielago";
        buscaVocales(cadena);
        System.out.println(buscaVocales(cadena));
    }
    
}

