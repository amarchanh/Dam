#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>

void MySignalHandler(int sig) {
    printf("Signal number is %d \n", sig);
}


int main (void) {

    //signal(int signum, sighandler_t handler);
    signal(SIGIO, &MySignalHandler);
    while(1) {

        printf("zzzzZZZzzz \n");
        sleep(2);

    }

    return 0;
}