/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ciudad.tda;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class TestCiudad {

    static final String NOMBRE_ARCHIVO = "C:\\\\Users\\\\Zambon\\\\Desktop\\\\Proyectos NetBeans\\\\Desarrollo de algoritmos\\\\Ciudad TDA\\\\src\\\\ciudad\\\\tda\\\\ciudades.txt";
    
    private static Ciudad [] cargArrCiudad(int cantCiudades){
        /*Lee el archivo .txt y carga un arreglo de tipo Ciudad 
        con los datos de el texto*/
        String linea;
        int i = 0;
        Ciudad [] arrCiudad = new Ciudad [cantCiudades];
    	
        try{
    		BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
    		while((linea = br.readLine())!=null && i<arrCiudad.length){
                    
                    arrCiudad[i] = creaCiudad(linea);
                    i+=1;
    		}
                
    		br.close();
    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
        return arrCiudad;
    }
    
    
    public static Ciudad creaCiudad(String linea){
        /*Crea y retorna un objeto ciudad en base a un String separado 
        por ";" utilizando el metodo split*/
        String [] parts=linea.split(";");
        String nombre = parts[0];
        int poblacion = Integer.parseInt(parts[1]);
        double latitud = Double.parseDouble(parts[2]);
        double longitud = Double.parseDouble(parts[3]);
        Ciudad ciudad = new Ciudad(nombre, poblacion, latitud, longitud);
        
        return ciudad;
    }
    
    
    public static Ciudad [] eliminaNull(Ciudad [] arr){
        /*Elimina los espacios nulos del arreglo si se ingresa un numero mayor 
        a la cantidad de ciudades del archivo*/
        int i, cont = 0;
        
        for(i=0;i<arr.length;i++){
            if(arr[i]==null){
                cont++;
            }
        }
        
        
        Ciudad [] aux = new Ciudad [arr.length-cont];
        
        for(i=0;i<arr.length;i++){
            if(arr[i]!=null){
                aux[i]=arr[i];
            }
        }
        
        if(cont>0){
            System.out.println("En el archivo hay "+aux.length+" ciudades por lo "
                + "que se han eliminado "+cont+" espacios nulos del arreglo");
        }
        
        return aux;
        
    }
    
    
    public static String buscaDivisores(Ciudad [] arr){
        /*Busca y retorna los divisores a partir de la longitud de un arreglo, 
        si es un num primo devuelve solo dos valores*/
        String divisores="";
        int i = 2;
        
        while(i<(arr.length/2)+1){
            if(arr.length%i==0){
                divisores+=i+",";
            }
            i++;
        }
        
        if(divisores==""){
            divisores+=(2+","+(arr.length/2+1));
        }
        
        if(divisores.charAt(divisores.length()-1)==','){
            divisores=divisores.substring(0, divisores.length()-1);
        }
        
        return divisores;
    }
    
    
    public static void cargarMatriz(Ciudad [] arr, String [][] matriz){
        /*Metodo que carga a una matriz en base a un arreglo, decidi hacerla 
        String para que la impresion fuera mas clara ya 
        que si la hacia Ciudad no se notaba que era fila y que era columna*/
        int i, j, k=0;
        
        for (i = 0; i < matriz.length; i++){
        
            for (j = 0; j < matriz[0].length; j++){
                matriz[i][j] = arr[k].getNombre();
                k++;
                if(k==arr.length){
                    break;
                }
            }
            if(k==arr.length){
                    break;
                }
        }
    }
    
    
    public static void imprimirMatriz(String[][]matriz){
        /*Metodo que imprime una matriz de strings*/
        for (String[] Strings : matriz) {
        System.out.println(Arrays.toString(Strings));
        }
    }
    
    
    public static String [][] copiaMatriz(Ciudad [] arr, String divisores){
        /*Metodo que genera una matriz con distintas medidas en base a un arreglo*/
        Scanner sc = new Scanner(System.in);
        String [] num = divisores.split(",");
        boolean seleccionado=false;
        int cantF=0, cantC=0, i=0, j=(num.length-1),n;
        
        String matrizCiudad[][] = new String[cantF][cantC];
        
        while(seleccionado==false){
            cantF=Integer.parseInt(num[i]);
            cantC=Integer.parseInt(num[j]);
            
            if(cantF*cantC==arr.length){
                System.out.println("La matriz puede tener "+cantF+" filas y "+cantC+""
                    + " columnas.\nPresione 1 para seleccionar esas medidas."
                        + "\nPresione otro numero para seleccionar otras.");
                n=sc.nextInt();
                if(n==1){
                    seleccionado=true;
                }
                else{
                    i++;
                    j--;
                    if(i == num.length || j == -1){
                        i=0;
                        j=num.length-1;
                    }
                }
            }
            else if(cantF*cantC-arr.length==1){
                System.out.println("La matriz debe tener "+cantF+" filas y "+cantC+""
                    + " columnas.\nPresione algun caracter para continuar.");
                
                if(sc.next()!=""){
                    seleccionado = true;
                }
                
            }
            else if(arr.length==0){
                cantF=0;
                cantC=0;
                seleccionado = true;
            }
            matrizCiudad = new String[cantF][cantC];
        }
        cargarMatriz(arr, matrizCiudad);
        
        return matrizCiudad;
    }
    
    
    public static Ciudad [] copiaArr(Ciudad [] arr){
        Ciudad [] arrCopiado = new Ciudad [arr.length];
        int i;
        
        for(i=0;i<arr.length;i++){
            arrCopiado[i]=arr[i];
        }
        
        return arrCopiado;
    }
    
    
    public static int buscaMenor(Ciudad [] arr, int i){
        /*Busca y retorna la posición de la ciudad con menor valor ASCII en el arreglo, 
        a partir de la posicion arr[i]*/
        int posMenor=i+1;
        String menor=arr[i].getNombre();
        
        for(i=posMenor-1;i<arr.length;i++){
            
            if(arr[i].getNombre().compareTo(menor) < 0){
                menor=arr[i].getNombre();
                posMenor=i;
            }
            else if(arr[i].getNombre().compareTo(menor) == 0){
                menor = arr[i].getNombre();
                posMenor=i;
            }
        }
        
        return posMenor;
    }
    
    
    public static int buscaMayor(Ciudad [] arr, int i){
        /*Busca y retorna la posición de la ciudad con mayor valor ASCII en el arreglo, 
        a partir de la posicion arr[i]*/
        int posMayor=i+1;
        String mayor=arr[i].getNombre();
        
        for(i=posMayor-1;i<arr.length;i++){
            
            if(arr[i].getNombre().compareTo(mayor) > 0){
                mayor=arr[i].getNombre();
                posMayor=i;
            }
            else if(arr[i].getNombre().compareTo(mayor) == 0){
                mayor = arr[i].getNombre();
                posMayor=i;
            }
        }
        
        return posMayor;
    }
    
    
    public static void intercambiar(Ciudad [] arr, int pos, int i){
        /*Intercambia el valor de arr[i] por el valor de arr[pos]
        y viceversa*/
        Ciudad aux;
        aux=arr[i];
        arr[i]=arr[pos];
        arr[pos]=aux;
        
    }
    
    
    public static void seleccion(Ciudad [] arr, boolean asc){
        /*Metodo de ordenamiento seleccion para un arreglo Ciudad, puede ser 
        ascendente o descendente dependiendo de la variable asc*/
        int i, pos;
        
        for(i=0; i<arr.length-1; i++){
            if(asc==true){
                pos=buscaMenor(arr, i);
            }
            else{
                pos=buscaMayor(arr, i);
            }
            intercambiar(arr, pos, i);
        }
    }
    
    
    public static boolean vocalOEspacio(int i, int j, String nombre){
        /*Comprueba si la letra en la posición i de una palabra ingresada 
        es una vocal, un espacio u otro caracter*/
        String vocales="aeiouAEIOU";
        boolean es = false;
        
        if (i < nombre.length() && j < vocales.length() && es==false){
            if (nombre.charAt(i) == vocales.charAt(j)){
                es = true;
            }
            else if(nombre.charAt(i)==' ' || nombre.charAt(i)=='�' 
                    || nombre.charAt(i)=='ó' || nombre.charAt(i)=='Å'){ // este caracter:� es una vocal con tilde y lo toma como algo distinto de una vocal 
                es = true;
            }
            else{
                es = vocalOEspacio(i, j+1, nombre);
            }
        }
        
        return es;
    }
    
    
    public static String abreviacion(int i, String nombre, String abreviado){
        /*Retorna una abreviacion del nombre de una ciudad ingresada por parametro*/
        boolean es;
        if(i<nombre.length()){
            es=vocalOEspacio(i,0,nombre);
            if(es==false){
                if(abreviado==""){
                    abreviado+=nombre.toUpperCase().charAt(i);
                }
                else{
                    abreviado+=nombre.charAt(i);
                }
                abreviado=abreviacion(i+1, nombre, abreviado);
            }
            else{
                abreviado=abreviacion(i+1, nombre, abreviado);
            }
        }
        
        return abreviado;
    }
    
    
    public static String arrAbreviado(Ciudad [] arr){
        /*Metodo que muestra los nombres de todas las ciudades del arreglo abreviadas
        llamando al metodo abreviacion*/
        int i;
        String ciudades="";
        
        for(i=0;i<arr.length;i++){
            ciudades+=abreviacion(0, arr[i].getNombre(), "")+"\n";
        }
        
        return ciudades;
    }
    
    
    public static void mergeA(Ciudad [] arr, Ciudad [] izq, Ciudad [] der){
        /*Ordena el arreglo arr de forma ascendente en base a dos arreglos más pequeños*/
        int izqLength = izq.length;
        int derLength = der.length;
        
        int i = 0, j = 0, k = 0;
        
        while (i < izqLength && j < derLength) {
            
            if(izq[i].getNombre().compareTo(der[j].getNombre())<0){
                arr[k] = izq[i];
                i++;
                k++;
            }
            else if(izq[i].getNombre().compareTo(der[j].getNombre())==0){
                arr[k] = der[j];
                j++;
                k++;
            }
            else{
                arr[k] = der[j];
                j++;
                k++;
            }
        }
        
        while (i < izqLength) {
            arr[k] = izq[i];
            i++;
            k++;
        }
        
        while (j < derLength) {
            arr[k] = der[j];
            j++;
            k++;
        }
        
    }
    
    
    public static void mergeSortA(Ciudad [] arr) {
        /*Metodo mergeSort que ordena un arreglo ciudad de manera descendente 
        según sus nombres y tomando los valores ASCII de los caracteres*/
        int longArr = arr.length;
        
        if (longArr < 2) {
            return;
        }

        int med = longArr / 2;
        Ciudad [] izq = new Ciudad[med];
        Ciudad [] der = new Ciudad[longArr - med];

        for(int i = 0; i < med; i++) {
            izq[i] = arr[i];
        }
        for(int i = med; i < longArr; i++) {
            der[i - med] = arr[i];
        }
        
        mergeSortA(izq);
        mergeSortA(der);
        mergeA(arr, izq, der);
    }
    
    
    public static void mergeZ(Ciudad [] arr, Ciudad [] izq, Ciudad [] der){
        /*Ordena el arreglo arr de forma descendente en base a dos arreglos más pequeños*/
        int izqLength = izq.length;
        int derLength = der.length;
        
        int i = 0, j = 0, k = 0;
        
        while (i < izqLength && j < derLength) {
            
            if(izq[i].getNombre().compareTo(der[j].getNombre())>0){
                arr[k] = izq[i];
                i++;
                k++;
            }
            else if(izq[i].getNombre().compareTo(der[j].getNombre())==0){
                arr[k] = izq[i];
                i++;
                k++;
            }
            else{
                arr[k] = der[j];
                j++;
                k++;
            }
        }
        
        while (i < izqLength) {
            arr[k] = izq[i];
            i++;
            k++;
        }
        
        while (j < derLength) {
            arr[k] = der[j];
            j++;
            k++;
        }
        
    }
    
    
    public static void mergeSortZ(Ciudad [] arr) {
        /*Metodo mergeSort que ordena un arreglo ciudad de manera ascendente 
        según sus nombres y tomando los valores ASCII de los caracteres*/
        
        int longArr = arr.length;

        if (longArr < 2) {
            return;
        }

        int med = longArr / 2;
        Ciudad [] izq = new Ciudad[med];
        Ciudad [] der = new Ciudad[longArr - med];

        for(int i = 0; i < med; i++) {
            izq[i] = arr[i];
        }
        for(int i = med; i < longArr; i++) {
            der[i - med] = arr[i];
        }
        
        mergeSortZ(izq);
        mergeSortZ(der);
        mergeZ(arr, izq, der);
    }
    
    
    public static String dosCaracts(Ciudad [] arr){ 
        /*Interprete la consigna de dos manera, por eso hice este metodo y luego el metodo dosCaracts2
        Retorna una lista con las ciudades que comparten 2 o más caracteres*/
        String lista="", letras;
        int i=0, j=i+1, k=0, l=k+2;
        
        
        while(i<arr.length-1){
            
            letras=arr[i].getNombre().substring(k, l);
            
            if(j<arr.length){
                    
                if(arr[j].getNombre().contains(letras)){
                        
                    if(!lista.contains(arr[i].getNombre())){
                        lista+="\n"+arr[i].getNombre()+" coincide en \""+letras+"\" con "+arr[j].getNombre()+"\n";
                    }
                        
                    if(!lista.contains(arr[j].getNombre())){
                        lista+="\n"+arr[j].getNombre()+" coincide en \""+letras+"\" con "+arr[i].getNombre()+"\n";
                    }
                    j++;
                    k=0;
                    l=k+2;
                        
                }
                else{
                    k++;
                    l++;
                    if(k<arr[i].getNombre().length() && l-1<arr[i].getNombre().length()){
                            
                        if(arr[i].getNombre().substring(k, l).contains(" ")){
                            k+=2;
                            l+=2;
                        }
                            
                    }
                    else{
                        j++;
                        k=0;
                        l=k+2;
                    }
                }
            }
            else{
                k=0;
                l=k+2;
                i++;
                j=i+1;
            }
            
        }
            
        return lista;
    }
    
    
    public static String dosCaracts2(Ciudad [] arr){
        /*Retorna una lista con las ciudades que tienen uno o mas caracteres repetidos*/
        int i, j;
        boolean contiene;
        String lista="", letras, letra;
        
        for(i=0;i<arr.length;i++){
            
            contiene=false;
            j=0;
            letras="";
            
            while(j<arr[i].getNombre().length() && contiene==false){
                
                letra=arr[i].getNombre().substring(j, j+1);
                
                if(letras.contains(letra)){
                        
                    if(!lista.contains(arr[i].getNombre())){
                        lista+="\n"+arr[i].getNombre()+" contiene la letra \""+letra+"\" dos o mas veces";
                    }
                    
                    contiene=true;
                }
                else{
                    
                    letras+=letra;
                    j++;
                    
                    if(j+1<arr[i].getNombre().length()){
                        
                        if(arr[i].getNombre().substring(j, j+1).contains(" ")){
                            j++;
                        }
                    }
                }
            }
        }
            
            
        return lista;
    }
    
    
    public static void menu(String nombre, char num, boolean continuar, Ciudad [] arr, int cantCiudades, String [][] matrizCiudades) throws IOException{
        //Menu que imprime por pantalla las opciones del programa, carga arreglos, etc...
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long inicio, fin, t1=0, t2=0, t3=0, t4=0;
        Ciudad [] arrCopiado = copiaArr(arr);
        
        while(continuar==true){
            
            System.out.println("\nPresione 1 si quiere ver el arreglo original de ciudades.\n"
                + "Presione 2 si quiere ver el arreglo en orden ascendente.\n"
                + "Presione 3 si quiere ver el arreglo en orden descendente.\n"
                + "Presione 4 si quiere ver el nombre de una ciudad abreviado.\n"
                + "Presione 5 si quiere ver los nombres de todas las ciudades "
                + "del arreglo abreviados.\n"
                + "Presione 6 si quiere ver la lista de ciudades que tienen 2 o "
                + "mas caracteres iguales entre si.\n"
                + "Presione 7 si quiere ver la lista de ciudades que tienen "
                + "uno o mas caracteres repetidos.\n"
                + "Presione 8 si quiere ver la matriz de ciudades.\n"
                + "Presione 0 si desea terminar.");
                
            num = sc.next().charAt(0);
            
            switch(num){
                
                case '0': System.out.println("Esta para un 10 profe!");
                    continuar=false;
                    System.out.println();
                break;
                
                case '1': arrCopiado = copiaArr(arr);
                    System.out.println(Arrays.toString(arrCopiado));
                    System.out.println();
                break;

                case '2': 
                    System.out.println("Presione 1 para ordenar con metodo mergeSort."
                        + "\nPresione 2 para ordenar con metodo seleccion.");
                    int n = sc.nextInt();

                    if(n==1){
                        arrCopiado = copiaArr(arr);
                        inicio = System.nanoTime();
                        mergeSortA(arrCopiado);
                        fin = System.nanoTime();
                        t1 = fin - inicio;
                        System.out.println(Arrays.toString(arrCopiado));
                        System.out.println();
                        System.out.println("El tiempo de ordenamiento "
                                + "del mergeSort medido en nanosegundos es de : "+t1+"\n");
                        if(t2!=0){
                            if(t1<t2){
                                System.out.println("El metodo mergeSort fue "+(float)t2/t1+" nanosegundos mas rapido que seleccion");//Siempre es mas rapido el mergeSort
                            }
                            else{
                                System.out.println("El metodo seleccion fue "+(float)t1/t2+" nanosegundos mas rapido que mergeSort");
                            }
                        }
                    }
                    else if(n==2){
                        arrCopiado = copiaArr(arr);
                        inicio = System.nanoTime();
                        seleccion(arrCopiado, true);
                        fin = System.nanoTime();
                        t2 = fin - inicio;
                        System.out.println(Arrays.toString(arrCopiado));
                        System.out.println();
                        System.out.println("El tiempo de ordenamiento "
                                + "de seleccion medido en nanosegundos es de : "+t2+"\n");
                        if(t1!=0){
                            if(t2<t1){
                                System.out.println("El metodo seleccion fue "+(float)t1/t2+" veces mas rapido que mergeSort");
                            }
                            else{
                                System.out.println("El metodo mergeSort fue "+(float)t2/t1+" veces mas rapido que seleccion");//Siempre es mas rapido el mergeSort
                            }
                        }
                    }
                    else{
                        System.out.println("El numero ingresado no es valido");
                    }
                break;

                case '3':
                    System.out.println("Presione 1 para ordenar con metodo mergeSort."
                        + "\nPresione 2 para ordenar con metodo seleccion.");
                    int n2 = sc.nextInt();

                    if(n2==1){
                        arrCopiado = copiaArr(arr);
                        inicio = System.nanoTime();
                        mergeSortZ(arrCopiado);
                        fin = System.nanoTime();
                        t3 = fin - inicio;
                        System.out.println(Arrays.toString(arrCopiado));
                        System.out.println();
                        System.out.println("El tiempo de ordenamiento "
                                + "del mergeSort medido en nanosegundos es de : "+t3+"\n");
                        if(t4!=0){
                            if(t3<t4){
                                System.out.println("El metodo mergeSort fue "+(float)t4/t3+" veces mas rapido que seleccion");//Siempre es mas rapido el mergeSort
                            }
                            else{
                                System.out.println("El metodo seleccion fue "+(float)t3/t4+" veces mas rapido que mergeSort");
                            }
                        }
                    }
                    else if(n2==2){
                        arrCopiado = copiaArr(arr);
                        inicio = System.nanoTime();
                        seleccion(arrCopiado, false);
                        fin = System.nanoTime();
                        t4 = fin - inicio;
                        System.out.println(Arrays.toString(arrCopiado));
                        System.out.println();
                        System.out.println("El tiempo de ordenamiento "
                                + "de seleccion medido en nanosegundos es de : "+t4+"\n");
                        if(t3!=0){
                            if(t4<t3){
                                System.out.println("El metodo seleccion fue "+(float)t3/t4+" veces mas rapido que mergeSort");
                            }
                            else{
                                System.out.println("El metodo mergeSort fue "+(float)t4/t3+" veces mas rapido que seleccion");//Siempre es mas rapido el mergeSort
                            }
                        }
                    }
                    else{
                        System.out.println("El numero ingresado no es valido");
                    }
                break;
                
                case '4': System.out.println("Ingrese el nombre de la ciudad que quiere abreviar");
                    nombre = br.readLine();
                    System.out.println(abreviacion(0, nombre, ""));                
                    System.out.println();
                break;
                
                case '5': System.out.println(arrAbreviado(arrCopiado));
                break;
                
                case '6': System.out.println(dosCaracts(arrCopiado));
                    System.out.println();
                break;
                
                case '7': System.out.println(dosCaracts2(arrCopiado));
                    System.out.println();
                break;
                
                case '8': String divisores = buscaDivisores(arrCopiado);
                    matrizCiudades = copiaMatriz(arrCopiado, divisores);
                    imprimirMatriz(matrizCiudades);
                break;
                
                default: System.out.println("El numero ingresado no es valido, pruebe con otro.");
                break;
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        String nombre = "";
        char num = ' ';
        boolean continuar = true;
        Ciudad [] arr;
        int cantCiudades;
        String [][] matrizCiudades = new String [0][0];
        
        
        System.out.println("Ingrese la cantidad de ciudades que hay en el archivo");
        cantCiudades = sc.nextInt();
        
        arr = cargArrCiudad(cantCiudades);
        arr=eliminaNull(arr);
        
        menu(nombre, num, continuar, arr, cantCiudades, matrizCiudades);
    }
    
}



