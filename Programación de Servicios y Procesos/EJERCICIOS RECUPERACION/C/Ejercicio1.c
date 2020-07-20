#include <signal.h> 
#include <stdio.h> 
#include <stdlib.h> 
#include <sys/types.h> 
#include <unistd.h> 
#include <wait.h>

// Metodo que muestra el mensaje
void msg(int segnal) {
	printf("La señal se ha enviado al padre correctamente. Señal: %i\n", segnal);
} 

int main() {
    // Variable que almacenara el PID del proceso creado
	int pid_hijo;
    // Creamos el proceso hijo y guardamos su PID
	pid_hijo = fork();

	switch(pid_hijo) {
        // Si se produce algun error..
		case -1:
			printf("Error al crear el hijo...\n");
            // Terminamos el programa
			exit(-1);
        // Si estamos en el proceso hijo
		case 0:
            // Enviamos una señal SIGUSR2 al proceso padre
			kill(getppid(), SIGUSR2);
            // Esperamos
			sleep(1);
            printf("Terminamos el proceso padre.\n");
            // Mandamos una señal SIGKILL al proceso padre para terminar el proceso
			kill(getppid(), SIGKILL);
			break;
        // Si estamos en el proceso padre
		default:
            // Capturamos la señal SIGUSR2 e invocamos el metodo msg para mostrar un mensaje
			signal(SIGUSR2, msg);
			while(1);
			break;
	}//switch

}//main
