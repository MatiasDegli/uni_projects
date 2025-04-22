import java.util.concurrent.atomic.AtomicInteger;

public class Principal {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Visitante visitante[] = new Visitante[11];
        Thread hiloVisitante[] = new Thread[11];
        Parque parque= new Parque();
        Comedor comedor = new Comedor(5);
        AreaJuegos areaJuegos = new AreaJuegos();
        ControlTren controlTren = new ControlTren();
        Tren tren = new Tren(controlTren);
        Thread hiloTren = new Thread(tren);
        hiloTren.start();
        AtomicInteger hora = new AtomicInteger(8);
        Reloj rel= new Reloj(hora, parque);
        Thread hiloReloj= new Thread(rel);
        hiloReloj.start();
        RealidadVirtual virtual = new RealidadVirtual(20, 10, 8);
        Encargado encargado = new Encargado(areaJuegos);
        Thread hiloEncargado = new Thread(encargado);
        hiloEncargado.start();

        for (int i = 0; i < hiloVisitante.length; i++) {
            visitante[i] = new Visitante(i + 1,parque, comedor, areaJuegos, controlTren,virtual,rel);
            hiloVisitante[i] = new Thread(visitante[i]);
            hiloVisitante[i].start();
        }
    }
}