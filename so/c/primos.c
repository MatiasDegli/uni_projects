#include <stdio.h> // Funciones de entrada/salida estándar
#include <stdlib.h> // Funciones generales de la biblioteca estándar
#include <unistd.h> // Acceso a la API de sistemas POSIX (sistemas Unix/Linux), ej. fork()
#include <signal.h> // Manejo de señales entre procesos, ej. kill()
#include <stdbool.h>  // para usar bool, true, false

// Prototipos
bool esPrimo(int n);
int siguientePrimo(int primo);
void metodoHijo();

int main() {
    int pidHijo = fork();

    if (pidHijo == 0) {      // Código del hijo
        metodoHijo();
        exit(0);
    } 
    else if (pidHijo > 0) {  // Código del padre
        int primo = 2;

        printf("%d es primo (Padre)\n", primo);

        while (primo < 1000) {
            primo = siguientePrimo(primo);
            printf("%d es primo (Padre)\n", primo);
        }

        kill(pidHijo, SIGKILL); // Finaliza al hijo sin esperar
        printf("Hijo eliminado. Padre terminado.\n");
        exit(0);
    } 
    else {
        perror("Error en fork()");
        exit(1);
    }
}

// Función del hijo (primos desde 1009 hasta 5000)
void metodoHijo() {
    int primo = 1009;

    printf("%d es primo (Hijo)\n", primo);

    while (primo < 5000) {
        primo = siguientePrimo(primo);
        printf("%d es primo (Hijo)\n", primo);
    }
}

// Encuentra el siguiente primo después de "primo"
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

bool esPrimo(int n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;

    for (int i = 3; i * i <= n; i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}