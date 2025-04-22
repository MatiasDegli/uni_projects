class Tren implements Runnable {
    private ControlTren control;

    public Tren(ControlTren c) {
        control = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Lista para almacenar los pasajeros que abordarán
                System.out.println("Tren esperando visitantes...");

                control.partirTren();

                // Simular recorrido del tren
                Thread.sleep(3000); // Tiempo que tarda el tren en hacer el recorrido

                System.out.println("Tren regresó y está listo para más pasajeros.");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Tren interrumpido.");
            }
        }
    }
}