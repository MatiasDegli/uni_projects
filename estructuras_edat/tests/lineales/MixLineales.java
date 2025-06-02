/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

/**
 *
 * @author matia
 */
public class MixLineales {
    
    public static Cola generarOtraCola(Cola c1){
        Cola invert = new Cola();
        Pila aux = new Pila();
        char c;
        
        while(!c1.esVacia()){
            c = (char) c1.obtenerFrente();
            
            if(c!='$'){
                invert.poner(c);
                aux.apilar(c);
            }
            else{
                
                while(aux.obtenerTope()!=null){
                    invert.poner(aux.obtenerTope());
                    aux.desapilar();
                }
                
                invert.poner(c);
            }
            
            c1.sacar();
            
            if(c1.esVacia()){
                while(aux.obtenerTope()!=null){
                    invert.poner(aux.obtenerTope());
                    aux.desapilar();
                }
            }
        }
        
        return invert;
    }
    
    
    public static Lista generarLista(Lista lis){
        Lista mod = new Lista();
        Pila auxP = new Pila();
        Cola aux = new Cola();
        int j=1;
        
        for(int i=1; i < lis.longitud()+1; i++){
            
            if(!lis.recuperar(i).equals('*')){
                aux.poner(lis.recuperar(i));
                auxP.apilar(lis.recuperar(i));
                mod.insertar(j, lis.recuperar(i));
                j++;
                
                if(lis.recuperar(i+1)==null){
                    
                    while(auxP.obtenerTope()!=null){
                        mod.insertar(j, auxP.obtenerTope());
                        j++;
                        auxP.desapilar();
                    }
                    
                    while(aux.obtenerFrente()!=null){
                        mod.insertar(j, aux.obtenerFrente());
                        j++;
                        aux.sacar();
                    }
                }
            }
            else{
                while(auxP.obtenerTope()!=null){
                    mod.insertar(j, auxP.obtenerTope());
                    j++;
                    auxP.desapilar();
                }
                    
                while(aux.obtenerFrente()!=null){
                    mod.insertar(j, aux.obtenerFrente());
                    j++;
                    aux.sacar();
                }
                
                mod.insertar(j, '*');
                j++;
            }
        }
        
        return mod;
    }
    
    
    public static Cola generar(Cola c1){
	Pila auxP = new Pila();
	Cola mod = new Cola();
	Cola aux = new Cola();
	
	while(c1.obtenerFrente()!=null){
		
            if(!c1.obtenerFrente().equals('#')){
                
                auxP.apilar(c1.obtenerFrente());
                aux.poner(c1.obtenerFrente());
                mod.poner(c1.obtenerFrente());	

                c1.sacar();

                if(c1.obtenerFrente()==null){

                    while(auxP.obtenerTope()!=null){
                        mod.poner(auxP.obtenerTope());
                        auxP.desapilar();
                    }

                    while(aux.obtenerFrente()!=null){
                        mod.poner(aux.obtenerFrente());
                        aux.sacar();
                    }

                }

            }

            else{

                while(auxP.obtenerTope()!=null){
                        mod.poner(auxP.obtenerTope());
                        auxP.desapilar();
                }

                while(aux.obtenerFrente()!=null){
                        mod.poner(aux.obtenerFrente());
                        aux.sacar();
                }

                mod.poner('#');
                c1.sacar();
            }
	
	}
	
        return mod;
    }
    
    
    public static boolean verificarBalanceo(Cola q){
	boolean balance = true;
	
	Pila auxP = new Pila();

	while(q.obtenerFrente()!=null && balance == true){
		
		Object elem = q.obtenerFrente();
		
		if(elem.equals('(') || elem.equals('{') || elem.equals('[')){
		
			auxP.apilar(elem);

		}
		else if(elem.equals(')')){

			Object tope = auxP.obtenerTope();

			balance = (tope!=null && tope.equals('('));

			auxP.desapilar();
		}
		else if(elem.equals('}')){ 

			Object tope = auxP.obtenerTope();

			balance = (tope!=null && tope.equals('{'));
			
			auxP.desapilar();

		}
	 	else if(elem.equals(']')){ 
					
			Object tope = auxP.obtenerTope();

			balance = (tope!=null && tope.equals('['));
			
			auxP.desapilar();
			
		}
                
                q.sacar();
                
	}
        
        if(auxP.obtenerTope()!=null){
            balance=false;
        }    
        
	return balance;
    }
    
    
    
    public static void main(String[] args) {
        
        Cola c2 = new Cola();
        Cola c3;

        c2.poner('A');
        c2.poner('B');
        c2.poner('$');
        c2.poner('C');
        c2.poner('$');
        c2.poner('D');
        c2.poner('E');
        c2.poner('F');

        System.out.println(c2.toString());

        c3 = generarOtraCola(c2);

        System.out.println(c3.toString());
        
        Lista l1 = new Lista();
        
        l1.insertar(l1.longitud()+1, 'A');
        l1.insertar(l1.longitud()+1, 'B');
        l1.insertar(l1.longitud()+1, '*');
        l1.insertar(l1.longitud()+1, 'C');
        l1.insertar(l1.longitud()+1, '*');
        l1.insertar(l1.longitud()+1, 'D');
        l1.insertar(l1.longitud()+1, 'E');
        l1.insertar(l1.longitud()+1, 'F');
        
        System.out.println("Lista: "+l1.toString());
            
        System.out.println("Lista mod: "+generarLista(l1).toString());
        
        
        Cola c4 = new Cola();
        
        c4.poner('A');
        c4.poner('B');
        c4.poner('#');
        c4.poner('C');
        c4.poner('#');
        c4.poner('D');
        c4.poner('E');
        c4.poner('F');
        
        
        System.out.println("Mod: "+generar(c4).toString());
        
        Cola m = new Cola();
        
        m.poner('[');
        m.poner('(');
        m.poner('{');
        m.poner('8');
        m.poner('+');
        m.poner('8');
        m.poner('}');
        
        System.out.println("cadena matematica: "+m.toString());
        
        System.out.println("cadena matematica es balanceada? "+verificarBalanceo(m));
        
    }
    
}
