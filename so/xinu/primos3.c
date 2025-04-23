#include <xinu.h>

/* Prototipos */
int esPrimo(int n);
int siguientePrimo(int primo);
void procesoHijo(void);

/*----------------------------------------------------------
 * Función principal (Proceso padre - Prioridad alta)
 *----------------------------------------------------------*/
process main(void) {
    pid32 pidHijo;
    int min = 1;
    int max = 5000;
    
    // Crear proceso hijo con prioridad MÁS BAJA (número mayor)
    pidHijo = create(procesoHijo, 4096, 30, "hijo", 0); // Prioridad 30
    
    if(pidHijo == SYSERR) {
        kprintf("Error al crear proceso hijo\n");
        return 1;
    }
    
    // Ajustar prioridad del padre a 20 (más alta que el hijo)
    chprio(getpid(), 20);  // Prioridad 20 (más alta = número menor)
    
    resume(pidHijo);
    
    kprintf("Padre (prio 20) - Primos %d-%d:\n", min, max);
    
    int primo = min;
    if(!esPrimo(primo)) primo = siguientePrimo(primo);
    
    while(primo <= max) {
        kprintf("PADRE: %d\n", primo);
        primo = siguientePrimo(primo);
    }
    
    kill(pidHijo);
    return OK;
}

/*----------------------------------------------------------
 * Proceso hijo (Prioridad baja)
 *----------------------------------------------------------*/
void procesoHijo(void) {
    int min = 5000;
    int max = 10000;
    
    kprintf("Hijo (prio 30) - Primos %d-%d:\n", min, max);
    
    int primo = min;
    if(!esPrimo(primo)) primo = siguientePrimo(primo);
    
    while(primo <= max) {
        kprintf("HIJO: %d\n", primo);
        primo = siguientePrimo(primo);
    }
}

/* (Las funciones esPrimo() y siguientePrimo() se mantienen igual) */

