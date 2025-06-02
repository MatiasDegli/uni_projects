package TDAs;

public class Partido {
    
    private String instancia;
    private String ciudad;
    private String estadio; 
    private int golesEq1;
    private int golesEq2;

    public Partido(String ins, String ciu, String est, int gol1, int gol2){
        instancia=ins;
        ciudad=ciu;
        estadio=est;
        golesEq1=gol1;
        golesEq2=gol2;
    }

    public String toString(){
        return "Instancia: "+instancia+" --> Resultado: "+golesEq1+ " - "+golesEq2;
    }
}
