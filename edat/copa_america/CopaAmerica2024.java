import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import Estructuras.AVL;
import Estructuras.GrafoEtiquetado;
import Estructuras.Lista;
import Estructuras.MapeoAMuchos;
import TDAs.Ciudad;
import TDAs.Equipo;
import TDAs.EquipoGoles;
import TDAs.Partido;
import TDAs.PartidoKey;


public class CopaAmerica2024 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner scanner = new Scanner(System.in);

        GrafoEtiquetado ciudades = new GrafoEtiquetado();
        AVL equipos = new AVL();
        MapeoAMuchos partidos = new MapeoAMuchos();
        Escritura logger = new Escritura("LOG.txt", ciudades, equipos, partidos);

        String texto = "CopaAmerica2024.txt";

        System.out.println("Presione cualquier caracter para iniciar la carga o 1 si quiere finalizar el programa");
        String inicio = scanner.nextLine();

        if (!inicio.equals("1")) {
            cargarDatos(texto, equipos, partidos, ciudades);
            logger.escribir("Estado inicial del sistema:");
            logger.escribirEstructuras();
            mostrarSistema(ciudades, equipos, partidos);

            int opcion = 0;

            while (opcion != 5) {
                System.out.println("MENU PRINCIPAL");
                System.out.println("1. Operaciones de Ciudades");
                System.out.println("2. Operaciones de Equipos");
                System.out.println("3. Operaciones de Partidos");
                System.out.println("4. Visualizar estructuras");
                System.out.println("5. Finalizar programa");
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        menuCiudades(ciudades, logger);
                        break;
                    case 2:
                        menuEquipos(equipos, partidos, logger);
                        break;
                    case 3:
                        menuPartidos(partidos, equipos, logger);
                        break;
                    case 4:
                        mostrarSistema(ciudades, equipos, partidos);
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
        }

        scanner.close();
        logger.escribir("Las estructuras quedaron de la siguiente manera: ");
        logger.escribirEstructuras();
        logger.cerrar();
    }

    private static void mostrarSistema(GrafoEtiquetado ciudades, AVL equipos, MapeoAMuchos partidos) {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("1. Visualizar ciudades");
            System.out.println("2. Visualizar equipos");
            System.out.println("3. Visualizar partidos");
            System.out.println("4. Volver al menu principal");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println(ciudades.toString());
                    break;
                case 2:
                    System.out.println(equipos.toString());
                    break;
                case 3:
                    System.out.println(partidos.toString());
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void cargarDatos(String texto, AVL equipos, MapeoAMuchos partidos, GrafoEtiquetado ciudades)
            throws FileNotFoundException, IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(texto))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datosLinea = linea.split(";");

                if (datosLinea[0].equals("E")) {
                    cargarEquipo(datosLinea, equipos);
                } else if (datosLinea[0].equals("P")) {
                    cargarPartido(datosLinea, partidos, equipos);
                } else if (datosLinea[0].equals("C")) {
                    cargarCiudad(datosLinea, ciudades);
                } else if (datosLinea[0].equals("R")) {
                    cargarRuta(datosLinea, ciudades);
                }
            }
        }
    }

    public static void cargarCiudad(String[] datos, GrafoEtiquetado ciudades) {
        String nombre = datos[1];
        boolean disponibilidad = datos[2].equals("TRUE");
        boolean sede = datos[3].equals("TRUE");

        Ciudad ciudad = new Ciudad(nombre, disponibilidad, sede);

        ciudades.insertarVertice(ciudad);
    }

    public static void cargarEquipo(String[] datos, AVL equipos) {
        String nombre = datos[1];
        String DT = datos[2];
        char grupo = datos[3].charAt(0);

        Equipo equipo = new Equipo(nombre, DT, grupo);

        equipos.insertar(equipo);
    }

    public static void cargarPartido(String[] datos, MapeoAMuchos partidos, AVL equipos) {
        String eq1 = datos[1];
        String eq2 = datos[2];

        PartidoKey key = new PartidoKey(eq1, eq2);

        Equipo equipo1 = new Equipo(eq1, "xx", 'X');
        Equipo equipo2 = new Equipo(eq2, "xx", 'X');

        String ins = datos[3];
        String ciudad = datos[4];
        String estadio = datos[5];
        int gol1 = Integer.parseInt(datos[6]);
        int gol2 = Integer.parseInt(datos[7]);

        equipo1 = (Equipo) equipos.obtenerIgual(equipo1);
        equipo2 = (Equipo) equipos.obtenerIgual(equipo2);

        equipo1.sumarGoles(gol1);
        equipo1.sumarEnContra(gol2);
        equipo2.sumarGoles(gol2);
        equipo2.sumarEnContra(gol1);

        if (ins.equals("GRUPO")) {
            if (gol1 > gol2) {
                equipo1.sumarPuntos(3);
            } else if (gol2 > gol1) {
                equipo2.sumarPuntos(3);
            } else {
                equipo1.sumarPuntos(1);
                equipo2.sumarPuntos(1);
            }
        }

        Partido partido = new Partido(ins, ciudad, estadio, gol1, gol2);

        partidos.asociar(key, partido);
    }

    public static void cargarRuta(String[] datos, GrafoEtiquetado ciudades) {
        String c1 = datos[1];
        String c2 = datos[2];
        int mins = Integer.parseInt(datos[3]);

        Ciudad origen = new Ciudad(c1, false, false);
        Ciudad destino = new Ciudad(c2, false, false);

        ciudades.insertarArco(origen, destino, mins);
    }

    public static void menuCiudades(GrafoEtiquetado ciudades, Escritura logger) {
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("8")) {
            System.out.println(menuCiudadAux());

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarCiudad(ciudades, logger);
                    break;

                case "2":
                    eliminarCiudad(ciudades, logger);
                    break;

                case "3":
                    modificarCiudad(ciudades);
                    break;

                case "4":
                    menorEscala(ciudades);
                    break;

                case "5":
                    menorTiempo(ciudades);
                    break;

                case "6":
                    menorTiempoAlt(ciudades);
                    break;

                case "7":
                    caminosCompleto(ciudades);
                    break;

                case "8":

                    break;

                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
    }

    private static String menuCiudadAux() {
        String mensaje = "Ingrese 1 para agregar una ciudad.\n" +
                "Ingrese 2 para eliminar una ciudad.\n" +
                "Ingrese 3 para modificar una ciudad\n" +
                "Ingrese 4 si quiere conocer el camino de una ciudad a otra con la menor cantidad de escalas posibles\n"
                +
                "Ingrese 5 si quiere conocer el camino de una ciudad a otra con el menor tiempo de vuelo posible\n" +
                "Ingrese 6 si quiere conocer el camino de una ciudad a otra con el menor tiempo de vuelo posible sin pasar por"
                +
                "una ciudad dada\n" +
                "Ingrese 7 si quiere ver todos los caminos posibles entre dos ciudades dadas\n" +
                "Ingrese 8 si quiere volver al menu principal";

        return mensaje;
    }

    public static void agregarCiudad(GrafoEtiquetado ciudades, Escritura logger) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad");
        String nombre = scanner.nextLine().toUpperCase();

        if (ciudades.existeElem(nombre)) {
            System.out.println("La ciudad ya es parte del mapa\n");
        } else {
            System.out.println("Indique la disponibilidad");
            boolean disponibilidad = ("TRUE".equals(scanner.nextLine().toUpperCase()));
            System.out.println("Indique si es sede");
            boolean sede = ("TRUE".equals(scanner.nextLine().toUpperCase()));

            Ciudad ciudad = new Ciudad(nombre, disponibilidad, sede);

            ciudades.insertarVertice(ciudad);
            System.out.println("La ciudad fue agregada con exito\n");

            logger.escribir("Se agregó la ciudad "+nombre);
        }

    }

    public static void eliminarCiudad(GrafoEtiquetado ciudades, Escritura logger) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad");
        String nombre = scanner.nextLine();

        if (ciudades.existeElem(nombre)) {
            ciudades.eliminarVertice(nombre);
            System.out.println("La ciudad fue eliminada con exito");

            logger.escribir("Se eliminó la ciudad "+nombre);
        } else {
            System.out.println("La ciudad no es parte del mapa");
        }
    }

    public static void modificarCiudad(GrafoEtiquetado ciudades) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad");
        String nombre = scanner.nextLine().toUpperCase();
        Ciudad ciudad = new Ciudad(nombre, false, false);
        ciudad = (Ciudad) ciudades.getElem(ciudad);

        if (ciudad != null) {
            String opcion = "";

            while (!opcion.equals("3")) {

                System.out.println(
                        "Ingrese 1 si desea modificar la disponibilidad, 2 si desea modificar si la ciudad es o no es sede, "
                                + "3 si quiere volver al menu principal");
                opcion = scanner.nextLine();

                switch (opcion) {
                    case "1":
                        System.out.println("Ingrese true si hay disponibilidad, de lo contrario ingrese false");
                        String disp = scanner.nextLine().toUpperCase();
                        ciudad.setDisponibilidad(disp.equals("TRUE"));
                        break;

                    case "2":
                        System.out.println("Ingrese true si es sede, de lo contrario ingrese false");
                        String sede = scanner.nextLine().toUpperCase();
                        ciudad.setSede(sede.equals("TRUE"));
                        break;

                    case "3":
                        break;

                    default:
                        System.out.println("Cadena inválida");
                        break;
                }
            }
            System.out.println("La ciudad se modifico con exito");
        } 
        else {
            System.out.println("La ciudad no es parte del mapa");
        }
    }

    public static void menuEquipos(AVL equipos, MapeoAMuchos partidos, Escritura logger) {
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("7")) {
            System.out.println(menuEquipoAux());

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarEquipo(equipos, logger);
                    break;
                case "2":
                    eliminarEquipo(equipos, logger);
                    break;
                case "3":
                    modificarEquipo(equipos);
                    break;
                case "4":
                    datosPais(equipos, partidos);
                    break;
                case "5":
                    rangoAlfabetico(equipos);
                    break;
                case "6":
                    listaGoles(equipos);
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
    }

    private static String menuEquipoAux() {
        String mensaje = "Ingrese 1 para agregar un equipo.\n" +
                "Ingrese 2 para eliminar un equipo.\n" +
                "Ingrese 3 para modificar un equipo\n" +
                "Ingrese 4 si quiere ver los datos de una selección\n" +
                "Ingrese 5 si quiere ver los equipos por orden alfabético entre dos cadenas dadas\n" +
                "Ingrese 6 si quiere ver los equipos por orden de goles a favor\n" +
                "Ingrese 7 si quiere volver al menu principal";

        return mensaje;
    }

    public static void agregarEquipo(AVL equipos, Escritura logger) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del pais");
        String pais = scanner.nextLine();

        System.out.println("Ingresar nombre del DT");
        String dt = scanner.nextLine();

        System.out.println("Ingrese el grupo al que pertenece");
        char grupo = scanner.nextLine().charAt(0);

        Equipo equipo = new Equipo(pais, dt, grupo);

        equipos.insertar(equipo);
        logger.escribir("Se agrego al equipo "+pais);
    }

    public static void eliminarEquipo(AVL equipos, Escritura logger) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del equipo");
        String pais = scanner.nextLine();
        Equipo equipo = new Equipo(pais, "xx", 'X');
        equipo = (Equipo) equipos.obtenerIgual(equipo);

        if (equipo != null) {
            equipos.eliminar(equipo);
            System.out.println("El equipo fue eliminado con exito");
            System.out.println("Se elimino al equipo "+pais);
        } else {
            System.out.println("El equipo no es parte del fixture");
        }
    }

    public static void modificarEquipo(AVL equipos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del equipo que desea modificar");
        String nombre = scanner.nextLine().toUpperCase();

        Equipo equipo = new Equipo(nombre, "xx", 'X');
        equipo = (Equipo) equipos.obtenerIgual(equipo);

        if (equipo != null) {
            String opcion = "";

            while (!opcion.equals("3")) {

                System.out.println("Ingrese 1 si desea modificar el DT, 2 si desea modificar el grupo, "
                        + "3 si quiere salir del menu");
                opcion = scanner.nextLine();

                switch (opcion) {
                    case "1":
                        System.out.println("Ingrese el nombre del DT");
                        String dir = scanner.nextLine();
                        equipo.setDT(dir);
                        break;
                    case "2":
                        System.out.println("Ingrese el nuevo grupo");
                        break;
                    case "3":
                        break;
                    default:
                        System.out.println("Cadena inválida");
                        break;
                }
            }
            System.out.println("El equipo se modifico con exito");
        } else {
            System.out.println("El equipo no es parte del fixture");
        }

    }

    public static void menuPartidos(MapeoAMuchos partidos, AVL equipos, Escritura logger) {
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("3")) {
            System.out.println(menuPartidoAux());

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarPartido(partidos, equipos, logger);
                    break;
                case "2":
                    resultados(partidos);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
    }

    private static String menuPartidoAux() {
        String mensaje = "Ingrese 1 para agregar un partido.\n" +
                "Ingrese 2 para ver los resultados entre dos equipos dados.\n" +
                "Ingrese 3 si quiere volver al menu principal";

        return mensaje;
    }

    public static void agregarPartido(MapeoAMuchos partidos, AVL equipos, Escritura logger) {
        Scanner scanner = new Scanner(System.in);

        String muestraEquipos = "";
        Lista colEquipos = equipos.listar();
        int longitud = colEquipos.longitud();

        for (int i = 1; i <= longitud; i++) {
            muestraEquipos += colEquipos.recuperar(i) + ": " + i + "; ";
        }

        System.out.println(muestraEquipos);
        System.out.println("Ingrese el número del equipo 1");
        int eleccion1 = scanner.nextInt();
        scanner.nextLine();
        Equipo eq1 = (Equipo) colEquipos.recuperar(eleccion1);
        String nomEq1 = eq1.getNombre();

        System.out.println(muestraEquipos);
        System.out.println("Ingrese el número del equipo 2");
        int eleccion2 = scanner.nextInt();
        scanner.nextLine();

        if (eleccion2 != eleccion1) {
            Equipo eq2 = (Equipo) colEquipos.recuperar(eleccion2);
            String nomEq2 = eq2.getNombre();

            if (nomEq1.compareTo(nomEq2) > 0) {
                // Intercambio los equipos ya que se debe respetar el orden alfabetico
                String temp = nomEq1;
                nomEq1 = nomEq2;
                nomEq2 = temp;
            }

            System.out.println("Ingrese la instancia del partido");
            String ins = scanner.nextLine().toUpperCase();

            System.out.println("Ingrese la ciudad en la que se jugó el partido");
            String ciu = scanner.nextLine().toUpperCase();

            System.out.println("Ingrese el nombre del estadio");
            String estadio = scanner.nextLine().toUpperCase();

            System.out.println("Ingrese la cantidad de goles que marcó " + nomEq1);
            int golEq1 = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la cantidad de goles que marcó " + nomEq2);
            int golEq2 = scanner.nextInt();

            PartidoKey dominio = new PartidoKey(nomEq1, nomEq2);
            Partido partido = new Partido(ins, ciu, estadio, golEq1, golEq2);

            partidos.asociar(dominio, partido);

            System.out.println("Se agregó con exito el partido");
            logger.escribir("Se agregó el partido "+dominio.toString());

        } else {
            System.out.println("Partido inválido");
        }
    }

    public static void datosPais(AVL equipos, MapeoAMuchos partidos) {
        /*
         * Dado un país, mostrar puntos ganados, goles a favor y en contra y diferencia
         * de goles
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del pais que desea conocer sus datos");
        String nombre = scanner.nextLine().toUpperCase();

        Equipo equipo = new Equipo(nombre, "xx", 'X');
        equipo = (Equipo) equipos.obtenerIgual(equipo);

        if (equipo != null) {
            System.out.println(equipo.datos());
        } else {
            System.out.println("El equipo ingresado no es parte del fixture");
        }
    }

    public static void rangoAlfabetico(AVL equipos) {
        /*
         * Dadas dos cadenas (min y max) devolver todos los equipos cuyo nombre esté
         * alfabéticamente en el rango [min, max].
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cadena de menor orden alfabético");
        String min = scanner.nextLine();

        System.out.println("Ingrese la cadena de mayor orden alfabético");
        String max = scanner.nextLine();

        Equipo piso = new Equipo(min, "", 'X');
        Equipo techo = new Equipo(max, "", 'X');

        System.out.println(equipos.listarRango(piso, techo).toString());
    }

    public static void resultados(MapeoAMuchos partidos) {
        /*
         * Dados 2 equipos, si jugaron algún partido entre sí, mostrar los resultados.
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer equipo");
        String eq1 = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el segundo equipo");
        String eq2 = scanner.nextLine().toUpperCase();

        if (eq1.compareTo(eq2) > 0) {
            String aux = eq1;
            eq1 = eq2;
            eq2 = aux;
        }

        if (eq1.compareTo(eq2) == 0) {
            System.out.println();
        } else {
            PartidoKey dominio = new PartidoKey(eq1, eq2);

            if (partidos.pertenece(dominio)) {
                System.out.println(partidos.obtenerValor(dominio));
            } else {
                System.out.println("Estos equipos no jugaron un partido entre sí");
            }
        }
    }

    public static void menorEscala(GrafoEtiquetado ciudades) {
        /*
         * Obtener el camino que llegue de A a B pasando por la mínima cantidad de
         * ciudades
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad origen");
        String c1 = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el nombre de la ciudad destino");
        String c2 = scanner.nextLine().toUpperCase();

        Ciudad origen = new Ciudad(c1, false, false);
        Ciudad destino = new Ciudad(c2, false, false);

        System.out.println("El camino mas corto es " + ciudades.caminoMasCorto(origen, destino).toString());
    }

    public static void menorTiempo(GrafoEtiquetado ciudades) {
        /* Obtener el camino que llegue de A a B de menor tiempo */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad origen");
        String c1 = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el nombre de la ciudad destino");
        String c2 = scanner.nextLine().toUpperCase();

        Ciudad origen = new Ciudad(c1, false, false);
        Ciudad destino = new Ciudad(c2, false, false);

        System.out.println(ciudades.caminoMenorTiempo(origen, destino).toString());
    }

    public static void menorTiempoAlt(GrafoEtiquetado ciudades) {
        /*
         * El camino más corto en minutos de vuelo para llegar de A a B y que no pase
         * por una ciudad C dada
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad origen");
        String c1 = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el nombre de la ciudad destino");
        String c2 = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el nombre de la ciudad a evitar");
        String c3 = scanner.nextLine().toUpperCase();

        Ciudad origen = new Ciudad(c1, false, false);
        Ciudad destino = new Ciudad(c2, false, false);
        Ciudad evitar = new Ciudad(c3, false, false);

        System.out.println(ciudades.caminoRapidoAlt(origen, destino, evitar).toString());
    }
    
    public static void caminosCompleto(GrafoEtiquetado ciudades) {
        /*
         * Obtener todos los caminos posibles para llegar de A a B, mostrarlos y luego
         * filtrar y mostrar solo los que haya
         * posibilidad de conseguir alojamiento en la ciudad destino o en alguna ciudad
         * por la que tenga que pasar camino a ella
         */
        Scanner scanner = new Scanner(System.in);
        String caminosAlojamiento = "";
        System.out.println("Ingrese el nombre de la ciudad origen");
        String c1 = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el nombre de la ciudad destino");
        String c2 = scanner.nextLine().toUpperCase();

        Ciudad origen = new Ciudad(c1, false, false);
        Ciudad destino = new Ciudad(c2, false, false);

        Lista caminos = ciudades.caminosTotales(origen, destino);
        int longitudCam = caminos.longitud();

        System.out.println("Todos los caminos posibles desde " + c1 + " hasta " + c2 + ", son: ");

        for (int i = 1; i <= longitudCam; i++) {
            
            Lista camino = (Lista) caminos.recuperar(1);            
            int longActual = camino.longitud();

            String caminoActual = "";
            boolean tieneAlojamiento = false;

            for(int j = 1; j <= longActual; j ++){
                Ciudad ciudadActual = (Ciudad) camino.recuperar(1);
                System.out.print(ciudadActual.toString()+ " ");
                caminoActual += ciudadActual.toString()+ " ";
                if(ciudadActual.getDisponibilidad()){
                    tieneAlojamiento=true;
                }
                camino.eliminar(1);
            }
            
            System.out.println();

            if(tieneAlojamiento){
                caminosAlojamiento += caminoActual + "\n";
            }

            caminos.eliminar(1);
        }

        if(caminosAlojamiento==""){
            System.out.println("No hay caminos con alojamiento disponible");
        }
        else{
            System.out.println("\nLos caminos con alojamiento disponible son los siguientes: \n");
            System.out.println(caminosAlojamiento);
        }
        
    }

    public static void listaGoles(AVL equipos) {
        Lista listaEquipos = equipos.listar();
        AVL equiposPorGol = new AVL();

        int longitud = listaEquipos.longitud();

        for (int i = 1; i <= longitud; i++) {
            EquipoGoles equipo = new EquipoGoles((Equipo) listaEquipos.recuperar(1));
            listaEquipos.eliminar(1);
            equiposPorGol.insertar(equipo);
        }

        System.out.println("La lista de los equipos en orden por cantidad de goles a favor de mayor a menor es: "
                + equiposPorGol.toString());
        equiposPorGol.vaciar();
    }

}
