/*Desarrollar un programa en XINU que genere dos procesos para mostrar números primos. Un proceso
debe mostrar los primos del 1 al 5000, y el segundo proceso del 5000 al 10000.*/

#include <stdio.h>   // Funciones de entrada/salida estándar
#include <stdlib.h>  // Funciones generales de la biblioteca estándar
#include <unistd.h>  // Acceso a la API de sistemas POSIX (sistemas Unix/Linux), ej. fork()
#include <stdbool.h> // para usar bool, true, false

// prototipos
bool esPrimo(int n);
int siguientePrimo(int primo);

int main()
{
    int min, max;
    int pidHijo = fork();

    if (pidHijo != 0)
    {
        min = 1;
        max = 5000;
        printf("Proceso padre mostrando primos de %d a %d:\n", min, max);
    }
    else
    {
        min = 5000;
        max = 10000;
        printf("Proceso hijo mostrando primos de %d a %d:\n", min, max);
    }

    int primo = min;
    
    if(!esPrimo(primo)){
        primo = siguientePrimo(primo);
    }
    
    while (primo <= max)
    {
        printf("%d es primo", primo);  
        primo = siguientePrimo(primo);
    }

    return 0;
}

// Verifica si un número es primo
bool esPrimo(int n)
{
    if (n <= 1)
        return false;
    if (n == 2)
        return true;
    if (n % 2 == 0)
        return false;

    for (int i = 3; i * i <= n; i += 2)
    {
        if (n % i == 0) return false;
    }
    return true;
}

// Encuentra el siguiente primo después de "primo"
int siguientePrimo(int primo)
{
    if (primo > 2)
    {
        primo += 2;
        while (!esPrimo(primo))
        {
            primo += 2;
        }
    }
    else if (primo < 2)
    {
        return 2;
    }
    else
    {
        return 3;
    }
    return primo;
}