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

#include <xinu.h>
#define ASCII_ESC 27

void corredor_a();
void corredor_b();
void muestra_carrera();
void control_race();

int vel_a = 0;
int vel_b = 0;

void carrera()
{
    resume(create(control_race, 1024, 20, "control", 0));
}

void corredor_a()
{
	while(1) {
		vel_a++;
	}

}

void corredor_b()
{

	while(1) 
    {
		vel_b++;
	}
}

void muestra_carrera() 
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

void control_race()
{
    int a = 0, b = 0, c, d = 0;

    int pid_a = create(corredor_a, 1024, 20, "corredor_a", 0);
    int pid_b = create(corredor_b, 1024, 20, "corredor_b", 0);
    int pid_mu = create(muestra_carrera, 1024, 20, "muestra", 0);

    resume(pid_mu);
    resume(pid_a);
	resume(pid_b);

    kprintf("Ingrese un valor 1, 2, 5 o 6 para finalizar");
	control(CONSOLE, TC_MODER, 0, 0);

    while (1)
    {

        c=getchar();

        switch (c)
        {
        case 1:
        
            if(a == 0)
            {
                suspend(pid_a);
                a = 1;
                c++;
                if(c == 2) // Ambos procesos suspend
                {
                    suspend(pid_mu);
                }
            }
            else
            {
                if(c == 2) // Muestra en suspend
                {
                    resume(pid_mu);
                }
                resume(pid_a);
                a = 0;
                c--;
            }

            break;
        
        case 2: 

        if(b == 0)
        {
            suspend(pid_b);
            b = 1;
            c++;
            if(c == 2) suspend(pid_mu); // Ambos procesos suspend
        }
        else
        {
            if(c == 2) resume(pid_mu); // Muestra en suspend
            resume(pid_b);
            b = 0;
            c--;
        }

            break;

        case 5: 
            
            kill(pid_a);
            a = -1;
            if(b == -1) c = -1;

            break;

        case 6: 

            kill(pid_b);
            b = -1;
            if(a == -1) c = -1;

            break;

        default:
            c = -1;

            break;
        }

        if(c == -1)
        {
            kill(pid_mu);
            break;
        } 
    }

	control(CONSOLE, TC_MODEC, 0, 0);

    char ganador = 'a'; 

    if(vel_b > vel_a) ganador = 'b';

    kprintf("El ganador es el corredor %c", ganador);
}