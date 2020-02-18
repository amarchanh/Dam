#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>

int main (void) {

    int fd;
    char buf[] = "mensaje 1...";

    mkfifo("/tmp/mi_fifo", 0666); //  0666 = permisos de lectura y escritura

    fd = open("/tmp/mi_fifo", O_WRONLY);

    printf("Escribiendo mensaje...");

    write(fd, buf, sizeof(buf));

    close(fd);

    return 0;
}