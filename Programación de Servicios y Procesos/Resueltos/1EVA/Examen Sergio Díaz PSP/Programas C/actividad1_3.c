#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>

int manejador(int segnal) {

	printf("La señal se ha enviado al padre correctamente..%i\n", segnal);

} //manejador
int main() {
	int pid_hijo;
	pid_hijo = fork();

	switch(pid_hijo) {

		case -1:
			printf("Error al crear el hijo...\n");
			exit(-1);
		case 0:
			kill(getppid(), SIGUSR2);
			sleep(1);
			kill(getppid(), SIGUSR1);
			sleep(1);
			kill(getppid(), SIGUSR2);
			sleep(1);
			kill(getppid(), SIGKILL);
			break;

		default:
			signal(SIGUSR1, manejador);
			signal(SIGUSR2, manejador);
			while(1);
			break;
	}//switch

}//main
