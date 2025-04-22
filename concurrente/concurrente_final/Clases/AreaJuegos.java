
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class AreaJuegos {
    private final Exchanger<String> ficha;
    private final Semaphore semEntrada;

    public AreaJuegos() {
        ficha = new Exchanger<String>();
        semEntrada = new Semaphore(0);// asegura que un visitante notifique a un encargado para cambiar fichas
    }

    public int jugar(int id) throws InterruptedException {
        ficha.exchange("Visitante "+ id + " cambia una ficha");
        int puntos = (int) (Math.random() * 10) * 1000;
        Thread.sleep(puntos); // simula tiempo de juego
        semEntrada.release(); // notifica al empleado para poder recibir una ficha
        return puntos;
    }

    public void darFicha() throws InterruptedException {
        // metodo ejecutado por los encargados del area
        semEntrada.acquire();
        String pantalla = ficha.exchange("Soy el encargado. Recibi las fichas.");
        System.out.println(pantalla);
    }
    public void recibirPremio(int puntos, int id) throws InterruptedException {
        // Determinar premio basado en los puntos
        String premio;
        if (puntos > 80) {
            premio = "Gran premio";
        } else if (puntos > 50) {
            premio = "Premio medio";
        } else {
            premio = "Premio pequeño";
        }
        // Intercambiar premio con el visitante
        System.out.println("El visitante " + id + " recibio el premio: " + premio);
    }
}