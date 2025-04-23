#include <xinu.h>   // Reemplaza todos los headers estándar

/* Prototipos de funciones (ajustados para XINU) */
int esPrimo(int n);
int siguientePrimo(int primo);
void procesoHijo(void);

/*----------------------------------------------------------
 * Función principal (Proceso padre)
 *----------------------------------------------------------*/
process main(void) {
    pid32 pidHijo;
    int min = 1;
    int max = 5000;
    
    // Crear proceso hijo (prioridad 20, stack de 4096 bytes)
    pidHijo = create(procesoHijo, 4096, 20, "hijo", 0);
    
    if(pidHijo == SYSERR) {
        kprintf("Error al crear proceso hijo\n");
        return 1;
    }
    
    // Iniciar ejecución del hijo
    resume(pidHijo);
    
    kprintf("Proceso padre mostrando primos de %d a %d:\n", min, max);
    
    int primo = min;
    if(!esPrimo(primo)) {
        primo = siguientePrimo(primo);
    }
    
    while(primo <= max) {
        kprintf("%d es primo\n", primo);
        primo = siguientePrimo(primo);
    }
    
    // Terminar al hijo al finalizar
    kill(pidHijo);
    return OK;
}

/*----------------------------------------------------------
 * Función del proceso hijo
 *----------------------------------------------------------*/
void procesoHijo(void) {
    int min = 5000;
    int max = 10000;
    
    kprintf("Proceso hijo mostrando primos de %d a %d:\n", min, max);
    
    int primo = min;
    if(!esPrimo(primo)) {
        primo = siguientePrimo(primo);
    }
    
    while(primo <= max) {
        kprintf("%d es primo\n", primo);
        primo = siguientePrimo(primo);
    }
}

/*----------------------------------------------------------
 * Función de verificación de primos (adaptada)
 *----------------------------------------------------------*/
int esPrimo(int n) {
    if(n <= 1) return 0;
    if(n == 2) return 1;
    if(n % 2 == 0) return 0;

    for(int i = 3; i * i <= n; i += 2) {
        if(n % i == 0) return 0;
    }
    return 1;
}

/*----------------------------------------------------------
 * Encuentra el siguiente primo (misma lógica)
 *----------------------------------------------------------*/
int siguientePrimo(int primo) {
    if(primo > 2) {
        primo += 2;
        while(!esPrimo(primo)) {
            primo += 2;
        }
    }
    else if(primo < 2) {
        return 2;
    }
    else {
        return 3;
    }
    return primo;
}
