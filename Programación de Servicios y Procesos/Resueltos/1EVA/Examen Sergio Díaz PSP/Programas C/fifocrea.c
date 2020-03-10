#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main() {
	int fp;
	int p, bytesleidos;
	char saludo[] = "Un saludo!!!\n", buffer[10];

	p = mkfifo("FIFO2", S_IFIFO|0666); //permiso de lectura y escritura

	if (p == -1) {
		printf("HA OCURRIDO UN ERROR...\n");
		exit(0);
	} //if

	while(1) {
		fp = open("FIFO2", 0);
		bytesleidos = read(fp, buffer, 1);
		printf("OBTENIDO Información...");

		while (bytesleidos!=0) {
			printf("%lc", buffer[0]); //pinto el byte leido
			bytesleidos = read(fp, buffer, 1); //leo otro byte
		} //while

		close(fp);

	}//while

	return(0);
} //main
