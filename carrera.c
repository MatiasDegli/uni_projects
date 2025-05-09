#include <xinu.h>

#define ASCII_ESC 27

int vel_a = 0;
int vel_b = 0;

void corredor_a(void)
{
    while (1)
    {
        vel_a++;
    }
}

void corredor_b(void)
{

    while (1)
    {
        vel_b++;
    }
}

void muestra_carrera(void)
{
    /* limpiar toda la pantalla */
    printf("%c[2J", ASCII_ESC);

    while (1)
    {
        /* Nos posicionamos en la fila 5 columna 10 */
        kprintf("%c[5;10f", ASCII_ESC);
        kprintf("Velocidad corredor A: %d \n", vel_a);

        /* Nos posicionamos en la fila 6 columna 10 */
        kprintf("%c[6;10f", ASCII_ESC);
        kprintf("Velocidad corredor B: %d \n", vel_b);

        sleepms(50);
    }
}

void control_race(void)
{

    pid32 pid_a = create(corredor_a, 1024, 20, "corredor_a", 0);
    pid32 pid_b = create(corredor_b, 1024, 20, "corredor_b", 0);
    pid32 pid_m = create(muestra_carrera, 1024, 20, "muestra", 0);

    resume(pid_m);
    resume(pid_a);
    resume(pid_b);

    int c, muerto = 0, suspendido = 0; // El num 1 se reserva para a, el 2 para b, el 3 para ambos

    control(CONSOLE, TC_MODER, 0, 0);

    while (muerto < 3)
    {

        c = getc(CONSOLE);

        switch (c)
        {
        case 1:
            if (muerto != 1)
            {
                if (suspendido != 1 && suspendido != 3)
                {
                    suspend(pid_a);

                    if (suspendido == 2)
                        suspendido = 3;
                    else
                        suspendido = 1;
                }
                else
                {
                    resume(pid_a);

                    if (suspendido == 3)
                        suspendido = 2;
                    else
                        suspendido = 0;
                }
            }

            break;

        case 2:
            if (muerto != 2)
            {
                if (suspendido != 2 && suspendido != 3)
                {
                    suspend(pid_b);

                    if (suspendido == 1)
                        suspendido = 3;
                    else
                        suspendido = 2;
                }
                else
                {
                    resume(pid_b);

                    if (suspendido == 3)
                        suspendido = 1;
                    else
                        suspendido = 0;
                }
            }

            break;

        case 5:
            if (muerto != 1)
            {
                kill(pid_a);
                if (muerto > 0)
                {
                    muerto = 3;
                }
                else
                {
                    muerto = 1;
                }
            }

            break;

        case 6:
            if (muerto != 2)
            {
                kill(pid_b);
                if (muerto > 0)
                {
                    muerto = 3;
                }
                else
                {
                    muerto = 2;
                }
            }

            break;

        default:
            break;
        }
    }

    control(CONSOLE, TC_MODEC, 0, 0);
    kill(pid_m);
}

void carrera(void){

    resume(create(control_race, 1024, 20, "control", 0));

}