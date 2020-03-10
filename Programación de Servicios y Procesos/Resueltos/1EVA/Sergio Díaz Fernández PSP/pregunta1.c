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
			close(fd1[1]);
			printf("El hijo recibe del padre:\n");
			read(fd1[0], buffer, sizeof(buffer));
			printf("%s \n", buffer);
			close(fd2[0]);
			printf("El hijo envía al padre:\n");
			write(fd2[1], hijo, sizeof(hijo));
			break;
		default: //Padre
			close(fd1[0]);
			printf("El padre envía al hijo:\n");
			write(fd1[1], padre, sizeof(padre));
			close(fd2[1]);
			wait(NULL);
			printf("El padre recibe del hijo:\n");
			read(fd2[0], buffer, sizeof(buffer));
			printf("%s \n", buffer);
			break;

	}//switch
}//main
