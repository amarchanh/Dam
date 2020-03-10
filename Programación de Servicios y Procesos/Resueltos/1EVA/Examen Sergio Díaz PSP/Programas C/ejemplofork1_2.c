#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
//ABUELO-HIJO-NIETO
void main()
{
	pid_t pid, hijo_pid, pid2, hijo2_pid;

	pid = fork(); //Soy el Abuelo, creo a Hijo

	if (pid == -1) //Ha ocurrido un error
	{
		printf("No se ha podido crea el proceso hijo...");
		exit(-1);
	}

	if (pid == 0) //Nos encontramos en Proceso hijo
	{
		pid2 = fork(); //Soy el Hijo, creo a Nieto
		switch(pid2)
		{
			case -1: //error
				printf("No se ha podido crear el proceso hijo en el HIJO...");
				exit(-1);
				break;
			case 0: //proceso hijo
				printf("\tSoy el proceso NIETO %d, Mi padre es = %d \n", getpid(), getppid());
				break;
			default: //proceso padre
				hijo2_pid = wait(NULL);
				printf("\tSoy el proceso HIJO %d, Mi padre es: %d.\n", getpid(), getppid());
				printf("\t Mi hijo: %d terminó.\n", hijo2_pid);

		}
	}

	else //Nos encontramos en Proceso padre
	{
		hijo_pid = wait(NULL);
		printf("Soy el proceso ABUELO: %d, Mi HIJO: %d terminó.\n", getpid(), pid);
	}
	exit(0);
}//main
