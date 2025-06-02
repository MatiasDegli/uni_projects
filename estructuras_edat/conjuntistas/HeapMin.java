/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas;

/**
 *
 * @author matia
 */
public class HeapMin {
    
    private Comparable[] heap;
    private int ultimo;
    private int TAMANIO = 20;
    
    
    public HeapMin(){
        heap = new Comparable[TAMANIO];
        ultimo = 0; //la pos 0 nunca es utilizada
    }
    
    
    public boolean insertar(Comparable newElem){
        boolean exito = true;
        
        if(ultimo<TAMANIO){
            ultimo++;
            heap[ultimo] = newElem;

            int i = ultimo/2;

            while(i>0){
                hacerBajar(i);
                i=i/2;
            }
        }
        else{
            //heap lleno
            exito=false;
        }
        
        return exito;
    }
    
    
    private void hacerBajar(int posPadre){
        Comparable temp = heap[posPadre];
        boolean salir = false;
        int posH = posPadre*2;
        
        while(!salir){
            if(posH<=ultimo){
            //temp tiene hijo izq y es menor 
                if(posH<ultimo){
                    //temp tiene hijo der
                    if(heap[posH+1].compareTo(heap[posH])<0){
                        //hijo der es menor que hijo izq
                        posH++;
                    }
                }
                //compara al hijo menor con el padre
                if(heap[posH].compareTo(temp)<0){
                    //hijo es menor que padre
                    heap[posPadre]=heap[posH];
                    heap[posH]=temp;
                    posPadre=posH;
                }
                else{
                    //el padre es menor que sus hijos
                    salir=true;
                }
            }
            else{
                //el temp es hoja 
                salir=true;
            }
        }  
    }
    
    
    public boolean eliminarCima(){
        boolean exito=true;
        
        if(esVacio() == true){
            exito=false;
        }
        else{
            heap[1]=heap[ultimo];
            ultimo--;
            
            hacerBajar(1);
        }
        
        return exito;
    }
    
    
    public Object recuperarCima(){
        Object cima=null;
        
        if(!esVacio()){
            cima=heap[1];
        }
        
        return cima;
    }
    
    
    public boolean esVacio(){
        return ultimo==0;
    }
    
    
    public String toString(){
        String msj="";
        
        for (int i = 1; i <= ultimo; i++) {
            if(i<=ultimo/2){
                
                if(heap[i*2+1]!=null){
                    msj+=heap[i].toString()+" es padre de "+heap[i*2]+ " y de "+heap[i*2+1]+"\n";
                }
                else{
                    msj+=heap[i].toString()+" es padre de "+heap[i*2]+"\n";
                }
            }
            else{
                msj+=heap[i].toString()+" no tiene hijos\n";
            }
        }
        
        return msj;
    }
    
}
