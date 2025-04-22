package clasescanner;
import java.io.*;
import java.util.*;

public class ClaseScannerFloat {
    public static void main(String[] args)throws IOException{
        Scanner leer;
        float a,b,c,total;
        
        leer=new Scanner(System.in);
        System.out.print("Ingresar primer número: ");
        a=leer.nextFloat();
        System.out.print("Ingresar segundo número: ");
        b=leer.nextFloat();
        System.out.print("Ingresar tercer número: ");
        c=leer.nextFloat();
        total=(a+b+c)/3;
        System.out.print("\n");
        System.out.println("El promedio de los números es : "+total);
        System.out.print("\n");
    }
}
