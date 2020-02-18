#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>

int main (void) {

    int fd;
    char buf[10]; // numero de bytes que se almacenaran en memoria
    int count = 5; // maximo numero de caracteres que se leeran del archivo
    ssize_t nr_bytes; // numero de bytes que contiene el archivo

    fd = open("ruta del archivo", O_RDONLY);

    if (fd == -1) {
        printf("Error al abrir el archivo \n")
    } 
    else {
        printf("Archivo abierto con éxito \n");
        nr_bytes = read(fd, buf, count);
        close(fd);
        if(nr_bytes == 0) {
            printf("Archivo vacio \n");
        }
        else {
            printf("El numero de caracteres es %d, y el contenido del ficehero es %s \n", (int) nr_bytes, buf);
        }
    }
    return 0;
}