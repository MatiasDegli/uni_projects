#include <xinu.h>       // Incluye todas las funciones específicas de XINU

/* Prototipos de funciones */
int esPrimo(int n);
int siguientePrimo(int primo);
void metodoHijo();

/*----------------------------------------------------------
 * Función principal (equivalente al proceso padre)
 *----------------------------------------------------------*/
process main(void) {
    pid32 pidHijo;

    // Crear proceso hijo (prioridad 20, nombre "hijo", sin argumentos)
    pidHijo = create(metodoHijo, 4096, 20, "hijo", 0);

    if (pidHijo == SYSERR) {
        kprintf("Error al crear proceso hijo\n");
        return 1;
    }

    // Iniciar ejecución del hijo
    resume(pidHijo);

    // Código del padre
    int primo = 2;

    kprintf("%d es primo (Padre)\n", primo);

    while (primo < 1000) {
        primo = siguientePrimo(primo);
        kprintf("%d es primo (Padre)\n", primo);
    }

    // Terminar al hijo usando kill() de XINU
    kill(pidHijo);
    kprintf("Hijo eliminado. Padre terminado.\n");

    return OK;
}

/*----------------------------------------------------------
 * Función del hijo (primos desde 1009 hasta 5000)
 *----------------------------------------------------------*/
void metodoHijo() {
    int primo = 1009;

    kprintf("%d es primo (Hijo)\n", primo);

    while (primo < 5000) {
        primo = siguientePrimo(primo);
        kprintf("%d es primo (Hijo)\n", primo);
    }
}

/*----------------------------------------------------------
 * Encuentra el siguiente primo después de "primo"
 *----------------------------------------------------------*/
int siguientePrimo(int primo) {
    if (primo != 2) {
        primo += 2;
        while (!esPrimo(primo)) {
            primo += 2;
        }
    } else {
        return 3;
    }
    return primo;
}

/*----------------------------------------------------------
 * Función de verificación de primos (adaptada para XINU)
 *----------------------------------------------------------*/
int esPrimo(int n) {
    if (n <= 1) return 0;
    if (n == 2) return 1;
    if (n % 2 == 0) return 0;

    for (int i = 3; i * i <= n; i += 2) {
        if (n % i == 0) return 0;
    }
    return 1;
}
