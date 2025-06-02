
public class Parque {
    private boolean estaAbierto;
    private int cantVisitantes = 0;


    public Parque() {
    }

    // Metodos para Visitante ---------------------------------------------------
    /**
     * método sincroniza el ingreso de los visitantes al Parque y los hace
     * esperar hasta que el reloj notifique que el Parque abrió.
     */
    public synchronized void ingresarParque(int id) {
        // Se utiliza un lock implicito para el objeto this, esto para que
        // los visitantes no puedan ingresar al Parque mientras el reloj
        // no notifique que abrió.
        try {
            
            while (!estaAbierto) {
                System.out.println(
                        "[CLASE PARQUE].El Parque esta cerrado. Esperare a que se abra para poder ingresar");
                wait();
            }

            System.out.println("[CLASE PARQUE].Ingreso el visitante "+id);
            cantVisitantes++;
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("[CLASE PARQUE].Error en Parque.ingresarParque" + ex.getMessage());
        }
    }

    // Metodos para Reloj ------------------------------------------------------
    /**
     * Metodo sincronizado para que los visitantes ingresen al Parque y
     * esperen a que el reloj los notifique que el Parque abrio
     */
    public synchronized void comenzarHorarioAtencion() {
        // Se liberan los visitantes que estaban esperando a que el parque abriera
        System.out.println("[CLASE PARQUE].El parque se abrio, avisemos a todos los visitantes");
        estaAbierto = true;
        notifyAll();
    }

    /**
     * Método sincronizado que notifica a todos los Visitantes que el Parque
     * cerró y cambia el estado del Parque a cerrado.
     */
    public synchronized void terminarHorarioAtencion() {
        estaAbierto = false;
        System.out.println("[CLASE PARQUE] Termino horario de atencion.");
    }

    public synchronized void saleParque(int id){
        
        cantVisitantes--;
        
        if(cantVisitantes==0){
            System.out.println("Se fueron todos");
        }else{
            System.out.println("Sale visitante " +id+". Quedan "+cantVisitantes+" visitantes en el parque");
        }
    }
}