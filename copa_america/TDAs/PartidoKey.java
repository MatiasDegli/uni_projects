package TDAs;

import java.util.Objects;

public class PartidoKey {
    
    String eq1, eq2;
    
    public PartidoKey(String e1, String e2){
        eq1=e1;
        eq2=e2;
    }

    public String toString(){
        return eq1+" - "+eq2;
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguales = false;
        PartidoKey otro = (PartidoKey) obj;
        if(obj!=null){
            if(eq1.equals(otro.eq1) && eq2.equals(otro.eq2)){
                iguales=true;
            }
        }
        return iguales;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eq1, eq2);
    }
}
