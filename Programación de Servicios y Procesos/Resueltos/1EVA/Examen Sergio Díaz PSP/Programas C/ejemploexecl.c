#include <unistd.h>
#include <stdio.h>
#include <errno.h>

void main()
{
	printf("Lista de procesos\n");
	if (execl("/bin/pst", "ps", "-f", (char *)NULL) < 0)
	   printf("Error al ejecutar el execl %d\n", errno);
	else
	   printf("Fin de la lista de procesos\n");
}//main
