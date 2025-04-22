/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

import lineales.dinamicas.Lista;

/**
 *
 * @author matia
 */
public class PruebaLista {
    
    public static Lista concatenar(Lista l1, Lista l2){
        Lista concat = new Lista();
        int i=1, j=1;
        
        while(l1.recuperar(i)!=null){
            concat.insertar(i, l1.recuperar(i));
            i++;
        }
        
        while(l2.recuperar(j)!=null){
            concat.insertar(i, l2.recuperar(j));
            i++;
            j++;
        }
        
        return concat;
    }
    
    
    public static boolean comprobar(Lista l1){
        boolean exito=true;
        int i=1, n=1;
        String cadena="", invertida="";
        
        while(l1.recuperar(n)!=null && !l1.recuperar(n).equals('0')){
            cadena+=l1.recuperar(n).toString();
            n++;
        }
        
        n=0;
        
        for (int j = cadena.length()-1; j >= 0; j--){
            invertida+=cadena.charAt(j);
        }
        
        while(l1.recuperar(i)!=null && exito == true){
            
            if(l1.recuperar(i).equals('0')){
                i++;
                n=0;
            }
            else if(n>cadena.length()-1){
                exito=false;
            }
            else{
                if(i>=cadena.length()*2+2){
                    //la lista debe tener la cadena invertida a partir de 
                    //esta posicion
                    
                    if(!l1.recuperar(i).equals(invertida.charAt(n))){
                        exito=false;
                    }
                }
                else if(!l1.recuperar(i).equals(cadena.charAt(n))){
                    //La cadena tiene un caracter distinto en la segunda iteracion
                    exito=false;
                }
                i++;
                n++;
            }
        }
        
        return exito;
    }
    
    
    public static Lista invertir(Lista l1){
        Lista invertida = new Lista();
        String cadena="";
        int i=1, n=1;

        while(l1.recuperar(n)!=null && !l1.recuperar(n).equals('0')){
            cadena+=l1.recuperar(n).toString();
            n++;
        }
        
        for (int j = cadena.length()-1; j >=0; j--) {
            invertida.insertar(i, cadena.charAt(j));
            i++;
        }
        
        return invertida;
    }
    
    
    public static Lista intercalar(Lista l1, Lista l2){
        Lista l3 = new Lista();
        int i=1,j=1;
        
        while(l1.recuperar(i)!=null || l2.recuperar(j)!=null){
            
            if(l1.recuperar(i)!=null){
                l3.insertar(l3.longitud()+1, l1.recuperar(i));
                i++;
            }
            
            if(l2.recuperar(j)!=null){
                l3.insertar(l3.longitud()+1, l2.recuperar(j));
                j++;
            }
        }
        
        return l3;
    }
    
    
    public static int contar(Lista lis, Object elem){
        int cant=0;
        
        for (int i = 1; i < lis.longitud()+1; i++) {
            
            if(lis.recuperar(i).equals(elem)){
                cant++;
            }
            
        }
        
        return cant;
    }
    
    
    public static int contarRecursivo(Lista lis, Object elem, int cant, int i){
        
        if(i<lis.longitud()+1){
            
            if(lis.recuperar(i).equals(elem)){
                cant++;
            }
            cant=contarRecursivo(lis, elem, cant, i + 1);
        }
        
        return cant;
    }
    
    
    public static boolean esCapicua(Lista lis){
        boolean exito=true;
        boolean esPar = lis.longitud()%2==0;
        int mitad=lis.longitud()/2, i=1, j=mitad;
        Lista control = new Lista();
        
        while(i < lis.longitud()+1 && exito==true){
            
            if(i<=mitad){
                control.insertar(control.longitud()+1,lis.recuperar(i));
            }
            else{
                if(!esPar){
                    i++;
                    esPar=true;
                }
                if(!control.recuperar(j).equals(lis.recuperar(i))){
                    exito=false;
                }
                j--;
            }
            i++;
        }
        
        return exito;
    }
    
    
    public static void main(String[] args) {
        
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        Lista l3;
        
        l1.insertar(1, 2);
        l1.insertar(2, 4);
        l1.insertar(3, 6);
        
        l2.insertar(1, 5);
        l2.insertar(2, 1);
        l2.insertar(3, 6);
        l2.insertar(4, 7);
        
        System.out.println(l1);
        System.out.println(l2);
        
        l3 = concatenar(l1,l2);
        
        System.out.println("concatenar: "+l3);
        
        Lista l4 = new Lista();
        l4.insertar(1, 'o');
        l4.insertar(2, 'l');
        l4.insertar(3, 'a');
        l4.insertar(4, '0');
        
        l4.insertar(5, 'o');
        l4.insertar(6, 'l');
        l4.insertar(7, 'a');
        l4.insertar(8, '0');
        
        l4.insertar(9, 'a');
        l4.insertar(10, 'l');
        l4.insertar(11, 'o');
        
        System.out.println("comprobar: "+comprobar(l4));
        
        System.out.println("invertir concat: "+invertir(l3).toString());
        
        System.out.println("Intercalar: "+intercalar(l1, l2).toString());
        
        l3.insertar(l3.longitud()+1, 6);
        l3.insertar(l3.longitud()+1, 6);
        l3.insertar(l3.longitud()+1, 6);
        
        System.out.println("Contar 6: "+contar(l3, 6));
        
        System.out.println("Contar 6: "+contarRecursivo(l3, 6, 0, 1));
        
        Lista capicua = new Lista();
        
        capicua.insertar(capicua.longitud()+1, 1);
        capicua.insertar(capicua.longitud()+1, 2);
        capicua.insertar(capicua.longitud()+1, 3);
        capicua.insertar(capicua.longitud()+1, 4);
        capicua.insertar(capicua.longitud()+1, 4);
        capicua.insertar(capicua.longitud()+1, 3);
        capicua.insertar(capicua.longitud()+1, 2);
        capicua.insertar(capicua.longitud()+1, 1);
        capicua.insertar(capicua.longitud()+1, 1);
        
        System.out.println(capicua.toString());
        
        System.out.println("Capicua es capicua? "+esCapicua(capicua));
    }
    
}
