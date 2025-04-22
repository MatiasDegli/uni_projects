package Estructuras;

public class Lista {
    
    
    private Nodo cabecera;
    private int longitud;
    
    
    public Lista(){
        cabecera=null;
        longitud=0;
    }
    
    
    public boolean insertar(int pos, Object newElem){
        boolean exito;
        
        if(pos < 1 || pos > longitud + 1){
            exito=false;
        }
        else{
            exito=true;
            
            if(cabecera==null){
                cabecera = new Nodo(newElem, null);
            }
            else if(pos==1){
                Nodo nuevo = new Nodo(newElem, cabecera);
                cabecera=nuevo;
            }
            else{
                Nodo aux = cabecera;
                
                for (int i = 1; i < pos-1; i++){
                    aux=aux.getEnlace();
                }
                
                aux.setEnlace(new Nodo (newElem, aux.getEnlace()));
            }
            
            longitud++;
        }
        
        return exito;
    }
    
    
    public boolean eliminar(int pos){
        boolean exito;
        
        if (cabecera==null || pos < 1 || pos > longitud() + 1){
            //lista vacia: false, posiciones no validas: false
            exito = false;
        }
        else if(pos==1){
            cabecera=cabecera.getEnlace();
            longitud--;
            exito=true;
        }
        else{
            Nodo aux = cabecera;
                
            for (int i = 1; i < pos-1; i++){
                aux=aux.getEnlace();
            }
            
            aux.setEnlace(aux.getEnlace().getEnlace());
            longitud--;
            exito = true;
        }
        
        return exito;
    } 
    
    
    public Object recuperar(int pos){
        Object elem;
        
        if(cabecera==null || pos < 1 || pos > longitud() ){
            elem=null;
        }
        else{
            Nodo aux=cabecera;
            
            for (int i = 1; i < pos; i++) {
                aux=aux.getEnlace();
            }
            
            elem=aux.getElem();
        }
        
        return elem;
    }
    
    
    public int localizar(Object elem){
        int pos=1;
        
        if(cabecera==null){
            pos=-1;
        }
        else{
            Nodo aux=cabecera;
            
            while(pos < longitud && !aux.getElem().equals(elem)){
                aux=aux.getEnlace();
                pos++;
            }
            
            if(!aux.getElem().equals(elem)){
                pos=-1;
            }
        }
        
        return pos;
    }
    
    
    public int longitud(){
        return longitud;
    }
    
    
    public boolean esVacia(){
        return cabecera==null;
    }
    
    
    public void vaciar(){
        cabecera=null;
        longitud=0;
    }
    
    
    public Lista clone(){
        Lista clon = new Lista();
        Nodo aux = cabecera;                
        Nodo enlaza = new Nodo(aux.getElem(), null);
        clon.cabecera=enlaza;
        clon.longitud=1;
        aux=aux.getEnlace();
            
        while(aux!=null){
            Nodo nuevo = new Nodo(aux.getElem(), null);
            enlaza.setEnlace(nuevo);
            enlaza=enlaza.getEnlace();
            aux=aux.getEnlace();
            clon.longitud++;
        }
        
        return clon;
    }
    
    
    public Lista invertir(){
        Lista invertida = new Lista();
        
        Nodo recorre=cabecera;
        
        while(recorre!=null){
            invertida.insertar(1, recorre.getElem());            
            recorre=recorre.getEnlace();
        }
        
        return invertida;
    }
    
    
    public void pasarElementos(Lista aLlenar, Lista lis){
        
        Nodo recorre = lis.cabecera;
        
        for (int i = 0; i < lis.longitud; i++) {            
            aLlenar.insertar(aLlenar.longitud+1, recorre.getElem());
            recorre=recorre.getEnlace();
        }
        
    }
    
    
    public boolean eliminarAparicion(Object elem){
        Nodo recorre = cabecera;
        Nodo previo = null; // Mantenemos un puntero al nodo anterior        
        boolean eliminado=false;
        
        while (recorre != null && eliminado==false){
            
            if(recorre.getElem().equals(elem)){
                // Eliminamos el nodo actual
                if (previo == null) {
                    // Si es la cabecera, actualizamos la cabecera
                    cabecera = recorre.getEnlace();
                    longitud--;
                    eliminado=true;
                }
                else{
                    // Si no es la cabecera, enlazamos el nodo anterior al siguiente
                    previo.setEnlace(recorre.getEnlace());
                    longitud--;
                    eliminado=true;
                }
            } 
            else {
                // Avanzamos al siguiente nodo
                previo = recorre;
            }
            
            recorre = recorre.getEnlace();   
        }
        
        return eliminado;
    }
    
    
    public void eliminarApariciones(Object elem){
        Nodo recorre = cabecera;
        Nodo previo = null; // Mantenemos un puntero al nodo anterior
        
        while (recorre != null){
            
            if(recorre.getElem().equals(elem)){
                // Eliminamos el nodo actual
                if (previo == null) {
                    // Si es la cabecera, actualizamos la cabecera
                    cabecera = recorre.getEnlace();
                    longitud--;
                }
                else{
                    // Si no es la cabecera, enlazamos el nodo anterior al siguiente
                    previo.setEnlace(recorre.getEnlace());
                    longitud--;
                }
            } 
            else {
                // Avanzamos al siguiente nodo
                previo = recorre;
            }
            
            recorre = recorre.getEnlace();        
        }
    }
    
    
    public Lista obtenerMultiplos(int num){
	
	int i = 1, j = 1, n=num;	

	Lista lis = new Lista();
	
	Nodo recorre = cabecera; 
	
        Nodo aux = new Nodo(null, null);
        
	while(recorre!=null){
                
            if(i == n){

                if(lis.cabecera==null){
                    System.out.println("Entra, y recorre es: "+recorre.getElem());
                    lis.cabecera = new Nodo(recorre.getElem(), null);
                    aux = lis.cabecera; 
                }
                else{
                    aux.setEnlace(new Nodo(recorre.getElem(), null));
                    aux = aux.getEnlace();
                }

                j++;
                n=num*j;
                System.out.println("num: " +n);
            }
            
            i++;
            recorre=recorre.getEnlace();
	}
	
	return lis;
    }   
    
    
    public String toString(){
        String mensaje="";
        Nodo aux=cabecera;
        
        while(aux!=null){
            mensaje+=" " + aux.getElem().toString();
            aux=aux.getEnlace();
        }
        
        if("".equals(mensaje)){
            mensaje="Lista vacia";
        }
        
        return mensaje;
    }
    
}
