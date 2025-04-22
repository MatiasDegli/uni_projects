/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.recursivos;

/**
 *
 * @author Zambon
 */
public class NumerosDiferentesR {

    public static int eliminaRepetidos (int n){
        int i, j, palabrasVocal=0;
        String num = "", numDif = "";
        numDif += n;
        
        
        for(i = 0; i < numDif.length(); i++){
            
            
            /*if (numDif.charAt(i)== ' '){
                numDif+=0;
                sumaVocal="";
            }*/
            
            for(j=0; j < num.length(); j++){
                if(num.indexOf(numDif.charAt(i))!=-1){
                    
                }
                else if(num.charAt(i)!=numDif.charAt(j)){
                    num+=numDif.charAt(i);
                }
            }
            
            if (Integer.parseInt(numDif)>3){
                numDif="0";
                palabrasVocal += 1;
            }
        }
        
        return Integer.parseInt(numDif);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n =  2356342;
        //eliminaRepetidos(n);
        //System.out.println(eliminaRepetidos(n));
    }
    
}
