#include <xinu.h> 
#include <string.h> 

#define ES_PAR(x) (((x) % 2) == 0) 

void leer_p(void);
void procesar_p(void);

char palindromo[80];
int n = 0; // Cant letras
pid32 ppid;

void es_palindromo(void)
{
    ppid = getpid();

    control(CONSOLE, TC_MODER, 0, 0);
    resume(create(leer_p, 1024, 20, "leer", 0));
    receive();

    resume(create(procesar_p, 1024, 20, "procesar", 0));
    receive();
    control(CONSOLE, TC_MODEC, 0, 0);
}

void leer_p(void)
{
    int c;

    c = getc(CONSOLE);

    while(c!=13)
    {
        palindromo[n] = c;
        n++;
        c = getc(CONSOLE);
    }

    palindromo[n] = '\0';
    n--;

    send(ppid, 1);
}

void procesar_p(void)
{
    int exito = 1, longitud = n/2;

    for (int i = 0; i <= longitud; i++)
    {
        if(palindromo[i]!=palindromo[n])
        {
            exito = 0;
            break;
        }
        n--;
    }
    

    if(exito == 1)
    {
        kprintf("\nLa cadena %s es palindromo", palindromo);
    }
    else
    {
        kprintf("\nLa cadena %s NO es palindromo", palindromo);
    }

    send(ppid, 1);
}