package Estructuras;

public class MapeoAMuchos {

    private int TAM = 20;
    private int cant = 0;
    private NodoHashMapeoM[] tabla = new NodoHashMapeoM[TAM];

    public MapeoAMuchos() {

    }

    private int hash(Object valorDominio) {
        // Implementa aquí tu propio algoritmo de hash
        // Este es un ejemplo simple que convierte el objeto a una cadena y calcula el
        // hash
        return Math.abs(valorDominio.toString().hashCode()) % TAM;
    }

    /*public boolean insertar(Object valorDominio, Object valorRango) {
        boolean encontrado = false;

        int pos = hash(valorDominio);

        NodoHashMapeoM aux = tabla[pos];

        while (!encontrado && aux != null) {
            encontrado = aux.getDominio().equals(valorDominio);
            aux = aux.getEnlace();
        }

        if (!encontrado) {
            
        }

        return !encontrado;
    }*/

    public boolean asociar(Object valorDominio, Object valorRango) {

        int pos = hash(valorDominio);

        NodoHashMapeoM aux = tabla[pos];
        boolean encontrado = false;

        while (aux != null && !encontrado) {
            encontrado = aux.getDominio().equals(valorDominio);
            
            if(!encontrado){
                aux = aux.getEnlace();
            }
        }

        if (encontrado) {
            Lista listaRango = aux.getRango();
            listaRango.insertar(listaRango.longitud() + 1, valorRango);
        }
        else{
            tabla[pos] = new NodoHashMapeoM(valorDominio, tabla[pos]);
            Lista rango = tabla[pos].getRango();
            rango.insertar(rango.longitud() + 1, valorRango); // sacar afuera
            cant++;
        }

        return true;
    }

    public boolean desasociar(Object valorDominio, Object valorRango) {
        boolean exito = false;

        int pos = hash(valorDominio);

        NodoHashMapeoM aux = tabla[pos];
        NodoHashMapeoM anterior = null;

        if (aux != null) {
            // La tabla tiene uno o más elementos en la posicion pos
            while (aux.getEnlace() != null && aux.getDominio().equals(valorDominio)) {
                anterior = aux;
                aux = aux.getEnlace();
            }
            if (aux != null) {
                // Encontró el dominio
                Lista rango = aux.getRango();
                exito = rango.eliminarAparicion(valorRango);
                // Elimina el valor en la lista si lo encuentra
                if(rango.esVacia()){
                    if (anterior == null) {
                        tabla[pos] = tabla[pos].getEnlace();
                    } else {
                        anterior.setEnlace(aux.getEnlace());
                    }
                    cant--;
                    exito = true;
                }
            }
        }
        
        return exito;
    }

    public Lista obtenerValor(Object valorDominio) {
        Lista rango = new Lista();

        int pos = hash(valorDominio);

        NodoHashMapeoM aux = tabla[pos];

        while (aux != null && !aux.getDominio().equals(valorDominio)) {
            aux = aux.getEnlace();
        }
        if (aux != null) {
            rango.pasarElementos(rango, aux.getRango());
        }

        return rango;
    }

    public Lista obtenerConjuntoDominio() {
        Lista dominio = new Lista();

        if (cant > 0) {
            for (int i = 0; i < TAM; i++) {

                if (tabla[i] != null) {
                    dominio.insertar(dominio.longitud() + 1, tabla[i].getDominio());

                    if (tabla[i].getEnlace() != null) {
                        NodoHashMapeoM aux = tabla[i].getEnlace();

                        while (aux != null) {
                            dominio.insertar(dominio.longitud() + 1, aux.getDominio());
                            aux = aux.getEnlace();
                        }
                    }
                }
            }
        }

        return dominio;
    }

    public Lista obtenerConjuntoRango() {
        Lista rango = new Lista();

        for (int i = 0; i < TAM; i++) {
            NodoHashMapeoM actual = tabla[i];

            if (tabla[i] != null) {
                rango.pasarElementos(rango, actual.getRango());
                NodoHashMapeoM aux = actual.getEnlace();

                while (aux != null) {
                    rango.pasarElementos(rango, aux.getRango());
                    aux = aux.getEnlace();
                }
            }
        }

        return rango;
    }

    public boolean pertenece(Object valorDominio) {
        boolean exito = false;

        int pos = hash(valorDominio);
        NodoHashMapeoM recorre = tabla[pos];

        while (recorre != null && !recorre.getDominio().equals(valorDominio)) {
            recorre = recorre.getEnlace();
        }

        if (recorre != null) {
            exito = true;
        }

        return exito;
    }

    public boolean esVacia() {
        return cant == 0;
    }

    public void vaciar() {
        tabla = null;
        cant = 0;
    }

    public MapeoAMuchos clone() {
        MapeoAMuchos clon = new MapeoAMuchos();
        clon.TAM = TAM;
        clon.tabla = new NodoHashMapeoM[TAM];

        for (int i = 0; i < TAM; i++) {
            if (tabla[i] != null) {
                clon.tabla[i] = new NodoHashMapeoM(tabla[i].getDominio(), null);
                Lista rangoClon = new Lista();
                rangoClon.pasarElementos(rangoClon, tabla[i].getRango());
                clon.tabla[i].setRango(rangoClon);

                NodoHashMapeoM aux = tabla[i].getEnlace();
                NodoHashMapeoM auxClon = clon.tabla[i];

                while (aux != null) {
                    NodoHashMapeoM nuevoNodo = new NodoHashMapeoM(aux.getDominio(), null);
                    rangoClon = new Lista();
                    rangoClon.pasarElementos(rangoClon, aux.getRango());
                    nuevoNodo.setRango(rangoClon);
                    auxClon.setEnlace(nuevoNodo);

                    auxClon = auxClon.getEnlace();
                    aux = aux.getEnlace();
                }

                clon.cant++;
            }
        }

        return clon;
    }

    public String toString() {
        String msg = "";
        int longitudTanbla = tabla.length;

        for (int i = 0; i < longitudTanbla; i++) {
            NodoHashMapeoM nodo = tabla[i];
            while (nodo != null) {
                msg += nodo.getDominio().toString() + " --> ";
                Lista rango = nodo.getRango();
                for (int j = 1; j <= rango.longitud(); j++) {
                    Object elem = rango.recuperar(j);
                    if (elem != null) {
                        msg += " Partido " + j + " --> " + elem.toString();
                        if (j < rango.longitud()) {
                            msg += " --> ";
                        }
                    } else {
                        msg += "null";
                    }
                }
                msg += "\n";
                nodo = nodo.getEnlace();
            }
        }

        return msg;
    }

}
