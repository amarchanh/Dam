#include <stdio.h>
#include <unistd.h>

void main(void)
{
	pid_t id_pActual, id_padre;

	id_pActual = getpid();
	id_padre = getppid();

	printf("PID del proceso actual es: %d\n", id_pActual);
	printf("PID del proceso padre es: %d\n" , id_padre);
}

