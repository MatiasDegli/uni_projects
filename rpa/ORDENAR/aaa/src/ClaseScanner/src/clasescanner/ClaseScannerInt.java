package clasescanner;
import java.io.*;
import java.util.*;

public class ClaseScannerInt {
    public static void main(String[] args)throws IOException{
        Scanner leer;
        int a,b,c,total;
        
        leer=new Scanner(System.in);
        System.out.print("Ingresar primer número: ");
        a=leer.nextInt();
        System.out.print("Ingresar segundo número: ");
        b=leer.nextInt();
        System.out.print("Ingresar tercer número: ");
        c=leer.nextInt();
        total=a+b+c;
        System.out.print("\n");
        System.out.println("La suma de los números es : "+total);
        System.out.print("\n");
    }
}
