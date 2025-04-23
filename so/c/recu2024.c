/*
Ejercicio 1. Implementación de procesos en LINUX.
Desarrollar un programa en linux que genere dos procesos hijos. El primer proceso calcula números primos
infinitamente. El segundo proceso calcula años bisiestos infinitamente. Ambos hijos van mostrando un mensaje del
primo o año bisiesto calculado. Ejemplo: “soy el proceso X nro primo: 31”. El padre de los dos hijos finaliza al
segundo hijo a los 4 segundos, y finaliza al primer hijo luego de 8 segundos. Luego, el padre finaliza.
*/

#include <stdio.h> // Funciones de entrada/salida estándar
#include <stdlib.h> // Funciones generales de la biblioteca estándar
#include <unistd.h> // Acceso a la API de sistemas POSIX (sistemas Unix/Linux), ej. fork()
#include <signal.h> // Manejo de señales entre procesos, ej. kill()

int main()
{
 
    int pid_hijo = fork();

    if(pid_hijo == 0)
    {
        proceso_biciesto();
    }
    else if(pid_hijo > 0)
    {
        int pid_hijo2 = fork();
        
        if(pid_hijo2 == 0)
        {
            proceso_primos();
        }
        else if(pid_hijo2 > 0)
        {   
            sleep(4);
            kill(pid_hijo, SIGKILL);
            sleep(4);
            kill(pid_hijo2, SIGKILL);
        }
    }
}

void proceso_biciesto()
{
    int year = 1;

    while(1)
    {
        siguiente_biciesto(year);
        printf("El hijo2 esta en el año: %d", year);    
    }
}

int es_bisiesto(int year)
{
    return ( (year % 4 == 0 && year % 100 != 0)
          || (year % 400 == 0) );
}

int siguiente_bisiesto(int year)
{
    int y = year + 1;
    while (es_bisiesto(y)!=1) {
        y++;
    }
    return y;
}

void proceso_primos()
{
    int n = 1;
    while(1)
    {
        
    }
}

int siguientePrimo(int primo) {
    if (primo != 2) {
        primo += 2;
        while (esPrimo(primo)!=1) 
        {
            primo += 2;
        }
    } else {
        primo = 3;
    }
    return primo;
}

int esPrimo(int n) {
    int es=1;
    if (n <= 1) es = 0;
    else if (n == 2) es = 1;
    else if (n % 2 == 0) es = 0;

    for (int i = 3; i * i <= n; i += 2) {
        if (n % i == 0)
        {
            es = 0;
            break;
        }
    }
    return es;
}