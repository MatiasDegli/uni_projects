/* primos entre el nÃºmero 1 y MAX */
#include <xinu.h>

#define MAX 500000

pid32 pid_control;
int finalizado = 0;

void primos_5000(void)
{
    int i, n, primo;
    kprintf("\n   ");

    for (i = 1; i <= 5000; i++)
    {
        primo = 1;
        n = 2;

        while (n <= i / 2 && primo)
        {
            if (i % n == 0)
                primo = 0;

            n++;
        }

        if (primo)
            kprintf("%d ", i);
    }

    finalizado++;

    send(pid_control);
}

void primos_9999(void)
{
    int i, n, primo;
    kprintf("\n   ");

    for (i = 5001; i <= 9999; i++)
    {
        primo = 1;
        n = 2;

        while (n <= i / 2 && primo)
        {
            if (i % n == 0)
                primo = 0;

            n++;
        }

        if (primo)
            kprintf("%d ", i);
    }

    finalizado++;

    send(pid_control);
}

void control(void)
{
    pid_control = getpid();

    pid32 pid_liviano = create(primos_5000, 1024, 10, "encontrar", 0);
    pid32 pid_pesado = create(primos_9999, 1024, 20, "encontrar", 0);
    resume(pid_pesado);
    resume(pid_liviano);

    while (1)
    {
        sleepms(80);
        if (finalizado == 0)
            chprio(pid_pesado, 5);
        else
            break;

        sleepms(20);
        if (finalizado == 0)
            chprio(pid_pesado, 20);
        else
            break;
    }

    receive();
    receive();

    kprintf("finalizado : %i \n", finalizado);
}

void creacion_primos(void)
{
    resume(create(control, 1024, 30, "control", 0));
}