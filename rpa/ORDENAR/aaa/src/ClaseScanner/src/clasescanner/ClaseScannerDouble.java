package clasescanner;
import java.io.*;
import java.util.*;

public class ClaseScannerDouble {
    public static void main(String[] args)throws IOException{
        Scanner leer;
        double a,b,c,total;
        
        leer=new Scanner(System.in);
        System.out.print("Ingresar primer número: ");
        a=leer.nextDouble();
        System.out.print("Ingresar segundo número: ");
        b=leer.nextDouble();
        System.out.print("Ingresar tercer número: ");
        c=leer.nextDouble();
        total=a*0.3+b*0.3+c*0.4;
        System.out.print("\n");
        System.out.println("El porcentaje de los números es : "+total);
        System.out.print("\n");
    }
}
