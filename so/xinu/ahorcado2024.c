#include <xinu.h>
#include <string.h>

void entrada(void);
void computo(void);
void visual(void);
void fin(void);

char palabra[] = "linux";
const int longitud = sizeof(palabra)-1;
char adivinado[27], actual[80];

int n; // cant letras

pid32 epid, cpid;

void entrada(void){
    
    epid = getpid();
    int c;
    control(CONSOLE, TC_MODER, 0, 0);

    while(1){

        c = getc(CONSOLE);
        send(cpid, c);
        receive();
        
    }

    control(CONSOLE, TC_MODEC, 0, 0);

}

void computo(void){

    cpid = getpid();

    while(1){

        char c = (char) receive();
        int esta = 0; 

        for (int i = 0; i < n; i++){
            if(adivinado[i] == '\0'){ // Se llega al final de la cadena
                break;
            }
            else if(c == adivinado[i]){
                esta = 1;
                break;
            }
        }
        
        if(esta == 0){
            
            for (i = 0; i < longitud; i++)
            {
                if(){

                }
            }
            
        }
        else{
            adivinado[n] = c;
            n++;
            adivinado[n] = '\0';
        }

        send(epid, 1);
    }

    void ahorcado(void){
        
    }

}
