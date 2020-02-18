#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>


/*
    Realiza un programa en C que cree un proceso (tendremos 2 procesos, uno padre y uno hijo)
    El programa definirá una variable entera y le dara el valor 6. El proceso padre incrementara
    dicho valor en 5 y el proceso hijo restara 5. Se deben mostrar los valores en pantalla. 

    Ejemplo de ejecucion:
    mj@ubuntu-mj:~$ gcc actividad1.1.c -o actividad1_1
    mj@ubuntu-mj:~$ ./actividad1_1
    Valor inicial de la variable: 6
    Valor en Proceso Hijo: 1
    Valor en Proceso Padre: 11
*/
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