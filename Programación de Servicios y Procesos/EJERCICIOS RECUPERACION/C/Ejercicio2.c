#include <stdio.h> 
#include <stdlib.h> 
#include <unistd.h> 
#include <wait.h>

// Haz un programa C que genere una estructura de procesos con un padre y tres hijos. Visualiza por cada hijo su PID y el del padre. 
// Visualiza también el PID del padre de todos.

int main() {
    
    // Bucle para crear 3 hijos y mostrar un mensaje
    for ( int i = 0; i < 3; i++ ) {
        // Si el proceso hijo se crea correctamente...
        if ( fork() == 0 ) {
            // Muestra un mensaje con la información
            printf( "Soy el Hijo=%d, Mi padre es= %d, Mi PID es= %d\n",(i+1), getppid(), getpid() );
            // Termina el hijo
            exit(0);
        }
    }

    // Bucle que espera hasta que terminan los 3 hijos
    for ( int i = 0; i < 3; i++ ) {
        // Espera hasta que un hijo termina
        wait( NULL );
    }

    // Muestra un mensaje mostrando el PID del padre
    printf( "Proceso PADRE= %d\n", getpid() );
}