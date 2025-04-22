package TDAs;

public class Equipo implements Comparable{
    
    private String nombre;
    private String DT;
    private char grupo;
    private int puntos = 0;
    private int golesAFavor = 0;
    private int golesEnContra = 0;

    public Equipo(String nom, String dir, char gru){
        nombre=nom;
        DT=dir;
        grupo=gru;
    }

    public String getNombre(){
        return nombre;
    }   

    public String getDT(){
        return DT;
    }

    public char getGrupo(){
        return grupo;
    }

    public int getPuntos(){
        return puntos;
    }

    public int getGolesAFavor(){
        return golesAFavor;
    }

    public void setDT(String dir){
        DT=dir;
    }

    public void setGrupo(char gru){
        grupo=gru;
    }
    
    public void sumarPuntos(int p){
        puntos+=p;
    }

    public void sumarGoles(int g){
        golesAFavor+=g;
    }

    public void sumarEnContra(int g){
        golesEnContra+=g;
    }

    public int diferenciaG(){
        return golesAFavor-golesEnContra;
    }

    public String datos(){
        String cadena = "La selección de " + nombre + " sumó un total de "+puntos+" puntos en la fase de grupos."
        +" Hizo un total de "+golesAFavor+" goles a favor, recibió "+golesEnContra+" goles en contra, su diferencia "
        +"de goles es "+diferenciaG();
        
        return cadena;
    }

    public String toString(){
        return nombre;
    }

    @Override
    public int compareTo(Object otro) {
        return nombre.compareTo(((Equipo) otro).getNombre());
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguales = false;
        Equipo otro = (Equipo) obj;
        if(obj!=null){
            if(nombre.equals(otro.nombre)){
                iguales=true;
            }
        }
        return iguales;
    }
}
