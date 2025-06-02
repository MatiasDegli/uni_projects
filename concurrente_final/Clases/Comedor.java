import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Comedor {

    private CyclicBarrier[] mesas;
    private CyclicBarrier[] salidaMesa;
    private boolean[] mesaLlena;
    private int[] sentados;
    private int cantMesas;
    private int capacidad;
    private int visitantesDentro = 0;

    public Comedor(int cant) {
        cantMesas = cant;
        capacidad = cantMesas * 4;
        mesas = new CyclicBarrier[cantMesas];
        salidaMesa = new CyclicBarrier[cantMesas];
        mesaLlena = new boolean[cantMesas];
        sentados = new int[cantMesas];

        for (int i = 0; i < cantMesas; i++) {
            mesas[i] = new CyclicBarrier(4, () -> System.out.println("Empiezan a comer en mesa"));
            salidaMesa[i] = new CyclicBarrier(4);
            mesaLlena[i] = false;
        }

    }
    
    public synchronized void llegaVisitante(int id) throws InterruptedException, BrokenBarrierException {

        if (visitantesDentro == capacidad) {
            this.wait();
        }
        visitantesDentro++;

        System.out.println("Entra al comedor visitante " + id);

    }

    public int buscaMesa(int id) throws InterruptedException, BrokenBarrierException, TimeoutException {

        int mesaAsignada;
        //Protegemos la seccion critica
        synchronized (this) {

            mesaAsignada = eleccionMesa(id);

            // Encontro mesa con espacio
            System.out.println("Visitante " + id + " se sienta en mesa" + mesaAsignada);

            sentados[mesaAsignada]++;

            if (sentados[mesaAsignada] == 4) {
                mesaLlena[mesaAsignada] = true;
            }
        }

        try {
            //Si no se sentaron los 4, larga despues de 5 minutos
            mesas[mesaAsignada].await(5, TimeUnit.SECONDS);

            if (sentados[mesaAsignada] == 4) {
                System.out.println("Visitante " + id + " come en mesa" + mesaAsignada);
            } else {
                mesaAsignada = -1;
            }
        } catch (java.util.concurrent.TimeoutException e) {
            System.out.println("Los visitantes se cansaron de esperar");
        } catch (Exception e) {

        }

        return mesaAsignada;
    }

    public int eleccionMesa(int id) {
        int i = 0;
        int mesaAsignada = -1;
        int candidata = -1;

        // Buscaremos una mesa libre. Mientras que la mesa asignada sea -1
        //es decir, que el while corre mientras que no tenga mesa asignada.
        while (mesaAsignada == -1) {
            if (!mesaLlena[i]) {
                // Si la mesa en i esta libre
                if (candidata == -1) {
                    //Y todavia no tiene mesa asignada, entonces a la candidata le asignamos i.
                    candidata = i;
                } else if (candidata != -1 && mesas[i].getNumberWaiting() > mesas[candidata].getNumberWaiting()) {
                    // Si hay una mesa con mas visitantes, la elige como candidata
                    //es decir, que da prioridad a la mesa que mas gente esta sentada
                    //ya que es mas probable que se llene y puedan comer.
                    candidata = i;
                }
            }

            // Sigue buscando
            i++;

            if (i == cantMesas) {
                // Chequeo todas las mesas

                // Habia al menos una con lugar

                mesaAsignada = candidata; // Elije la mesa mas ocupada

                i = 0;

            }
        }

        return mesaAsignada;
    }

    public void dejaMesa(int mesa, int id) throws InterruptedException, BrokenBarrierException, TimeoutException {

        synchronized (this) {
            sentados[mesa]--;
        }
        
        salidaMesa[mesa].await(5, TimeUnit.SECONDS);
        mesaLlena[mesa] = false;

    }

    public synchronized void saleVisitante(int id) {

        System.out.println("Sale del comedor visitante " + id);

        visitantesDentro--;

        this.notify();
    }

}