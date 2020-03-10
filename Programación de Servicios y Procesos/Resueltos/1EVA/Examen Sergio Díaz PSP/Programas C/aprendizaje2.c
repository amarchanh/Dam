#include "stdio.h"
#include "stdlib.h"
#include "unistd.h"
#include "string.h"

void main() {

	int fd1[2];
	int fd2[2];
	char buffer[70];
	char padre[] = "Buenos dias hijo\0";
	char hijo[] = "Buenos dias padre\0";
	pid_t pid;
	pipe(fd1);
	pipe(fd2);
	pid = fork();

	switch(pid){
		case -1://FALLO
			exit(-1);

		case 0: //Dentro del hijo
			close(fd2[0]);
			printf("El hijo escribe al padre:\n");
			write(fd2[1], hijo, sizeof(hijo));
			close(fd1[1]);
			printf("El hijo recibe del padre:\n");
			read(fd1[0], buffer, sizeof(buffer));
			printf("%s\n",buffer);
			break;
		default: //Padre
			close(fd2[1]);
			printf("El padre recibe del hijo:\n");
			read(fd2[0], buffer, sizeof(buffer));
			printf("%s \n", buffer);
			close(fd1[0]);
			printf("El padre escribe al hijo:\n");
			write(fd1[1], padre, sizeof(padre));
			break;

	}//switch
}//main
