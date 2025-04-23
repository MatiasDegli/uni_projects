/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.terreno;
import java.util.Scanner;

/**
 *
 * @author Zambon
 */
 public class TestTerreno {

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Terreno t1=new Terreno(11,1,30,40), t2 = new Terreno(21,2,19,32), 
                t3= new Terreno(23,3,19,32), t4= new Terreno(22,3,19,32), 
                t5= new Terreno(24,3,19,32), t6= new Terreno(25,4,19,32) ,t7= new Terreno(26,3,19,32), t8=new Terreno(11,1,30,40);
                
        int cantTer, i, manzana;
        String acumMan = "";
        
        System.out.println(t1.toString());
        
        System.out.println("Son iguales: "+t1.equalsCod(t7));
        
        System.out.println("Ingrese la cantidad de terrenos");
        cantTer = sc.nextInt();
        
        System.out.println("Ingrese la manzana que quiere analizar");
        manzana = sc.nextInt();
        
        
        for (i=0; i<cantTer; i++){
        
        if (t1.getManzana()== manzana){
        acumMan = acumMan+="Terreno 1, ";
        }
        
        }
        
        
        /*System.out.println("El perimetro del terreno es "+t1.perimetro()+" mts");
        System.out.println("Si desea poner un cerco que rodee el terreno tres veces necesitara "+3*t1.perimetro()+" mts de alambrado.");
        System.out.println("La superficie del terreno es "+t1.superficie()+" mts cuadrados");
        System.out.println("El costo de la limpieza del terreno sera de $ "+150*t1.superficie());
        System.out.println("Ingrese el costo de metro cuadrado de terreno");
        double pres = sc.nextDouble();
        System.out.println("El valor del terreno es de $ "+t1.valor(pres));*/
        
        System.out.println("Las dimensiones del terreno 1 son "+t1.superficie()+" mts cuadrados");
    }
    
    
}

/*ejercicio 7:Diseñar un algoritmo que implemente un arreglo de objetos de tipo Terreno. El algoritmo debe presentar un menú de opciones para realizar las siguientes acciones: 
• Encontrar el terreno más grande
 • Dado un código de terreno mostrar sus dimensiones
 • Dada una manzana mostrar los datos de cada uno de los terrenos que se encuentran en ella. 
• Mostrar el precio de cada uno de los terrenos (solicite el valor del metro cuadrado al usuario, es el mismo para todos los terrenos).
UML

terreno
-codigo(int)
-base(double)
-altura(double)
-manzana(int)
constructores
+terreno(int elCodigo, int laManzana, double laBase, double laAltura)
+terreno()
observadores
+getCodigo: int
+getBase: double
+getAltura: double
+getManzana: int
+toString: String
modificadores
+setCodigo(int elcodigo): void
+setBase(double laBase):void
+setAltura(double laAltura): void
+setManzana(int laManzana): void
propias del tipo
+ perimetro(): double
+superficie(): double
+valor(double precioMtsCuadrados):double
+equals(Terreno otroTerreno): boolean
+equalsDos(Terreno otroTerreno): boolean
+equalsTres(Terreno otroTerreno): boolean
*/
