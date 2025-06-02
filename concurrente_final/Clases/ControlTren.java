import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ControlTren {

    private static final int CAPACIDAD_TREN = 10;
    private static final long TIEMPO_ESPERA = 5; // en minutos
    private final BlockingQueue<String> cola = new LinkedBlockingQueue<>(CAPACIDAD_TREN);
    private final BlockingQueue<Integer> tren = new ArrayBlockingQueue<>(1);
    private final Semaphore sem = new Semaphore(0);

    public synchronized void abordarTren(String visitante) throws InterruptedException {
        cola.put(visitante);
        System.out.println(visitante + " espera al tren. Personas en la cola: " + cola.size());
        // System.out.println("TiempoInicio: "+tiempoInicio);
        //Craneo: Pensamos en que largara cuando al menos una persona se suba
        if (cola.size() == 1) {
            sem.release();
        }

        else if (cola.size() == 10) {
            //Larga la senal para que el tren largue si se lleno la cola
            tren.put(1);
        }
    }

    public void partirTren() throws InterruptedException {
        sem.acquire();

        System.out.println("El tren comienza su contador");

        tren.poll(TIEMPO_ESPERA, TimeUnit.SECONDS); // Controla tiempo o cantVisitantes

        System.out.println("El tren parte con " + cola.size() + " visitantes: " + cola);
        cola.clear(); // Vacía la cola del tren, es decir, resetea
    }
}