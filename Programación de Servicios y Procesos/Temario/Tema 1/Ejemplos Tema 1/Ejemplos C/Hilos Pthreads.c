#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>


// Para compilar:
// gcc "nombre del fichero".c -pthread

// Para ejecutar: 
//./a.out 7 
// Funcion que ejecutara el hilo
void *thread_routine (void *arg) {

    // Numero de lineas que se escribiran en el fichero. Se recupera del argumento escrito por consola
    int nr_lines = *((int*) arg);
    // File Descriptor del fichero
    int fd;

    char buf[] = "Nueva linea \n";

    printf("El hilo comienza a ejecutarse... \n");

    for(int i = 0; i < nr_lines; i++) {
        // O_WRONLY = modo escritura; O_APPEND = cada vez que se abre se añade una linea

        fd = open("Ruta del archivo", O_WRONLY | O_APPEND); 
        if (fd == -1) {
            prinf("Error al abrir el archivo");
        }
        else {
            write(fd, buf, sizeof(buf) -1);
            close(fd);
        }

    }
}

// Argumentos de entrada: argc = numero de argumentos que le pasamos por terminal de consola (entero)
// argv: argumenos pasados
int main (int argc, char *argv[]) {

    pthread_t thread1;
    // Recupera los argumentos que se pasan por la consola (como segundo argumento, ya que el pimero
    // sera el nombre del fichero). Este valor se pasa a la funcion y sera el numero de lineas
    // que se escribiran en el fichero
    int value;
    if(argc > 1) {
        value =  atoi(argv[1]);
    }
    else {
        printf("Se te olvidó pasar un argumento, numero de lineas a escribir");
    }
    // &thread1 = puntero al hilo que acabamos de crear
    // NULL = Argumentos que se van a ejecutar al crear (NULL para que se ejecuten los que esten por defecto)
    if (0 != pthread_create(&thread1, NULL, thread_routine, &value ) {
        return -1;

        pthread_join(pthread_t thread, NULL);
    }


    return 0;
}