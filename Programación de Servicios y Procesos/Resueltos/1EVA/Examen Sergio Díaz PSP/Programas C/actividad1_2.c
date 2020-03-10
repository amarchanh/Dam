#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main()
{

	int fd[2];
	pid_t pid;
	char saludoHijo[] = "Buenos dias mandy.\0";
	char buffer[80];
	pipe(fd); //creo pipe
	pid = fork(); //creo proceso

	switch(pid) {

		case -1: //ERROR
			printf("NO SE HA PODIDO CREAR AL HIJO...");
			exit(-1);

		case 0: //HIJO ESCRIBE
			close(fd[0]); //cierra el descriptor de entrada
			write(fd[1],saludoHijo,strlen(saludoHijo));
			printf("EL HIJO ENVIA MENSAJE AL PADRE...\n");
			break;

		default: //PADRE LEE
			wait(NULL);
			close(fd[1]);
			read(fd[0], buffer, sizeof(buffer));
			printf("\tEl PADRE recibe algo del pipe: %s\n", buffer);
			break;
	} //switch
	return 0;


}//main
