#include <xinu.h>
#include <string.h>

#define TC_SETRAW 1001
#define TC_SETNORMAL 1002

shellcmd ahorcado(int nargs, char *args[]) {

    char palabra[] = "arquitectura";
    char adivinadas[27] = "";
    char actual[100] = "";
    int longitud = strlen(palabra);
    int intentos = 6;
    int aciertos = 0;
    char c;

    for (int i = 0; i < longitud * 2; i++) {
        if (i % 2 == 0) {
            actual[i] = '_';
        } else {
            actual[i] = ' ';
        }
    }
    actual[longitud * 2 - 1] = '\0';

    /* Cambiar modo a RAW */
    control(CONSOLE, TC_SETRAW, 0, 0);

    while (intentos > 0 && aciertos < longitud) {
        kprintf("\nPalabra: %s\n", actual);
        kprintf("Ingrese una letra (0 para salir): ");
        
       	c = getc(CONSOLE);
	getc(CONSOLE);
				
        if (c == '0') {
            break;
        }

        if (strchr(adivinadas, c)) {
            kprintf("\nYa probaste esa letra.\n");
        } else {
            char letraStr[2] = {c, '\0'};
            strncat(adivinadas, letraStr, 1);

            if (strchr(palabra, c)) {
                kprintf("\nBien! La letra esta en la palabra.\n");

                for (int i = 0; i < longitud; i++) {
                    if (palabra[i] == c) {
                        actual[i * 2] = c;
                        aciertos++;
                    }
                }
            } else {
                kprintf("\nIncorrecto. Esa letra no esta.\n");
                intentos--;
                if (intentos == 1) {
                    kprintf("\nTe queda 1 intento!\n");
                } else {
                    kprintf("\nTe quedan %d intentos!\n", intentos);
                }
            }
        }
    }

    if (aciertos == longitud) {
        kprintf("\nGanaste! La palabra era \"%s\".\n", palabra);
    } else {
        kprintf("\nPerdiste. La palabra era \"%s\".\n", palabra);
    }

    /* Volver al modo normal */
    control(CONSOLE, TC_SETNORMAL, 0, 0);

    return OK;
}
