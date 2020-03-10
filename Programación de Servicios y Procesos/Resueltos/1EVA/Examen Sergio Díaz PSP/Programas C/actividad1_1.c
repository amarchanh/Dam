#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
void main()
{
	pid_t pid, hijo_pid;
	int numero = 6;
	printf("Valor inicial de la variable: %d", numero);
	printf("\n");
	pid = fork();

	if (pid == -1) // Ha ocurrido un error
	{
		printf("No se ha podido crear el proceso hijo...");
		exit(-1);
	}
	if (pid == 0) //Nos encontramos en Proceso hijo
	{
		printf("Variable en proceso Hijo: %d", numero - 5);
		printf("\n");
	}
	else //Nos encontramos en el proceso padre
	{
		hijo_pid = wait(NULL); //espera la finalización del proceso hijo
		printf("Variable en proceso Padre: %d", numero + 5);
		printf("\n");
	}
	exit(0);
}
