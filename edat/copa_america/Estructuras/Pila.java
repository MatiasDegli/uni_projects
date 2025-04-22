package Estructuras;

public class Pila {


    private Nodo tope;


    //Constructor
    public Pila(){
        tope=null;
    }


    //Modulos
    public boolean apilar(Object elem){
        //actualiza el tope
        tope = new Nodo(elem, tope);
        
        //no puede haber error de pila llena
        return true;
    }


    public boolean desapilar(){
        boolean exito;

        if(tope==null){
            exito=false;
        }
        else{
            tope = tope.getEnlace();
            exito=true;
        }
        
        return exito;
    }


    public Object obtenerTope(){
        Object elem;

        if (tope==null){
            elem=null;
        }
        else{
            elem = tope.getElem();
        }

        return elem;
    }


    public boolean esVacia(){
        return tope==null;
    }


    public void vaciar(){
        tope = null;
    }


    public Pila clone(){
        Pila clon = new Pila();
        Nodo recorreP = tope , recorreC;
        
        if(tope!=null){
            clon.tope = new Nodo (recorreP.getElem(), null);
            recorreC=clon.tope;
            recorreP=recorreP.getEnlace();

            while (recorreP!=null){
                Nodo c = new Nodo (recorreP.getElem(), null);
                recorreC.setEnlace(c);
                recorreC=recorreC.getEnlace();
                recorreP=recorreP.getEnlace();
            }
            
        }

        return clon;
    }
    

    public boolean esCapicua() {
        boolean esPalindromo = true;
        Pila aux = new Pila();
        Nodo recorre = tope;

        // Llenar la pila auxiliar con los elementos de la pila original
        while (recorre != null) {
            aux.apilar(recorre.getElem());
            recorre = recorre.getEnlace();
        }

        // Comparar los elementos de ambas pilas
        recorre = tope;
        while (esPalindromo && recorre != null && aux.obtenerTope() != null) {
            if (!aux.obtenerTope().equals(recorre.getElem())) {
                esPalindromo = false;
            }
            aux.desapilar();
            recorre = recorre.getEnlace();
        }

        return esPalindromo; // Retorna el resultado de la comparación
    }


    public String toString(){
        String s="";
        String msj="";

        if(this.tope == null){
            msj="Pila vacia";
        }
        else{
            Nodo aux=this.tope;
            s+="]";
            while (aux != null){
                s+=aux.getElem().toString();
                aux=(aux.getEnlace());
                if(aux!=null){
                    s+=", ";
                }
            }
            s+="[";
            for (int i = s.length()-1; i >= 0; i--) {
                msj+=s.charAt(i);
            }
        }

        return msj;
    }

}