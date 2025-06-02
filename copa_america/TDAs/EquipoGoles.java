package TDAs;

public class EquipoGoles implements Comparable{  

    private String nombre;
    private String DT;
    private char grupo;
    private int puntos = 0;
    private int golesAFavor = 0;
    private int golesEnContra = 0;

    public EquipoGoles(Equipo equipo){
        nombre=equipo.getNombre();
        //DT=equipo.getDT();
        //grupo=equipo.getGrupo();
        //puntos=equipo.getPuntos();
        golesAFavor=equipo.getGolesAFavor();
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
        int golesOtro = ((EquipoGoles) otro).getGolesAFavor();
        return Integer.compare(this.golesAFavor, golesOtro);
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguales = false;
        EquipoGoles otro = (EquipoGoles) obj;
        if(obj!=null){
            if(golesAFavor == otro.golesAFavor){
                iguales=true;
            }
        }
        return iguales;
    }
}
