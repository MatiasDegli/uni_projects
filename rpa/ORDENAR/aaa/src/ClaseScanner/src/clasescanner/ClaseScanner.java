package clasescanner;
import java.io.*;
import java.util.*;

public class ClaseScanner {
    public static void main(String[] args) throws IOException {
        Scanner leer;
        int a;
        long b;
        float c;
        double d;
        String cadena;
        BufferedReader teclado;
        
        leer=new Scanner(System.in);
        teclado=new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Ingresar un valor de tipo numérico <int> ");
        a=leer.nextInt();
        System.out.print("Ingresar un valor de tipo numérico <long> ");
        b=leer.nextLong();
        System.out.print("Ingresar un valor de tipo numérico <float> ");
        c=leer.nextFloat();
        System.out.print("Ingresar un valor de tipo numérico <double> ");
        d=leer.nextDouble();
        System.out.print("Ingresar un valor de tipo cadena <String> ");
        cadena=teclado.readLine();
        
        System.out.println("\n\nResultados");
        System.out.println("El valor numérico <int> es "+a);
        System.out.println("El valor numérico <long> es "+b);
        System.out.println("El valor numérico <float> es "+c);
        System.out.println("El valor numérico <double> es "+d);
        System.out.println("El valor cadena <String> es "+cadena);
        System.out.println("\n\n");
    }
}
