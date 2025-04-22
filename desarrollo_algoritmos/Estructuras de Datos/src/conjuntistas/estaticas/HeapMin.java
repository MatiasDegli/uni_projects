/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas.estaticas;

/**
 *
 * @author Zambon
 */
public class HeapMin {
    
    private Comparable[] heap;
    private int ultimo;
    private int TAMANIO=10;
    
    
    public HeapMin(){
        heap = new Comparable[TAMANIO];
        ultimo=0;
    }
    
    
    public boolean insertar(Comparable elem){
        boolean exito;
        
        if(ultimo==TAMANIO){
            exito=false;
        }
        else{
            heap[ultimo+1]=elem;
            ultimo++;
            hacerSubir(ultimo-1);
            exito=true;
        }
        
        return exito;
    }
    
    
    private void hacerSubir(int posPadre){
        int posH;
        Comparable temp=heap[posPadre];
        boolean salir=false;
        
        while(!salir){
            posH = posPadre*2;
            
            if(posH<this.ultimo){
                if(this.heap[posH+1].compareTo(this.heap[posH])<0){
                    posH++;
                }
            }
            if(heap[posH].compareTo(temp)<0){
                heap[posPadre]=heap[posH];
                heap[posH]=temp;
                posPadre=posPadre/2;
            }
            else salir=true;
        }    
    }
    
    
    public boolean eliminarCima(){
        boolean exito;
        
        if(ultimo==0){
            exito=false;
        }
        else{
            heap[1]=heap[ultimo];
            ultimo--;
            hacerBajar(1);
            exito=true;
        }
        
        return exito;
    }
    
    
    public Comparable recuperarCima(){
        Comparable cima;
        
        if(ultimo==0){
            cima=null;
        }
        else{
            cima=heap[1];
        }
        
        return cima;
    }
    
    
    private void hacerBajar(int posPadre){
        int posH;
        Comparable temp=this.heap[posPadre];
        boolean salir=false;
        
        while(!salir){
            posH = posPadre*2;
            if(posH<=this.ultimo){
                if(posH<this.ultimo){
                    if(this.heap[posH+1].compareTo(this.heap[posH])<0){
                        posH++;
                    }
                }
                if(heap[posH].compareTo(temp)<0){
                    heap[posPadre]=heap[posH];
                    heap[posH]=temp;
                    posPadre=posH;
                }
                else salir=true;
            }
            else salir=true;
        }
    }
    
}
