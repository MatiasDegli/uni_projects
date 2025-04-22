public class RealidadVirtual {
    private int cantVisor;
    private int cantManopla;
    private int cantBase;

    public RealidadVirtual(int visoresRealidadVirutal, int manopla, int base) {
        cantVisor = visoresRealidadVirutal;
        cantManopla = manopla;
        cantBase = base;
    }

    public synchronized void recibirEquipoCompleto(String visitante) throws InterruptedException {

        while (cantVisor < 1 || cantManopla < 2 || cantBase < 1) {
            wait();
        }

        cantVisor--;
        cantManopla -= 2;
        cantBase--;
        System.out.println(visitante + " obtiene equipoCompleto");
    }

    public synchronized void devolverEquipo(String visitante) {
        cantVisor++;
        cantManopla += 2;
        cantBase++;
        System.out.println(visitante + " devuelve equipoCompleto");
        notify();
    }
}