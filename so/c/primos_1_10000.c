/*
Desarrollar un programa que genere dos procesos para mostrar números primos. Un proceso 
debe mostrar los primos del 1 al 5000, y el segundo proceso del 5000 al 10000.  
*/

#include <stdio.h> // Funciones de entrada/salida estándar
#include <stdbool.h>  // para usar bool, true, false

int proceso_hijo();

int primo;

int main()
{
    int pid_hijo = fork();
    
    if(pid_hijo==0)
    {
        proceso_hijo();
    }

    primo = 1;

    // Cuento primos del 1 al 5000
}

int proceso_hijo()
{
    primo = 5000;
}

// Encuentra el siguiente primo después de "primo"
int siguientePrimo(int primo) {
    if (primo != 2) {
        primo += 2;
        while (!esPrimo(primo)) {
            primo += 2;
        }
    } else {
        primo = 3;
    }
    return primo;
}

bool esPrimo() {
    bool exito = true;
    if (primo <= 1) exito = false;
    else if (primo == 2) exito = true;
    else if (primo % 2 == 0) exito = false;

    int i = 3;

    while (exito == true && i * i <= primo) {
        if (primo % i == 0) exito = false;
        i += 2;
    }
    return exito;
}