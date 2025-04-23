/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.terreno;

/**
 *
 * @author Zambon
 */
public class Terreno {
    
    //atributos
    private int codigo;
    private double base;
    private double altura;
    private int manzana;
    
    //constructores
    public Terreno(int cod){
        base=0;
        altura=0;
        manzana=0;
    }
    public Terreno(int cod, double ba,double al, int man){
        codigo=cod;
        base=ba;
        altura=al;
        manzana=man;
    }
    
    //observadores
    public int getCodigo(){
        return codigo;
    }
    
    public double getBase(){
        return base;
    }
    
    public double getAltura(){
        return altura;
    }
   
    public int getManzana(){
        return manzana;
    }
    
    public String toString(){
        String cadena = "\nCodigo: " +getCodigo() + "\nBase: "+getBase()+"\nAltura: "+getAltura()+ "\nManzana: "+ getManzana(); 
        return cadena;           
    }
    
    
    //modificadores
    public void setManzana(int man){
        manzana=man;
    }
    
    public void setAltura(double al){
        altura=al;
    }
    
    public void setBase(double ba){
        base=ba;
    }
    
    
    //Propias del tipo
    public double perimetro(){
        double perimetro=2*(base*altura);
        return perimetro;            
    }
    
    public double superficie(){
        double superficie=base*altura;
        return superficie;
    }
    
    public double valor(double precio){
    return (precio*(base*altura));
    }
    
    public boolean equalsTer(Terreno otroTer){
        return (this.codigo==otroTer.codigo && this.base==otroTer.base && this.altura==otroTer.altura && this.manzana==otroTer.manzana);
    }
    
    public boolean equalsCod(Terreno otroCod){
        return this.codigo==otroCod.codigo;
    }
    
    public boolean equalsMan(Terreno otraMan){
        return this.manzana==otraMan.manzana;
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
