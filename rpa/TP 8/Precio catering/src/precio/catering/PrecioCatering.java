/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precio.catering;
import java.util.Scanner;
/**
 *
 * @author Zambon
 */
public class PrecioCatering {

    /**
     * @param args the command line arguments
     */
    
    public static String menuVeg (String precioVeg){
    
    int precio = 450;
   
    return precioVeg;
}
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int invitados = 140, i=0, acumPrecio = 0;
        String menu, vajilla;
        
        for (i=0; i < invitados; i++) {
        System.out.println("Elija el menú deseado: vegetariano $450, comun $750 y asado criollo $900.");
        menu = sc.nextLine();
       
        if (null == menu) 
        {System.out.println("El menú seleccionado no es válido");}else switch (menu) {
            
                case "vegetariano":
                    acumPrecio = acumPrecio + 450; System.out.println
        ("Elija el tipo de vajilla deseado: elegante suma un 20 % del precio, convencional suma $50."); 
                    vajilla = sc.nextLine(); if (null == vajilla) System.out.println("Ese tipo de vajilla no es válido"); 
                    else switch (vajilla) {
                        
                case "elegante":
                    menuVeg(precioVeg) = menuVeg(menu) + 90;
                    break;
                case "convencional":
                    acumPrecio = acumPrecio + 50;
                    break;
                default:
                    System.out.println("Ese tipo de vajilla no es válido"); i = i - 1; acumPrecio = acumPrecio - 450;
                    break;
            }
                    break;

                    
                case "comun":
                    acumPrecio = acumPrecio + 750; System.out.println
        ("Elija el tipo de vajilla deseado: elegante suma un 20 % del precio, convencional suma $50."); 
                    vajilla = sc.nextLine(); if (null == vajilla) System.out.println("Ese tipo de vajilla no es válido");
                    else switch (vajilla) {
                case "elegante":
                    acumPrecio = acumPrecio + 150;
                    break;
                case "convencional":
                    acumPrecio = acumPrecio + 50;
                    break;
                default:
                    System.out.println("Ese tipo de vajilla no es válido"); i = i - 1; acumPrecio = acumPrecio - 750;
                    break;
            }
                    break;

                    
                case "asado criollo":
                    acumPrecio = acumPrecio + 900; System.out.println
        ("Elija el tipo de vajilla deseado: elegante suma un 20 % del precio, convencional suma $50."); 
                    vajilla = sc.nextLine(); if (null == vajilla) System.out.println("Ese tipo de vajilla no es válido");
                    else switch (vajilla) {
                case "elegante":
                    acumPrecio = acumPrecio + 180;
                    break;
                case "convencional":
                    acumPrecio = acumPrecio + 50;
                    break;
                default:
                    System.out.println("Ese tipo de vajilla no es válido"); i = i - 1; acumPrecio = acumPrecio - 900;
                    break;
            }
                    break;
                    
                default:
                    i = i - 1; System.out.println("El menú seleccionado no es válido");
                    break;
                    
                    
                    
            }
           
        
           
        }
        
        System.out.println("El precio total que se debe pagar a la empresa de catering es de $" + acumPrecio);
          
        
    }
    
    
    
}
