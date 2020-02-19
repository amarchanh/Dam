#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

/*
    Realizar un programa en C que cree un pipe en el que el hijo envíe un mensaje al padre.
    Es decir, la información fluya del hijo al padre. La ejecucion debe mostrar la siguiente salida:

    administrador@ubuntu:~$ gcc actividad1_2.c -o actividad1_2
    administrador@ubuntu:~$ ./activdidad1_2
        El Hijo envia algo al Pipe
    El PADRE recibe algo del pipe: Buenos dias padre.
    administrador@ubuntu:~$ 
*/

int main (void) {

    int fd[2];
    pid_t pid;
    char saludoPadre[] = "Buenos dias padre.\0";
    char buffer[80];

    pipe(fd);
    pid = fork();

    switch(pid) {
        case -1: // ERROR
            printf("NO SE HA PODIDO CREAR EL HIJO");
            exit(-1);            

        case 0: // Entra el Padre
            read(fd[0], buffer, sizeof(buffer)); // Leemos el pipe
            close(fd[0]); // Cierra el puerto de lectura
            printf("\tEl PADRE recibe algo del pipe: %s\n", buffer);
            
            break;

        default: // Entra el Hijo
            close(fd[0]); // Cerramos el descriptor de entrada
            printf("El hijo escribe algo\n");
            write(fd[1], saludoPadre, strlen(saludoPadre)); // Escrimos en el pipe
           
            break;

    }

    return 0;
}
