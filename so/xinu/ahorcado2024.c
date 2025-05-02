#include <xinu.h>
#include <string.h>

void entrada(void);
void computo(void);
void visual(void);
void fin(void);

char palabra[] = "linux", adivinado[27];
int n; // cant letras
pid32 epid, cpid;

void entrada(void){
    
    int c;
    control(CONSOLE, TC_MODER, 0, 0);

    while(1){

        c = getc(CONSOLE);

        send(cpid, c);
        
    }

}

void computo(void){

    while(1){

        char c = receive();
        int esta = 0; 

        for (int i = 0; i < n; i++){
            if(c == adivinado[i]){
                esta = 1;
                break;
            }
        }
        
        if(palabra[i]){

        }
    }

}