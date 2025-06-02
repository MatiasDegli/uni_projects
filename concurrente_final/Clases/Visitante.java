import java.util.concurrent.atomic.AtomicInteger;

public class Visitante implements Runnable {
    private int id;
    private String nombre;
    private Comedor comedor;
    private AreaJuegos juegos;
    private int puntos;
    private ControlTren tren;
    private Parque parque;
    private RealidadVirtual virtual;
    private Reloj reloj;

    public Visitante(int idVisitante, Parque par, Comedor com, AreaJuegos area, ControlTren tr, RealidadVirtual virt,
            Reloj re) {
        this.id = idVisitante;
        parque = par;
        this.comedor = com;
        this.juegos = area;
        this.puntos = 0;
        tren = tr;
        virtual = virt;
        nombre = "Visitante " + id;
        reloj = re;
    }

    private void comiendo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPuntos() {
        return puntos;
    }

    public void run() {
        int num;

        try {
            AtomicInteger hora = new AtomicInteger(19);
            parque.ingresarParque(id);
            
            while (reloj.verHora().get() <= hora.get()) {
                
                puntos=juegos.jugar(id);
                // Recibir premio basado en los puntos
                juegos.recibirPremio(puntos, id);
                
                
                comedor.llegaVisitante(id);

                num = comedor.buscaMesa(id);

                if (num >= 0) {
                    this.comiendo();
                    comedor.dejaMesa(num, id);
                }

                comedor.saleVisitante(id);
                
                tren.abordarTren(nombre);

                virtual.recibirEquipoCompleto(nombre);

                virtual.devolverEquipo(nombre);
            }

            

        } catch (Exception e) {
        }

        finally{
            parque.saleParque(id);
        }
    }
}