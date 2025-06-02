import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Estructuras.AVL;
import Estructuras.GrafoEtiquetado;
import Estructuras.MapeoAMuchos;

public class Escritura {

    private PrintWriter writer;
    private GrafoEtiquetado ciudades;
    private AVL equipos;
    private MapeoAMuchos partidos;
    
    // Constructor: abre el archivo en modo append
    public Escritura(String nomTxt, GrafoEtiquetado c, AVL e, MapeoAMuchos p) throws IOException {
        writer = new PrintWriter(new FileWriter(nomTxt));
        ciudades=c;
        equipos=e;
        partidos=p;
    }
    
    // Escribe un mensaje en el log y lo fuerza a escribir en disco
    public void escribir(String mensaje) {
        writer.println(mensaje);
        writer.flush();
    }
    
    public void escribirEstructuras(){
        escribir("Grafo de ciudades: " + ciudades.toString());
        escribir("AVL de equipos: " + equipos.toString());
        escribir("Mapeo de partidos: " + partidos.toString());
    }

    // Cierra el archivo
    public void cerrar() {
        writer.close();
    }
}