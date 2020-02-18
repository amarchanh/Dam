#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>

int main (void) {

    int fd [2]; // File descriptor
    pid_t pidC; // PID para creacion de hijos
    char buf[10]; // Buffer donde se almacenaran los caracteres a leer
    int num;
    int comp = pipe(fd);  // Comprobacion del resultado del pipe

    if (comp == 0) {
        pidC = fork();
        switch(pidC) {
            case 0 : // Se esta ejecutando el hijo
                close(fd[0]); // Cerramos el FileDescriptor de lectura
                write(fd[1], "abcde", 5); // Escribimos
                close(fd[1]); // Cerramos el FileDescriptor de escritura
                break;
            case -1: // Error al crear el hijo
                break;
            default: // Si no es 0 ni un numero negativo, se esta ejecutando el padre
                close(fd[1]); // Cerramos el FileDescriptor de Escritura
                read(fd[0], buf, sizeof(buf)); // Leemos
                printf("El padre lee lo que escribe el hijo, %s" , buf);
                close(fd[0]); // Cerramos el FileDescriptor de Lectura
                break;

        }
    }
    else {
        printf("Ha ocurrido un error al crear el pipe.");
    }


    return 0;
}