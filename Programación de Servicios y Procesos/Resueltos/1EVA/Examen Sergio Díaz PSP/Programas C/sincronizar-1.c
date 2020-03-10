#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>

/* Gestión de señales en proceso HIJO */
void manejador (int segnal) {

	printf("Hijo recibe señal..%d\n", segnal);

} //function


int main() {

	int pid_hijo;
	pid_hijo = fork(); //creamos hijo

	switch(pid_hijo) {

		case -1:
			printf ("Error al crear el proceso hijo...\n");
			exit(-1);
		case 0: //Hijo
			signal(SIGUSR1, manejador); //MANEJADOR DE SEÑAL EN HIJO
			while(1) {
			}
			break;
		default: //PADRE envia 2 señales
			sleep(1);
			kill(pid_hijo, SIGUSR1); //ENVIA SEÑAL AL HIJO
			sleep(1);
			kill(pid_hijo, SIGUSR1); //ENVIA SEÑAL AL HIJO
			sleep(1);
			break;

	} //switch

	return 0;

} //main
