#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>

// Variable global que cambiara de valor en el hijo y en el padre
int var = 22;

int main(void) {
    pid_t pidC; 
    printf("** proc. PID = %d comienza ** \n", getpid());
    
    pidC =  fork();

    printf("** proc. PID = %d, pidC = %d ejecutandose \n" , getpid(), pidC);

    if (pidC > 0) {
        var = 44;
    }
    else if (pidC == 0) {
        var = 33;
    }
    else {
        printf("Error, el hijo no ha podido ser creado.");
    }


    while(1) {
        sleep(2);
        printf("** proc. PID = %d, var = %d \n", getpid(), var);
    }
    return 0;
}