#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{

    char palabra[] = "arquitectura";
    char adivinadas[27] = "";
    char actual[100] = "";
    int longitud = strlen(palabra);
    int intentos = 6;
    int aciertos = 0;
    int c;

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
    actual[longitud*2 - 1] = '\0';

    /* Decirle al sistema que el modo input es RAW */
    system("/bin/stty raw");    

    while (intentos > 0 && aciertos < longitud)
    {
        printf("\nPalabra: %s\n", actual);

        printf("\r                                                          ");
        printf("\rIngrese una letra (0 para salir): ");
        c = getchar();
        getchar();

        if (c == '0')
        {
            break;
        }

        if (strchr(adivinadas, c))
        {
            printf("\nYa probaste esa letra.\n");
        }
        else
        {
            char letraStr[2] = {c, '\0'}; // crea una "cadena" con 1 letra y '\0'
            strncat(adivinadas, letraStr, 1);

            if (strchr(palabra, c))
            {
                printf("\nBien! La letra esta en la palabra.\n");

                for (int i = 0; i < longitud; i++)
                {
                    if (palabra[i] == c)
                    {
                        actual[i * 2] = c;
                        aciertos++;
                    }
                }
            }
            else
            {
                printf("\nIncorrecto. Esa letra no esta.\n");
                intentos--;
                if (intentos == 1)
                {
                    printf("\nTe queda 1 intento!");
                }
                else
                {
                    printf("\nTe quedan %d intentos!\n", intentos);
                }
            }
        }
    }

    if (aciertos == longitud)
        printf("\nGanaste! La palabra era \"%s\".\n", palabra);
    else
        printf("\nPerdiste. La palabra era \"%s\".\n", palabra);
    
    system("/bin/stty sane erase ^H");
}
