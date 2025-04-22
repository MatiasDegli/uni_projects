package clasescanner;
import java.io.*;
import java.util.*;

public class ClaseScannerNextLine {
    public static void main(String[] args) throws IOException {
        Scanner leer;
        String cc,nom,dire,tele;
        
        leer=new Scanner(System.in);
        System.out.print("Ingresar Cédula: ");
        cc=leer.nextLine();
        System.out.print("Ingresar nombre completo: ");
        nom=leer.nextLine();
        System.out.print("Ingresar dirección: ");
        dire=leer.nextLine();
        System.out.print("Ingresar número de celular: ");
        tele=leer.nextLine();
        System.out.print("\n\nResultados...\n");
        System.out.println("C.C : "+cc);
        System.out.println("Nombre : "+nom);
        System.out.println("Dirección : "+dire);
        System.out.println("Celular : "+tele);
        System.out.println();
    }
}
