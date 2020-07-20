#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>

// Haz un programa C y crea los pipes necesarios para que la comunicación 
// entre un padre y un hijo fluya en ambos sentidos. 

void main() {
    // Pipe del padre
    int fd1[2];
    // Pipe del hijo
    int fd2[2];

    // Mensajes
    char saludoHijo[] = "Saludos del Hijo...\0";
    char saludoPadre[] = "Saludos del Padre...\0";
    // Buffer 
    char buffer[80] = "";

    // Para la comunicacion del padre al hijo
    pipe(fd1);
    // Para la comunicacion del hijo al padre
    pipe(fd2);

    // Si creamos el hijo y estamos en el...
    if(fork() == 0) {
        printf("Hijo envia mensaje a su padre.\n");
        // Escribimos en el pipe del padre
        write(fd1[1], saludoHijo, strlen(saludoHijo));
        // Leemos del pipe dle hijo
        read(fd2[0], buffer, sizeof(buffer));
        // Mostramos el mensaje recibido
        printf("Hijo recibe del padre: %s\n",buffer);
        // Finalizamos el hijo
        exit(0);
    }
    else {
        printf("Padre envia mensaje.\n");
        // Escribimos en el pipe del hijo
        write(fd2[1], saludoPadre, strlen(saludoPadre));
        // Leemos del pipe del padre
        read(fd1[0], buffer, sizeof(buffer));
        // Mostramos el mensaje
        printf("Padre recibe del hijo: %s\n",buffer);
    }
    
    // Terminamos el programa
    exit(0);

}