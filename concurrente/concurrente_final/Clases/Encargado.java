public class Encargado extends Thread {
    private AreaJuegos juegos;

    public Encargado(AreaJuegos j) {
        juegos = j;
    }

    public void run() {
        while (true) {
            try {
                juegos.darFicha();
            } catch (Exception e) {

            }
        }
    }
}
