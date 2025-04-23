/*
1. Implemente un proceso llamado “control_race” que controla los procesos realizando esa carrera. Para eso,
control_race debe crear y poner a ejecutar los tres programas en carrera.c.
2. Agregue el programa control al shell de Xinu. Todos los procesos tienen prioridad 20. Utilice como tamaño
de pila mínimo para cada proceso 1024 bytes.
3. Luego, el proceso control_race debe permitirle al usuario gestionar los procesos que corren de la siguiente
manera:
○ Si el usuario presiona la tecla 1, el proceso corredor_a se suspende/reanuda.
○ Si el usuario presiona la tecla 5 el proceso corredor_a muere.
○ Si el usuario presiona la tecla 2 el proceso corredor_b se suspende/reanuda.
○ Si el usuario presiona la tecla 6 el proceso corredor_b muere.
Implemente las pulsaciones del teclado (teclas 1, 2, 5, y 6). A partir de las pulsaciones
“control_race” realiza las acciones mencionadas (suspender/reanudar, matar).
*/

// #include <xinu.h>

#define ASCII_ESC 27
#define TC_SETRAW 1001
#define TC_SETNORMAL 1002

int vel_a = 0;
int vel_b = 0;

corredor_a()
{
	while(1) {
		vel_a++;
	}

}

corredor_b()
{

	while(1) 
    {
		vel_b++;
	}
}


muestra_carrera() 
{
	/* limpiar toda la pantalla */
	printf( "%c[2J", ASCII_ESC );

	while(1) 
    {
		/* Nos posicionamos en la fila 5 columna 10 */
    		printf( "%c[5;10f", ASCII_ESC );
    		printf( "Velocidad corredor A: %d \n", vel_a);

		/* Nos posicionamos en la fila 6 columna 10 */
    		printf( "%c[6;10f", ASCII_ESC );
    		printf( "Velocidad corredor B: %d \n", vel_b);

		sleepms(50);
	}


}


shellcmd carrera(int nargs, char *args[])
{

    int c;
    int a = 0, b = 0;

    int pid_a = create(corredor_a, 1024, 20, "send A", 1);
    int pid_b = create(corredor_b, 1024, 20, "send B", 1);

    resume(pid_a);
	resume(pid_b);
    resume(create(muestra_carrera, 1024, 20, "send B", 1));

    control(CONSOLE, TC_SETRAW, 0, 0);

    while (1)
    {

        c=getc(CONSOLE);

        switch (c)
        {
        case 1:
        
            if(a == 0)
            {
                suspend(pid_a);
                a = 1;
            }
            else
            {
                resume(pid_a);
                a = 0;
            }

            break;
        
        case 2: 

        if(b == 0)
        {
            suspend(pid_a);
            b = 1;
        }
        else
        {
            resume(pid_a);
            b = 0;
        }

            break;

        case 5: 
            
            kill(pid_a, SIGKILL);

            break;

        case 6: 

            kill(pid_b, SIGKILL);

            break;

        default:
            c = -1;

            break;
        }

        if(c==-1) break;
    }

    control(CONSOLE, TC_SETNORMAL, 0, 0);

    char ganador = 'a'; 

    if(b > a) ganador = 'b';

    kprintf("El ganador es el corredor %c", ganador);
}