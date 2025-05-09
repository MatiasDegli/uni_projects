#include <xinu.h>

void entrada(void);
void computo(void);
void visual(void);
void fin(void);

char palabra[] = "linux";
const int longitud = sizeof(palabra) - 1;
char adivinado[27] = "", actual[80] = "";

int n = 0, vidas = 6, correctas = longitud; // n: cant letras

pid32 epid, cpid, vpid, fpid;

void entrada(void)
{
    int c;
    control(CONSOLE, TC_MODER, 0, 0);

    while (1)
    {
        c = getc(CONSOLE);
        send(cpid, c);
        receive();
    }
}

void computo(void)
{
    while (1)
    {
        char c = (char)receive();
        int esta = 0;

        for (int i = 0; i < n; i++)
        {
            if (adivinado[i] == c)
            {
                esta = 1;
                break;
            }
        }

        if (esta == 0)
        {
            for (int i = 0; i < longitud; i++)
            {
                if (palabra[i] == c)
                {
                    actual[i*2] = palabra[i];
                    correctas--;
                    esta = 1;
                }
            }

            if (esta == 0)
            {
                vidas--;
            }
        }
        else
        {
            adivinado[n] = c;
            n++;
            adivinado[n] = '\0';
        }

        send(epid, 1);
    }
}

void visual(void)
{
    while (1)
    {
        kprintf("\nPalabra: %s | Vidas: %d", actual, vidas);
        sleepms(1000);
    }
}

void fin(void)
{

    while (1)
    {
        sleepms(2000);

        if (vidas <= 0)
        {
            kprintf("PERDIO");
            break;
        }
        else if (correctas == 0)
        {
            kprintf("GANO");
            break;
        }
    }

    control(CONSOLE, TC_MODEC, 0, 0);

    kill(epid);
    kill(cpid);
    kill(vpid);
    kill(getpid());
}

void ahorcado(void)
{

    for (int i = 0; i < longitud * 2; i++)
    {
        if (i % 2 == 0)
        {
            actual[i] = '_';
        }
        else
        {
            actual[i] = ' ';
        }
    }
    actual[longitud * 2 - 1] = '\0';

    epid = create(entrada, 1024, 20, "entrada", 0);
    cpid = create(computo, 1024, 20, "computo", 0);
    vpid = create(visual, 1024, 20, "visual", 0);
    fpid = create(fin, 1024, 20, "fin", 0);

    resume(epid);
    resume(cpid);
    resume(vpid);
    resume(fpid);
}
