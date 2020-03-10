#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>

/* Gestion de señales en proceso padre. */
void gestion_padre(int segnal) {

	printf("Padre recibe señal.. %d\n", segnal);

}

void gestion_hijo (int segnal) {

	printf("Hijo recibe señal..%d\n", segnal);

}

int main() {

	int pid_padre, pid_hijo;

	pid_padre = getpid();
	pid_hijo = fork(); //se crea el hijo

	switch(pid_hijo) {

		case -1:
			printf("Error al crear el proceso hijo...\n");
			exit(-1);

		case 0:
			//tratamiento de señal en proceso hijo
			signal (SIGUSR1, gestion hijo);
			while(1){

				sleep(1);
				kill(pid_padre, SIGUSR1) //ENVIA SEÑAL AL PADRE
				pause();//hijo espera hasta que llegue una señal de respuesta

			}//while
			break;

		default: //PADRE

	}//switch

}//main
