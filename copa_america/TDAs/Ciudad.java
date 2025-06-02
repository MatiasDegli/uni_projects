package TDAs;

import java.util.Objects;

public class Ciudad implements Comparable {

    private String nombre;
    private boolean disponibilidad;
    private boolean esSede;

    public Ciudad(String nom, boolean dis, boolean sede) {
        nombre = nom;
        disponibilidad = dis;
        esSede = sede;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getDisponibilidad(){
        return disponibilidad;
    }

    public void setDisponibilidad(boolean dis) {
        disponibilidad = dis;
    }

    public void setSede(boolean sede) {
        esSede = sede;
    }

    public String toString(){
        return nombre;
    }

    @Override
    public int compareTo(Object otra) {
        return nombre.compareTo(((Ciudad) otra).getNombre());
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguales = false;
        Ciudad otro = (Ciudad) obj;
        if(obj!=null){
            if(nombre.equals(otro.nombre)){
                iguales=true;
            }
        }
        return iguales;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}
