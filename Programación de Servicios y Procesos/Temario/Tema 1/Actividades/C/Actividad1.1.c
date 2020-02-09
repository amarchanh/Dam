#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
    pid_t pid, Hijo_pid;
    pid = fork();

    int a = 6;

    printf("Valor inicial de la variable: %i\n", a);
    if (pid == -1) { // Ha ocurrido un error
        printf("No se ha podido crear el proceso hijo...");
        exit(-1);
    }
    if (pid == 0) { // Nos encontramos en Proceso Hijo
        int b = a-5;
        printf("Variable en el proceso Hijo: %i\n", b);
    }
    else {
        Hijo_pid = wait(NULL); //espera la finalización del proceso hijo
        int c = a+5;
        printf("Variable en el proceso Padre: %i\n", c);
    }
    exit(0);
}