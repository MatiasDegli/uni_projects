package clasescanner;
import java.io.*;
import java.util.*;

public class ClaseScannerLong {
    public static void main(String[] args)throws IOException {
        Scanner leer;
        long a,b,c,total;
        
        leer=new Scanner(System.in);
        System.out.print("Ingresar primer número: ");
        a=leer.nextLong();
        System.out.print("Ingresar segundo número: ");
        b=leer.nextLong();
        System.out.print("Ingresar tercer número: ");
        c=leer.nextLong();
        total=a-b-c;
        System.out.print("\n");
        System.out.println("La resta de los números es : "+total);
        System.out.print("\n");
    }
}
