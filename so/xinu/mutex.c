#include <xinu.h>
#include <mutex.h>

pid32 pid_caller;
int flag = 0; 

sid32 mutex_innit(void){
    flag = 1;
    pid_caller = 0;
    return semcreate(1);
}

void mutex_lock(sid32 sem){
    if(flag == 1){
        wait(sem);
        pid_caller = getpid();
        flag = 0;
    }
}

void mutex_unlock(sid32 sem){  
    if((getpid() == pid_caller) && flag == 0){
        signal(sem);
        flag = 1;
    }
}