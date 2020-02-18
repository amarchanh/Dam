#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>

int main (void) {

    int fd, n;
    char buf[1024];

    fd = open("/tmp/mi_fifo", O_RDONLY);

    n = read(fd, buf, sizeOF(buf));

    printf("Nr bytes: %d.\n", n);
    printf("RX mensaje: %s.\n", buf);

    close(fd);

    return 0;
}