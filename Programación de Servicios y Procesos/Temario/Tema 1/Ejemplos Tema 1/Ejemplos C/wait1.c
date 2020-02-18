#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <stdio.h>


#define NUM_CHILD 5

int doSomething(void) {
    int ret;

    // Semilla sobre la que usar el rand
    srand(getpid());
    ret = (rand() % 256);
    printf("Hijo: PID = %d, valor aleatorio calculado %d \n", getpid(), ret);

    return ret;
}

int main (void) {

    pid_t pidC;
    int status;

    for (int i = 0; i < NUM_CHILD; i++) {
        // Creamos un hijo
        pidC = fork();
        // Si estamos en el padre seguimos creando hijos
        if(pidC > 0) 
            continue;
        // Si estamos en el hijo
        else if(pidC == 0) {
            exit(doSomething());
        }
        else {
            printf("Error al crear el hijo");
        }
    }

    printf("sigue la vaina");
    
    for (int i = 0; i < NUM_CHILD; i++) {
       pidC = wait(&status);
       printf("PADRE de PID = %d, hijo de de PID %d terminado. Estado = %d \n", getpid(), pidC, WEXITSTATUS(status));
    }

    // Bucle infinito 
    while(1) {
        sleep(10);
    }

    return 0;
}